// ThermostatAdapter.java
public class ThermostatAdapter implements SmartDevice {
    private SmartThermostat smartThermostat;

    public ThermostatAdapter(SmartThermostat smartThermostat) {
        this.smartThermostat = smartThermostat;
    }

    @Override
    public void turnOn() {
        smartThermostat.activate();
    }

    @Override
    public void turnOff() {
        smartThermostat.deactivate();
    }

    @Override
    public void getStatus() {
        Logger.info("Current temperature: " + smartThermostat.currentTemperature() + "°F");
    }
}
