// Logger.java
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    public static void info(String message) {
        log("INFO", message);
    }

    public static void error(String message, Exception e) {
        log("ERROR", message);
        e.printStackTrace();
    }

    private static void log(String level, String message) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = sdf.format(new Date());
        System.out.println("[" + timestamp + "] [" + level + "]: " + message);
    }
}
