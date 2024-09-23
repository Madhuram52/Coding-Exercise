package src.observer;

import src.model.Room;

public class AirConditioningSystem implements OccupancyObserver {
    @Override
    public void update(Room room) {
        if (room.isOccupied()) {
            System.out.println("Room " + room.getRoomNumber() + ": AC turned on.");
        } else {
            System.out.println("Room " + room.getRoomNumber() + ": AC turned off.");
        }
    }

    public void turnOff() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'turnOff'");
    }

    public void setTemperature(int temperature) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTemperature'");
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
