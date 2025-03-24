package lab5.commands;

import java.util.stream.Stream;

import lab5.managers.CollectionManager;
import lab5.models.Movie;

/**
 * FilterContainsName command
 * Filters and displays elements whose name field value contains the specified substring
 */
public class FilterContainsNameCommand implements Command {
    CollectionManager collectionManager;

    public FilterContainsNameCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Execute of 'filter_contains_name' command
     */
    @Override
    public void execute(String argument) {
        if (argument == null || argument.isEmpty()) {
            System.out.println("You must specify a substring to filter by.");
            return;
        }

        Stream<Movie> movies = collectionManager.getCollection().stream()
                .filter(movie -> movie.getName().contains(argument));
        
        movies.forEach(movie -> System.out.println(movie.toString()));   
    }

    /**
     * @return Info about command
     */
    @Override
    public String getInfo() {
        return "filter and display elements whose name field value contains the specified substring";
    }
}
