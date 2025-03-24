package lab5.commands;

import java.util.NoSuchElementException;

import lab5.managers.CollectionManager;
import lab5.models.Movie;

/**
 * RemoveHead command
 * Removes the first movie of the collection and displays it
 */
public class RemoveHead implements Command {
    CollectionManager collectionManager;

    public RemoveHead(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Execute of 'remove_head' command
     */
    @Override
    public void execute(String argument) {
        try {
            Movie movie = collectionManager.getCollection().removeFirst();
            System.out.println(movie.toString());
        } catch (NoSuchElementException e) {
            System.out.println("No more elements to remove");
        }
    }

    /**
     * @return Info about command
     */
    @Override
    public String getInfo() {
        return "remove the first movie of the collection and display it";
    }

}
