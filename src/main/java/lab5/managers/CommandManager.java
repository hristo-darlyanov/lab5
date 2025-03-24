package lab5.managers;

import lab5.commands.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Command manager
 * Manages commands
 */
public class CommandManager {
    private Map<String, Command> commandMap;
    private CollectionManager collectionManager;

    public CommandManager(CollectionManager collectionManager) {
        this.commandMap = new HashMap<>();
        this.collectionManager = collectionManager;
    }

    /**
     * Register a command
     * @param commandName Name of the command
     * @param command Command
     */
    public void register(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    /**
     * Register default commands
     */
    public void registerDefaultCommands() {
        register("help", new HelpCommand(this));
        register("info", new InfoCommand(collectionManager));
        register("show", new ShowCommand(collectionManager));
        register("add", new AddCommand(collectionManager));
        register("update", new UpdateCommand(collectionManager));
        register("save", new SaveCommand(collectionManager));
        register("clear", new ClearCommand(collectionManager));
        register("remove_by_id", new RemoveById(collectionManager));
        register("remove_head", new RemoveHead(collectionManager));
        register("count_less_than_oscars_count", new CountLessThanOscarsCountCommand(collectionManager));
        register("count_by_genre", new CountByGenreCommand(collectionManager));
        register("filter_contains_name", new FilterContainsNameCommand(collectionManager));
        register("add_if_min", new AddIfMinCommand(collectionManager));
        register("remove_lower", new RemoveLowerCommand(collectionManager));
        register("execute_script", new ExecuteScriptCommand(this));
        register("test", new TestCommand());
    }

    /**
     * Get all commands
     * @return Map of commands
     */
    public Map<String, Command> getCommands() {
        return commandMap;
    }

    /**
     * Execute a command
     * @param commandName Name of the command
     * @param args Arguments of the command
     */
    public void execute(String commandName, String args) {
        Command command = commandMap.get(commandName);
        if (command != null) {
            command.execute(args);
        } else {
            System.out.println("Unknown command: " + commandName);
        }
    }
}
