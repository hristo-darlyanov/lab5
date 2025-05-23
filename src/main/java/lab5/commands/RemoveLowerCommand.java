package lab5.commands;

import lab5.managers.CollectionManager;
import lab5.models.Movie;
import lab5.utils.Validator;

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
        int id = Validator.parseAndValidateInt(argument);

        Validator.movieWithIdExists(collectionManager, argument);

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
