package lab5.commands;

import lab5.managers.CollectionManager;
import lab5.models.Movie;
import lab5.models.MovieGenre;

/**
 * Count by genre command
 * Counts the number of elements, the value of the genre field of which is equal to the specified one
 */
public class CountByGenreCommand implements Command {
    CollectionManager collectionManager;

    public CountByGenreCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Execute of 'count_by_genre' command
     */
    @Override
    public void execute(String argument) {
        if (!MovieGenre.contains(argument)) {
            if (argument.isEmpty()) {
                System.out.println("Genre must be provided");
            } else {
                System.out.println("There is no such genre");
            }
            return;
        }
        
        int count = 0;

        for (Movie iterable_element : collectionManager.getCollection()) {
            MovieGenre genre = iterable_element.getGenre();
            if (genre != null && genre.toString().equals(argument)) {
                count++;
            }
        }
        
        System.out.println("Number of movies with genre " + argument + ": " + count);
    }

    /**
     * @return Info about command
     */
    @Override
    public String getInfo() {
        return "count the number of elements, the value of the genre field of which is equal to the specified one";
    }
}
