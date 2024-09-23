package src.util;

import src.command.*;
import src.config.OfficeConfig;
import src.service.BookingService;
import src.service.EnvironmentControlService;
import src.service.OccupancyService;

public class ConsoleInputHandler {
    private OfficeConfig officeConfig;
    private BookingService bookingService;
    private OccupancyService occupancyService;
    private EnvironmentControlService environmentControlService;

    public ConsoleInputHandler(OfficeConfig officeConfig, BookingService bookingService,
                               OccupancyService occupancyService, EnvironmentControlService environmentControlService) {
        this.officeConfig = officeConfig;
        this.bookingService = bookingService;
        this.occupancyService = occupancyService;
        this.environmentControlService = environmentControlService;
    }

    public void handleInput(String input) {
        String[] parts = input.split(" ");
        String command = parts[0].toLowerCase();

        try {
            switch (command) {
                case "config":
                    handleConfigCommand(parts);
                    break;
                case "block":
                case "book":
                    handleBookCommand(parts);
                    break;
                case "cancel":
                    handleCancelCommand(parts);
                    break;
                case "add":
                    handleAddOccupantCommand(parts);
                    break;
                default:
                    System.out.println("Unknown command. Please try again.");
            }
        } catch (Exception e) {
            System.out.println("Error processing command: " + e.getMessage());
        }
    }

    private void handleConfigCommand(String[] parts) {
        if (parts.length < 4) {
            System.out.println("Invalid config command. Usage: config room [count <number> | capacity <room_number> <capacity>]");
            return;
        }

        if (parts[2].equalsIgnoreCase("count")) {
            int count = Integer.parseInt(parts[3]);
            new ConfigRoomCommand(officeConfig, count).execute();
        } else if (parts[2].equalsIgnoreCase("capacity")) {
            int roomNumber = Integer.parseInt(parts[3]);
            int capacity = Integer.parseInt(parts[4]);
            new ConfigRoomCommand(officeConfig, roomNumber, capacity).execute();
        } else {
            System.out.println("Invalid config command. Use 'count' or 'capacity'.");
        }
    }

    private void handleBookCommand(String[] parts) {
        if (parts.length != 4) {
            System.out.println("Invalid book command. Usage: book <room_number> <start_time> <duration_minutes>");
            return;
        }

        int roomNumber = Integer.parseInt(parts[1]);
        String startTime = parts[2];
        int duration = Integer.parseInt(parts[3]);

        new BookRoomCommand(bookingService, roomNumber, startTime, duration).execute();
    }

    private void handleCancelCommand(String[] parts) {
        if (parts.length != 2) {
            System.out.println("Invalid cancel command. Usage: cancel <room_number>");
            return;
        }

        int roomNumber = Integer.parseInt(parts[1]);
        new CancelBookingCommand(bookingService, roomNumber).execute();
    }

    private void handleAddOccupantCommand(String[] parts) {
        if (parts.length != 4 || !parts[1].equalsIgnoreCase("occupant")) {
            System.out.println("Invalid add occupant command. Usage: add occupant <room_number> <count>");
            return;
        }

        int roomNumber = Integer.parseInt(parts[2]);
        int count = Integer.parseInt(parts[3]);

        new AddOccupantCommand(occupancyService, roomNumber, count).execute();
    }
}
