package src;

import src.config.OfficeConfig;
import src.service.BookingService;
import src.service.EnvironmentControlService;
import src.service.OccupancyService;
import src.util.ConsoleInputHandler;


public class Main {
    public static void main(String[] args) {
        OfficeConfig officeConfig = OfficeConfig.getInstance();
        BookingService bookingService = new BookingService();
        OccupancyService occupancyService = new OccupancyService();
        EnvironmentControlService environmentControlService = new EnvironmentControlService();

        ConsoleInputHandler inputHandler = new ConsoleInputHandler(
            officeConfig, bookingService, occupancyService, environmentControlService);

        System.out.println("Welcome to Smart Office Facility Management System");
        
        while (true) {
            System.out.print("Enter command (or 'exit' to quit): ");
            String input = System.console().readLine();
            
            if ("exit".equalsIgnoreCase(input)) {
                break;
            }
            
            inputHandler.handleInput(input);
        }

        System.out.println("Thank you for using Smart Office Facility Management System");
    }
}
