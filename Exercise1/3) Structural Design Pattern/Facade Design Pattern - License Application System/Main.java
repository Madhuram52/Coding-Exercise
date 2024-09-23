// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LicenseFacade licenseFacade = new LicenseFacade();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            try {
                System.out.println("Enter the type of license you would like to apply for (car, motorcycle, truck or type 'exit' to quit):");
                String licenseTypeInput = scanner.nextLine();

                if (licenseTypeInput.equalsIgnoreCase("exit")) {
                    exit = true;
                    Logger.info("Exiting the application...");
                    continue;
                }

                LicenseType licenseType;
                try {
                    licenseType = LicenseType.valueOf(licenseTypeInput.toUpperCase());
                } catch (IllegalArgumentException e) {
                    Logger.error("Invalid license type: " + licenseTypeInput, e);
                    continue;
                }

                System.out.println("Enter your name:");
                String applicantName = scanner.nextLine();

                System.out.println("Enter your age:");
                int applicantAge = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                // Apply for the license through the facade
                licenseFacade.applyForLicense(licenseType, applicantName, applicantAge);
            } catch (Exception e) {
                Logger.error("An unexpected error occurred", e);
            }
        }
        scanner.close();
        Logger.info("Program has successfully terminated.");
    }
}
