package src.service;

import java.util.HashMap;
import java.util.Map;

import src.config.OfficeConfig;
import src.model.Room;
import src.observer.OccupancyObserver;

public class OccupancyService {
    private Map<Integer, Room> rooms;
    private OfficeConfig officeConfig;

    public OccupancyService() {
        this.rooms = new HashMap<>();
        this.officeConfig = OfficeConfig.getInstance();
        initializeRooms();
    }

    private void initializeRooms() {
        for (int i = 1; i <= officeConfig.getRoomCount(); i++) {
            rooms.put(i, new Room(i, officeConfig.getRoomCapacity(i)));
        }
    }

    public void addOccupant(int roomNumber, int count) {
        if (rooms.containsKey(roomNumber)) {
            Room room = rooms.get(roomNumber);
            room.addOccupant(count);
            System.out.println("Room " + roomNumber + " occupancy updated. Current occupancy: " + room.getCurrentOccupancy());
        } else {
            System.out.println("Room " + roomNumber + " does not exist.");
        }
    }

    public void removeOccupant(int roomNumber, int count) {
        if (rooms.containsKey(roomNumber)) {
            Room room = rooms.get(roomNumber);
            room.removeOccupant(count);
            System.out.println("Room " + roomNumber + " occupancy updated. Current occupancy: " + room.getCurrentOccupancy());
        } else {
            System.out.println("Room " + roomNumber + " does not exist.");
        }
    }

    public boolean isRoomOccupied(int roomNumber) {
        return rooms.containsKey(roomNumber) && rooms.get(roomNumber).isOccupied();
    }

    public void addObserver(int roomNumber, OccupancyObserver observer) {
        if (rooms.containsKey(roomNumber)) {
            rooms.get(roomNumber).addObserver(observer);
        }
    }

    public void removeObserver(int roomNumber, OccupancyObserver observer) {
        if (rooms.containsKey(roomNumber)) {
            rooms.get(roomNumber).removeObserver(observer);
        }
    }
}
