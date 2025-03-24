package lab5.commands;

import lab5.forms.MovieForm;
import lab5.managers.CollectionManager;
import lab5.models.Movie;

import java.util.ArrayDeque;

/**
 * AddIfMin command
 * Adds an element if it is smaller than the rest
 */
public class AddIfMinCommand implements Command {
    CollectionManager collectionManager;

    public AddIfMinCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }


    /**
     * Execute of 'add_if_min' command
     */
    @Override
    public void execute(String argument) {
        ArrayDeque<Movie> collection = collectionManager.getCollection();
        Movie movie = MovieForm.ask();
        if (collection.size() == 0) {
            collection.add(movie);
        } else {
            boolean canAdd = true;
            for (Movie m : collection) {
                if (movie.compareTo(m) >= 0) {
                    System.out.println("The movie is not the smallest");
                    canAdd = false;
                    break;
                }
            }
            if (canAdd) {
                collection.add(movie);
                System.out.println("Movie added to the collection");
            }
        }
    }

    /**
     * @return Info about command
     */
    @Override
    public String getInfo() {
        return "adds an element if it is smaller than the rest";
    }
}