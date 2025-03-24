package lab5.commands;

/**
 * Interface for commands
 */
public interface Command {
    void execute(String argument); 
    String getInfo();
}
