package lab5;

import sun.misc.Signal;
import sun.misc.SignalHandler;

import lab5.utils.App;

/**
 * Main class to launch the application.
 * Sets up signal handling, loads the collection from file,
 * registers commands, and starts the console application.
 */
public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Signal.handle(new Signal("INT"), new SignalHandler() {
            @Override
            public void handle(Signal sig) {
                // pass
            }
        });

        args = new String[] { "movies.xml" };
        if (args.length < 1) {
            System.err.println("Please provide the file name as a command line argument.");
            System.exit(1);
        }
        String fileName = args[0];

        // Start the app
        App app = new App(fileName);
        app.start();
    }
}