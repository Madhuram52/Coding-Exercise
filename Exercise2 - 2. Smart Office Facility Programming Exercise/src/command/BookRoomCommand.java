package src.command;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import src.service.BookingService;

public class BookRoomCommand implements Command {
    private BookingService bookingService;
    private int roomNumber;
    private String startTimeStr;
    private int durationMinutes;

    public BookRoomCommand(BookingService bookingService, int roomNumber, String startTimeStr, int durationMinutes) {
        this.bookingService = bookingService;
        this.roomNumber = roomNumber;
        this.startTimeStr = startTimeStr;
        this.durationMinutes = durationMinutes;
    }

    @Override
    public void execute() {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalDateTime startTime = LocalDateTime.now().withHour(Integer.parseInt(startTimeStr.split(":")[0]))
                    .withMinute(Integer.parseInt(startTimeStr.split(":")[1]))
                    .withSecond(0).withNano(0);

            if (bookingService.bookRoom(roomNumber, startTime, durationMinutes)) {
                System.out.println("Room " + roomNumber + " booked from " + startTimeStr + " for " + durationMinutes + " minutes.");
            }
        } catch (Exception e) {
            System.out.println("Invalid time format. Please use HH:mm format.");
        }
    }
}
