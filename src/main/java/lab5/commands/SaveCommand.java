package lab5.commands;

import lab5.managers.CollectionManager;
import lab5.managers.FileManager;

/**
 * Save command
 * Saves the collection to a file
 */
public class SaveCommand implements Command {
    CollectionManager collectionManager;
    String defaultSavePath = "movies.xml";

    public SaveCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Execute of 'save' command
     */
    @Override
    public void execute(String argument) {
        FileManager.saveCollection(defaultSavePath, collectionManager.getCollection());
        System.out.println("Collection saved to file");
    }
    
    /**
     * @return Info about command
     */
    @Override
    public String getInfo() {
        return "save collection to file";
    }
}
