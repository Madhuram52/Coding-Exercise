// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FormOriginator formOriginator = new FormOriginator();
        FormCaretaker caretaker = new FormCaretaker();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            try {
                System.out.println("1. Fill form");
                System.out.println("2. Save form progress");
                System.out.println("3. Restore last saved form");
                System.out.println("4. View current form data");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline left-over

                switch (choice) {
                    case 1:
                        System.out.print("Enter user details (name, age, etc.): ");
                        String userDetails = scanner.nextLine();
                        System.out.print("Enter step number: ");
                        int step = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        formOriginator.setFormState(userDetails, step);
                        break;

                    case 2:
                        caretaker.addMemento(formOriginator.saveState());
                        Logger.info("Form progress saved.");
                        break;

                    case 3:
                        FormState lastState = caretaker.getLastMemento();
                        if (lastState != null) {
                            formOriginator.restoreState(lastState);
                            Logger.info("Form progress restored to: " + lastState.getState());
                        } else {
                            Logger.info("No saved form state to restore.");
                        }
                        break;

                    case 4:
                        Logger.info("Current form data: " + formOriginator.getCurrentState());
                        break;

                    case 5:
                        exit = true;
                        Logger.info("Exiting...");
                        break;

                    default:
                        Logger.info("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                Logger.error("An unexpected error occurred", e);
                scanner.nextLine();  // Clear invalid input
            }
        }
        scanner.close();
    }
}
