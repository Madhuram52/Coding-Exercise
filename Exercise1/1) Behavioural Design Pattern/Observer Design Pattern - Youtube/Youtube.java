import java.util.Scanner;
import java.util.logging.Logger;

public class Youtube {
    private static final Logger logger = Logger.getLogger(Youtube.class.getName());

    public static void main(String[] args) {
        Channel channel = new Channel();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            try {
                System.out.println("1. Add Subscriber");
                System.out.println("2. Remove Subscriber");
                System.out.println("3. Upload Video");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter subscriber name: ");
                        String subName = scanner.nextLine();
                        Subscriber newSubscriber = new Subscriber(subName);
                        newSubscriber.subscribeChannel(channel);
                        channel.subscribe(newSubscriber);
                        break;
                    case 2:
                        System.out.print("Enter subscriber name to remove: ");
                        String subToRemove = scanner.nextLine();
                        boolean removed = false;
                        for (Subscriber sub : channel.getSubscribers()) { // Use getSubscribers()
                            if (sub.getName().equals(subToRemove)) {
                                channel.unsubscribe(sub);
                                removed = true;
                                logger.info("Removed " + subToRemove + " from subscribers.");
                                break;
                            }
                        }
                        if (!removed) {
                            logger.warning("Subscriber not found: " + subToRemove);
                        }
                        break;

                    case 3:
                        System.out.print("Enter video title: ");
                        String videoTitle = scanner.nextLine();
                        channel.upload(videoTitle);
                        break;
                    case 4:
                        exit = true;
                        logger.info("Exiting the program.");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                logger.severe("An error occurred: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
