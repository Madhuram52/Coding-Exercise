// LockAdapter.java
public class LockAdapter implements SmartDevice {
    private SmartLock smartLock;

    public LockAdapter(SmartLock smartLock) {
        this.smartLock = smartLock;
    }

    @Override
    public void turnOn() {
        smartLock.unlock();
    }

    @Override
    public void turnOff() {
        smartLock.lock();
    }

    @Override
    public void getStatus() {
        Logger.info("Smart Lock is " + (smartLock.isLocked() ? "locked" : "unlocked"));
    }
}
