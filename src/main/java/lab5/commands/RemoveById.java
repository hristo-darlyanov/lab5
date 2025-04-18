package lab5.commands;

import lab5.managers.CollectionManager;
import lab5.utils.Validator;

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
        int id = Validator.parseAndValidateInt(argument);

        Validator.movieWithIdExists(collectionManager, argument);
        
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