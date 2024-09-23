// LightAdapter.java
public class LightAdapter implements SmartDevice {
    private SmartLight smartLight;

    public LightAdapter(SmartLight smartLight) {
        this.smartLight = smartLight;
    }

    @Override
    public void turnOn() {
        smartLight.powerOn();
    }

    @Override
    public void turnOff() {
        smartLight.powerOff();
    }

    @Override
    public void getStatus() {
        Logger.info(smartLight.checkStatus());
    }
}
