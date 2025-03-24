package lab5.managers;

import java.time.LocalDateTime;
import java.util.ArrayDeque;

import lab5.models.Movie;

/**
 * Collection manager
 * Manages the collection
 */
public class CollectionManager {
    private ArrayDeque<Movie> collection;
    private LocalDateTime initializationDate;

    public CollectionManager() {
        this.collection = new ArrayDeque<>();
        this.initializationDate = LocalDateTime.now();
    }

    
    /** 
     * @param fileName
     */
    public void addMoviesFromFile(String fileName) {
        ArrayDeque<Movie> loadedCollection = FileManager.loadCollection("/" + fileName);

        // Iterate through the collections
        for (Movie movie : loadedCollection) {
            // Check if id for current movie is unique by comparing to other movies
            for (Movie otherMovie : loadedCollection) {
                if (movie != otherMovie && movie.getId().equals(otherMovie.getId())) {
                    movie.generateID();
                    break;
                }
            }

            Movie.validateMovie(movie);
            collection.add(movie);
        }
    }

    /**
     * @return Collection
     */
    public ArrayDeque<Movie> getCollection() {
        return collection;
    }

    /**
     * @return Initialization date
     */
    public LocalDateTime getInitializationDate() {
        return initializationDate;
    }

    /**
     * Adds a movie to the collection
     * @param movie Movie to add
     */
    public void add(Movie movie) {
        collection.add(movie);
    }
}
