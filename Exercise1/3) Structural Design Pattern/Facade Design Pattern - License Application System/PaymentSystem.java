// PaymentSystem.java
import java.util.Scanner;

public class PaymentSystem {
    private final Scanner scanner;

    public PaymentSystem() {
        this.scanner = new Scanner(System.in);
    }

    public boolean processPayment(double amount) {
        try {
            Logger.info("Please enter your credit card number:");
            String creditCardNumber = scanner.nextLine();

            Logger.info("Please enter the expiration date (MM/YY):");
            scanner.nextLine();

            Logger.info("Please enter the CVV code:");
            scanner.nextLine();

            if (isValidCreditCardNumber(creditCardNumber)) {
                Logger.info("Payment of $" + amount + " was successful!");
                return true;
            } else {
                Logger.info("Payment failed. Invalid credit card number.");
                return false;
            }
        } catch (Exception e) {
            Logger.error("Payment processing failed.", e);
            return false;
        }
    }

    private boolean isValidCreditCardNumber(String creditCardNumber) {
        return creditCardNumber != null && creditCardNumber.length() == 16;
    }
}
