package src.model;

import java.util.ArrayList;
import java.util.List;

import src.observer.OccupancyObserver;

public class Room {
    private int roomNumber;
    private int capacity;
    private int currentOccupancy;
    private boolean isOccupied;
    private List<OccupancyObserver> observers;

    public Room(int roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.currentOccupancy = 0;
        this.isOccupied = false;
        this.observers = new ArrayList<>();
    }

    public void addOccupant(int count) {
        currentOccupancy += count;
        if (currentOccupancy >= 2 && !isOccupied) {
            isOccupied = true;
            notifyObservers();
        }
    }

    public void removeOccupant(int count) {
        currentOccupancy = Math.max(0, currentOccupancy - count);
        if (currentOccupancy < 2 && isOccupied) {
            isOccupied = false;
            notifyObservers();
        }
    }

    public void addObserver(OccupancyObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OccupancyObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (OccupancyObserver observer : observers) {
            observer.update(this);
        }
    }

    // Getters and setters
    public int getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentOccupancy() {
        return currentOccupancy;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
}
