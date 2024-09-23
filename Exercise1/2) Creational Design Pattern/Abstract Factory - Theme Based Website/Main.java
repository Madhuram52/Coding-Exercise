import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ThemeFactory factory = null;

        while (true) {
            System.out.println("Choose theme: 1 for Light, 2 for Dark, 0 to exit:");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Exiting...");
                break;
            }

            switch (choice) {
                case 1:
                    factory = new LightThemeFactory();
                    break;
                case 2:
                    factory = new DarkThemeFactory();
                    break;
                default:
                    System.out.println("Invalid input. Please choose 1 or 2.");
                    continue;
            }

            Header header = factory.createHeader();
            Footer footer = factory.createFooter();
            Body body = factory.createBody();

            header.displayHeader();
            body.displayBody();
            footer.displayFooter();
        }

        scanner.close();
    }
}
