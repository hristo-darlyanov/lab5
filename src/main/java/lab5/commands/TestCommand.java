package lab5.commands;

import lab5.forms.GenericForm;

/**
 * Test command
 * Asks for a string and prints it
 */
public class TestCommand implements Command {
    /**
     * Execute of 'test' command
     */
    @Override
    public void execute(String argument) {
        String asked = GenericForm.promptReadString("Enter a string: ");
        System.out.println("You entered: " + asked);
    }

    /**
     * @return Info about command
     */
    @Override
    public String getInfo() {
        return "test command";
    }
}
