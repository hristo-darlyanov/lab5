package lab5.commands;

import lab5.managers.CollectionManager;
import lab5.models.Movie;

/**
 * Command to get the number of movies that have an oscar count less than the provided
 */
public class CountLessThanOscarsCountCommand implements Command {
    CollectionManager collectionManager;
    public CountLessThanOscarsCountCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Execute of 'count_less_than_oscar_count' command
     */
    @Override
    public void execute(String argument) {
        if (argument.isEmpty() || argument == null) {
            System.out.println("You should enter an oscar count");
            return;
        }
        
        int oscarCount;

        try {
            oscarCount = Integer.parseInt(argument);
        } catch (NumberFormatException e) {
            System.out.println("Oscar count should be a number");
            return;
        }

        if (oscarCount <= 0) {
            System.out.println("Oscar count should be a positive number");
            return;
        }

        int amount = 0;
        for (Movie movie : collectionManager.getCollection()) {
            if (movie.getOscarsCount() < oscarCount) {
                amount += 1;
            }
        }

        System.out.println("Movies with oscars less than " + argument + ": " + amount);
    }

    /**
     * @return Info about command
     */
    @Override
    public String getInfo() {
        return "get the number of movies that have an oscar count less than the provided";
    }
}
