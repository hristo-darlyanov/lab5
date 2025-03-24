package lab5.commands;

import lab5.managers.CollectionManager;
import lab5.models.Movie;

/**
 * Remove lower command
 * Removes all elements from the collection that are less than the specified one
 */
public class RemoveLowerCommand implements Command {
    CollectionManager collectionManager;

    public RemoveLowerCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Execute of 'remove_lower' command
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

        Movie selectedMovie = collectionManager.getCollection().stream().filter(movie -> movie.getId() == id).findFirst().get();

        collectionManager.getCollection().removeIf(m -> m.compareTo(selectedMovie) < 0);
        System.out.println("Movies removed from the collection");
    }

    /**
     * @return Info about command
     */
    @Override
    public String getInfo() {
        return "removes all elements from the collection that are less than the specified one";
    }
}
