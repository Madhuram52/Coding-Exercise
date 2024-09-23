// Logger.java
public class Logger {
    public static void info(String message) {
        System.out.println("[INFO]: " + message);
    }

    public static void error(String message, Exception e) {
        System.err.println("[ERROR]: " + message);
        e.printStackTrace();
    }
}
