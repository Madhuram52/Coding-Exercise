package src.service;

import java.util.HashMap;
import java.util.Map;

import src.model.Room;
import src.observer.AirConditioningSystem;
import src.observer.LightingSystem;
import src.observer.OccupancyObserver;

public class EnvironmentControlService implements OccupancyObserver {
    private Map<Integer, LightingSystem> lightingSystems;
    private Map<Integer, AirConditioningSystem> acSystems;

    public EnvironmentControlService() {
        this.lightingSystems = new HashMap<>();
        this.acSystems = new HashMap<>();
    }

    public void registerRoom(int roomNumber) {
        lightingSystems.put(roomNumber, new LightingSystem());
        acSystems.put(roomNumber, new AirConditioningSystem());
    }

    @Override
    public void update(Room room) {
        int roomNumber = room.getRoomNumber();
        if (room.isOccupied()) {
            turnOnEnvironmentControls(roomNumber);
        } else {
            turnOffEnvironmentControls(roomNumber);
        }
    }

    private void turnOnEnvironmentControls(int roomNumber) {
        if (lightingSystems.containsKey(roomNumber) && acSystems.containsKey(roomNumber)) {
            lightingSystems.get(roomNumber).turnOn();
            acSystems.get(roomNumber).turnOn();
            System.out.println("Room " + roomNumber + ": Environment controls activated.");
        } else {
            System.out.println("Room " + roomNumber + ": Environment control systems not registered.");
        }
    }

    private void turnOffEnvironmentControls(int roomNumber) {
        if (lightingSystems.containsKey(roomNumber) && acSystems.containsKey(roomNumber)) {
            lightingSystems.get(roomNumber).turnOff();
            acSystems.get(roomNumber).turnOff();
            System.out.println("Room " + roomNumber + ": Environment controls deactivated.");
        } else {
            System.out.println("Room " + roomNumber + ": Environment control systems not registered.");
        }
    }

    public void adjustTemperature(int roomNumber, int temperature) {
        if (acSystems.containsKey(roomNumber)) {
            acSystems.get(roomNumber).setTemperature(temperature);
            System.out.println("Room " + roomNumber + ": Temperature adjusted to " + temperature + "°C.");
        } else {
            System.out.println("Room " + roomNumber + ": AC system not registered.");
        }
    }

    public void adjustLighting(int roomNumber, int brightness) {
        if (lightingSystems.containsKey(roomNumber)) {
            lightingSystems.get(roomNumber).setBrightness(brightness);
            System.out.println("Room " + roomNumber + ": Lighting brightness adjusted to " + brightness + "%.");
        } else {
            System.out.println("Room " + roomNumber + ": Lighting system not registered.");
        }
    }

    public String getEnvironmentStatus(int roomNumber) {
        StringBuilder status = new StringBuilder();
        status.append("Room ").append(roomNumber).append(" Environment Status:\n");

        if (lightingSystems.containsKey(roomNumber)) {
            status.append("Lighting: ").append(lightingSystems.get(roomNumber).getStatus()).append("\n");
        } else {
            status.append("Lighting system not registered.\n");
        }

        if (acSystems.containsKey(roomNumber)) {
            status.append("AC: ").append(acSystems.get(roomNumber).getStatus()).append("\n");
        } else {
            status.append("AC system not registered.\n");
        }

        return status.toString();
    }
}
