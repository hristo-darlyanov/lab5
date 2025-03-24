package lab5.commands;

import lab5.forms.UpdateForm;
import lab5.managers.CollectionManager;
import lab5.models.Movie;

/**
 * Update command
 * Updates the value of the movie by its id
 */
public class UpdateCommand implements Command {
    public CollectionManager collectionManager;

    public UpdateCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Execute of 'update' command
     */
    @Override
    public void execute(String argument) {
        try {
            Integer.parseInt(argument);
        } catch (NumberFormatException e) {
            System.out.println("Id must be an integer");
            return;
        }

        if (argument.isEmpty()) {
            System.out.println("Id must be provided");
            return;
        }
        
        int id = Integer.parseInt(argument);
        
        if (collectionManager.getCollection().stream().noneMatch(movie -> movie.getId() == id)) {
            System.out.println("There is no movie with such id");
            return;
        }
        Movie movie = collectionManager.getCollection().stream().filter(m -> m.getId() == id).findFirst().get();
        movie = UpdateForm.update(movie);
        movie.setId((long) id);
        collectionManager.getCollection().removeIf(m -> m.getId() == id);
        collectionManager.getCollection().add(movie);

        System.out.println("Movie updated");
    }
    
    /**
     * @return Info about command
     */
    @Override
    public String getInfo() {
        return "update movie by id";
    }
}
