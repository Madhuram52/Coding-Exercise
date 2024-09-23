import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TokenManagerFactory tokenManagerFactory = TokenManagerFactory.getInstance();
        TokenManager tokenManager = tokenManagerFactory.getTokenManager();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Options: 1. Generate Token, 2. Validate Token, 3. Revoke Token, 0. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            try {
                if (choice == 0) {
                    System.out.println("Exiting...");
                    break;
                }

                switch (choice) {
                    case 1:
                        System.out.print("Enter User ID: ");
                        String userId = scanner.nextLine();
                        Token token = tokenManager.generateToken(userId);
                        System.out.println("Generated Token: " + token.getTokenValue());
                        break;

                    case 2:
                        System.out.print("Enter Token Value: ");
                        String tokenValue = scanner.nextLine();
                        Token validationToken = new Token("dummy"); // Assuming valid user ID to create token object
                        validationToken = new Token("user1"); // Assuming valid user ID to create token object
                        if (tokenManager.validateToken(validationToken)) {
                            System.out.println("Token is valid.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Token Value to revoke: ");
                        String revokeTokenValue = scanner.nextLine();
                        Token revokeToken = new Token("dummy");  // Placeholder token creation
                        tokenManager.revokeToken(revokeToken);
                        System.out.println("Token revoked.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        scanner.close();
    }
}
