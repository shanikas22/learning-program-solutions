public class Logger {

    // Step 1: Create a private static instance of Logger
    private static Logger instance;

    // Step 2: Make constructor private (so no one can do `new Logger()`)
    private Logger() {
        System.out.println("Logger Created");
    }

    // Step 3: Provide a public method to get the single instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();  // only created once
        }
        return instance;
    }

    // Step 4: Sample method for logging
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
