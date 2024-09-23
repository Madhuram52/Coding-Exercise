package src.config;

import java.util.HashMap;
import java.util.Map;

public class OfficeConfig {
    private static OfficeConfig instance;
    private Map<Integer, Integer> roomCapacities;

    private OfficeConfig() {
        roomCapacities = new HashMap<>();
    }

    public static synchronized OfficeConfig getInstance() {
        if (instance == null) {
            instance = new OfficeConfig();
        }
        return instance;
    }

    public void setRoomCount(int count) {
        for (int i = 1; i <= count; i++) {
            roomCapacities.putIfAbsent(i, 10); // Default capacity of 10
        }
    }

    public void setRoomCapacity(int roomNumber, int capacity) {
        if (roomCapacities.containsKey(roomNumber)) {
            roomCapacities.put(roomNumber, capacity);
        } else {
            throw new IllegalArgumentException("Room " + roomNumber + " does not exist.");
        }
    }

    public int getRoomCount() {
        return roomCapacities.size();
    }

    public int getRoomCapacity(int roomNumber) {
        return roomCapacities.getOrDefault(roomNumber, -1);
    }

    public boolean roomExists(int roomNumber) {
        return roomCapacities.containsKey(roomNumber);
    }
}
