package lab5.utils;

import lab5.managers.CollectionManager;
import lab5.managers.CommandManager;

public class App {
    CollectionManager collectionManager;
    CommandManager commandManager;

    public App(String fileName) {
        // Insert into collection manager
        this.collectionManager = new CollectionManager();
        this.collectionManager.addMoviesFromFile(fileName);
        this.commandManager = new CommandManager(collectionManager);
        this.commandManager.registerDefaultCommands();
    }
    
    public void start() {
        System.out.println("Console application started. Type 'exit' to quit.");
        while (true) {
            String input = Console.readLineConsole();
            if ("exit".equalsIgnoreCase(input.trim())) {
                break;
            }
            String[] tokens = input.trim().split("\\s+", 2);
            String commandName = tokens[0];
            String args = tokens.length > 1 ? tokens[1] : "";
            try {
                commandManager.execute(commandName, args);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
        System.out.print("Exiting application.");
    }
}
