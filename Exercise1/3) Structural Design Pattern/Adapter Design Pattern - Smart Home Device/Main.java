// Main.java
public class Main {
    public static void main(String[] args) {
        SmartHomeHub homeHub = new SmartHomeHub();

        // Add different devices to the hub via adapters
        SmartLight smartLight = new SmartLight();
        SmartThermostat smartThermostat = new SmartThermostat();
        SmartLock smartLock = new SmartLock();

        homeHub.addDevice(new LightAdapter(smartLight));
        homeHub.addDevice(new ThermostatAdapter(smartThermostat));
        homeHub.addDevice(new LockAdapter(smartLock));

        // Control all devices
        Logger.info("Turning on all devices...");
        homeHub.controlAllDevices(true);

        // Show the status of all devices
        Logger.info("Showing the status of all devices:");
        homeHub.showAllDeviceStatus();

        // Control all devices (turn them off)
        Logger.info("Turning off all devices...");
        homeHub.controlAllDevices(false);
    }
}
