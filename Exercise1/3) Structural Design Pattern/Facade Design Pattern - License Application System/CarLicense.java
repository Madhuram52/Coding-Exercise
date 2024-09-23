// CarLicense.java
public class CarLicense implements License {
    private final PaymentSystem paymentSystem;

    public CarLicense() {
        this.paymentSystem = new PaymentSystem();
    }

    public void apply(String applicantName, int applicantAge) {
        Logger.info("Applying for a car license for " + applicantName + ", age: " + applicantAge);
        if (applicantAge < 18) {
            Logger.info("Sorry, you must be at least 18 years old to apply for a car license.");
            return;
        }

        Logger.info("Processing payment...");
        boolean paymentSuccess = paymentSystem.processPayment(50.0);
        if (paymentSuccess) {
            processApplication(applicantName);
        } else {
            Logger.info("Payment failed. Application rejected for " + applicantName);
        }
    }

    private void processApplication(String applicantName) {
        Logger.info("Processing application...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Logger.error("Application process interrupted", e);
        }
        Logger.info("Application approved. Congratulations, " + applicantName + "!");
    }
}
