public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Started application");
        logger2.log("Performed login");

        // Check if both references point to the same object
        if (logger1 == logger2) {
            System.out.println("✅ Both are the same Logger instance");
        } else {
            System.out.println("❌ Different Logger instances (something's wrong!)");
        }
    }
}
