package src.observer;

import src.model.Room;

public class LightingSystem implements OccupancyObserver {
    @Override
    public void update(Room room) {
        if (room.isOccupied()) {
            System.out.println("Room " + room.getRoomNumber() + ": Lights turned on.");
        } else {
            System.out.println("Room " + room.getRoomNumber() + ": Lights turned off.");
        }
    }

    public void turnOff() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'turnOff'");
    }

    public void setBrightness(int brightness) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setBrightness'");
    }

    public Object getStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStatus'");
    }

    public void turnOn() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'turnOn'");
    }
}
