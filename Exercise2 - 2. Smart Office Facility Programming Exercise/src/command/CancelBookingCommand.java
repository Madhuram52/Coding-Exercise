package src.command;

import src.service.BookingService;

public class CancelBookingCommand implements Command {
    private BookingService bookingService;
    private int roomNumber;

    public CancelBookingCommand(BookingService bookingService, int roomNumber) {
        this.bookingService = bookingService;
        this.roomNumber = roomNumber;
    }

    @Override
    public void execute() {
        bookingService.cancelBooking(roomNumber);
    }
}
