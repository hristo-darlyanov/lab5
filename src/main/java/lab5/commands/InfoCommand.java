package lab5.commands;

import lab5.managers.CollectionManager;
import java.time.format.DateTimeFormatter;

/**
 * Info command
 */
public class InfoCommand implements Command {
    private CollectionManager collectionManager;

    public InfoCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Execute of 'info' command
     */
    @Override
    public void execute(String argument) {
        System.out.println("Collection Information:");
        System.out.println("Collection type: " + collectionManager.getCollection().getClass().getSimpleName());
        System.out.println("Initialization date: " + collectionManager.getInitializationDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println("Number of elements: " + collectionManager.getCollection().size());
    }

    /**
     * @return Info about command
     */
    @Override
    public String getInfo() {
        return "display information about the collection (type, initialization date, number of items, etc.)";
    }
}
