package src.observer;

import src.model.Room;

public interface OccupancyObserver {
    void update(Room room);
}
