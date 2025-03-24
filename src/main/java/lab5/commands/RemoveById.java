package lab5.commands;

import lab5.managers.CollectionManager;

/**
 * RemoveById command
 * Removes the movie with the provided id
 */
public class RemoveById implements Command {
    CollectionManager collectionManager;

    public RemoveById(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Execute of 'remove_by_id' command
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
        
        collectionManager.getCollection().removeIf(m -> m.getId() == id);
        System.out.println("Movie removed from the collection");
    }

    /**
     * @return Info about command
     */
    @Override
    public String getInfo() {
        return "remove the movie with the provided id";
    }
}