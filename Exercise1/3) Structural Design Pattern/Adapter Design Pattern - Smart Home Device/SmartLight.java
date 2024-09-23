// SmartLight.java
public class SmartLight {
    public void powerOn() {
        Logger.info("Smart Light is now ON (via Wi-Fi).");
    }

    public void powerOff() {
        Logger.info("Smart Light is now OFF (via Wi-Fi).");
    }

    public String checkStatus() {
        return "Smart Light is currently ON.";
    }
}
