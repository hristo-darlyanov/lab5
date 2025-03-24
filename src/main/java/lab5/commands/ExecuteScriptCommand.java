package lab5.commands;

import lab5.managers.CommandManager;
import lab5.managers.FileManager;
import java.util.Map;

/**
 * Execute script command
 * Executes commands from a file
 */
public class ExecuteScriptCommand implements Command {
    private static int amountOfExecutedScripts = 1;
    private int allowedRecursionDepth = 10;
    private CommandManager commandManager;

    public ExecuteScriptCommand(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    /**
     * Execute of 'execute_script' command
     */
    @Override
    public void execute(String argument) {
        if (argument == null || argument.isEmpty()) {
            System.out.println("You should enter a file name");
            return;
        }
 
        Map<String, String> commands = FileManager.loadCommandScript(argument);
        if (commands == null) {
            return;
        }

        for (Map.Entry<String, String> entry : commands.entrySet()) {
            String key = entry.getKey();
            String parameter = entry.getValue();
            if (key.equals("execute_script")) {
                amountOfExecutedScripts += 1;
            }
            if (amountOfExecutedScripts > allowedRecursionDepth) {
                System.out.println("Recursion detected. Command execution stopped.");
                return;
            }

            System.out.println("Executing command: " + key + " with the argument: " + parameter);
            commandManager.execute(key, parameter);
        }

        amountOfExecutedScripts = 1;
    }

    /**
     * @return Info about command
     */
    @Override
    public String getInfo() {
        return "execute script from file";
    }
}
