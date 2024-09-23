// SmartHomeHub.java
import java.util.ArrayList;
import java.util.List;

public class SmartHomeHub {
    private List<SmartDevice> devices = new ArrayList<>();

    public void addDevice(SmartDevice device) {
        devices.add(device);
        Logger.info("Device added to the Smart Home Hub.");
    }

    public void controlAllDevices(boolean turnOn) {
        for (SmartDevice device : devices) {
            if (turnOn) {
                device.turnOn();
            } else {
                device.turnOff();
            }
        }
    }

    public void showAllDeviceStatus() {
        for (SmartDevice device : devices) {
            device.getStatus();
        }
    }
}
