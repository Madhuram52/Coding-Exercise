package src.model;

import java.time.LocalDateTime;

public class Booking {
    private int roomNumber;
    private LocalDateTime startTime;
    private int durationMinutes;

    public Booking(int roomNumber, LocalDateTime startTime, int durationMinutes) {
        this.roomNumber = roomNumber;
        this.startTime = startTime;
        this.durationMinutes = durationMinutes;
    }

    public boolean isActive(LocalDateTime currentTime) {
        LocalDateTime endTime = startTime.plusMinutes(durationMinutes);
        return currentTime.isAfter(startTime) && currentTime.isBefore(endTime);
    }

    // Getters
    public int getRoomNumber() {
        return roomNumber;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "roomNumber=" + roomNumber +
                ", startTime=" + startTime +
                ", durationMinutes=" + durationMinutes +
                '}';
    }
}
