package lab5.commands;

import lab5.managers.CollectionManager;
import lab5.models.Movie;

/**
 * Show command
 * Displays all movies of the collection in string representation
 */
public class ShowCommand implements Command{
    private CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Execute of 'show' command
     */
    @Override
    public void execute(String argument) {
        for (Movie element : collectionManager.getCollection()) {
            System.out.println(element.toString());
        }
    }

    /**
     * @return Info about command
     */
    @Override
    public String getInfo() {
        return "display all movies of the collection in string representation";
    }
}
