// SmartLock.java
public class SmartLock {
    public void lock() {
        Logger.info("Smart Lock is now locked (via Bluetooth).");
    }

    public void unlock() {
        Logger.info("Smart Lock is now unlocked (via Bluetooth).");
    }

    public boolean isLocked() {
        return true;
    }
}
