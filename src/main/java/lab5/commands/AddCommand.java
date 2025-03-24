package lab5.commands;

import lab5.forms.MovieForm;
import lab5.managers.CollectionManager;
import lab5.models.Movie;

/**
 * Add command
 * Adds a new element to the collection
 */
public class AddCommand implements Command {
    CollectionManager collectionManager;

    public AddCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Execute of 'add' command
     */
    @Override
    public void execute(String argument) {
        Movie movie = MovieForm.ask();
        collectionManager.getCollection().add(movie);
        System.out.println("Movie added to the collection");
    }


    /**
     * @return Info about command
     */
    @Override
    public String getInfo() {
        return "add new element to the collection";
    } 
}
