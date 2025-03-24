package lab5.commands;

import lab5.managers.CollectionManager;

/**
 * Clear command
 * Clears the collection
 */
public class ClearCommand implements Command {
    CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Execute of 'clear' command
     */
    @Override
    public void execute(String argument) {
        collectionManager.getCollection().clear();
        System.out.println("Collection cleared");
    }

    /**
     * @return Info about command
     */
    @Override
    public String getInfo() {
        return "clear the collection";
    }
}
