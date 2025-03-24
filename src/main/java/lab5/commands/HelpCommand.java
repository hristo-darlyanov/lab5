package lab5.commands;

import lab5.managers.CommandManager;

/**
 * Help command
 * Shows all available commands
 */
public class HelpCommand implements Command{
    CommandManager commandManager;

    public HelpCommand(CommandManager commandManager) {
        this.commandManager = commandManager;
    }
    
    /**
     * Execute of 'help' command
     */
    @Override
    public void execute(String argument) {
        System.out.println("Available commands:");
        commandManager.getCommands().forEach((name, command) -> System.out.println(name + " - " + command.getInfo()));
    }

    /**
     * @return Info about command
     */
    @Override
    public String getInfo() {
        return "show all available commands";
    }
}
