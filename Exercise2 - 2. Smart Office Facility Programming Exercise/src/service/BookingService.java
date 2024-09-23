package src.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import src.config.OfficeConfig;
import src.model.Booking;

public class BookingService {
    private List<Booking> bookings;
    private OfficeConfig officeConfig;

    public BookingService() {
        this.bookings = new ArrayList<>();
        this.officeConfig = OfficeConfig.getInstance();
    }

    public boolean bookRoom(int roomNumber, LocalDateTime startTime, int durationMinutes) {
        if (!officeConfig.roomExists(roomNumber)) {
            System.out.println("Room " + roomNumber + " does not exist.");
            return false;
        }

        if (isRoomAvailable(roomNumber, startTime, durationMinutes)) {
            bookings.add(new Booking(roomNumber, startTime, durationMinutes));
            System.out.println("Room " + roomNumber + " booked successfully.");
            return true;
        } else {
            System.out.println("Room " + roomNumber + " is not available for the requested time.");
            return false;
        }
    }

    public boolean cancelBooking(int roomNumber) {
        List<Booking> roomBookings = bookings.stream()
                .filter(b -> b.getRoomNumber() == roomNumber && b.isActive(LocalDateTime.now()))
                .collect(Collectors.toList());

        if (!roomBookings.isEmpty()) {
            bookings.removeAll(roomBookings);
            System.out.println("Booking for Room " + roomNumber + " cancelled successfully.");
            return true;
        } else {
            System.out.println("No active booking found for Room " + roomNumber + ".");
            return false;
        }
    }

    public boolean isRoomAvailable(int roomNumber, LocalDateTime startTime, int durationMinutes) {
        LocalDateTime endTime = startTime.plusMinutes(durationMinutes);
        return bookings.stream()
                .filter(b -> b.getRoomNumber() == roomNumber)
                .noneMatch(b -> {
                    LocalDateTime bookingEnd = b.getStartTime().plusMinutes(b.getDurationMinutes());
                    return (startTime.isBefore(bookingEnd) && endTime.isAfter(b.getStartTime()));
                });
    }

    public void releaseUnoccupiedRooms() {
        LocalDateTime now = LocalDateTime.now();
        bookings.removeIf(b -> b.getStartTime().plusMinutes(5).isBefore(now) && !b.isActive(now));
    }
}
