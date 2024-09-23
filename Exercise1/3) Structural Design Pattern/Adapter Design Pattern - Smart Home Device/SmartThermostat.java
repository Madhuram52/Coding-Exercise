// SmartThermostat.java
public class SmartThermostat {
    public void activate() {
        Logger.info("Smart Thermostat activated (via Zigbee).");
    }

    public void deactivate() {
        Logger.info("Smart Thermostat deactivated (via Zigbee).");
    }

    public int currentTemperature() {
        return 72;
    }
}
