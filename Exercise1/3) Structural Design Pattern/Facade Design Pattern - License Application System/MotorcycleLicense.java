// MotorcycleLicense.java
public class MotorcycleLicense implements License {
    private final PaymentSystem paymentSystem;

    public MotorcycleLicense() {
        this.paymentSystem = new PaymentSystem();
    }

    public void apply(String applicantName, int applicantAge) {
        Logger.info("Applying for a motorcycle license for " + applicantName + ", age: " + applicantAge);
        if (applicantAge < 16) {
            Logger.info("Sorry, you must be at least 16 years old to apply for a motorcycle license.");
            return;
        }

        Logger.info("Processing payment...");
        boolean paymentSuccess = paymentSystem.processPayment(30.0);
        if (paymentSuccess) {
            processApplication(applicantName);
        } else {
            Logger.info("Payment failed. Application rejected for " + applicantName);
        }
    }

    private void processApplication(String applicantName) {
        Logger.info("Processing application...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Logger.error("Application process interrupted", e);
        }
        Logger.info("Application approved. Congratulations, " + applicantName + "!");
    }
}
