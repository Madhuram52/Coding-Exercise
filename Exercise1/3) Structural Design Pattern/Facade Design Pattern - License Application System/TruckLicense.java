// TruckLicense.java
public class TruckLicense implements License {
    private final PaymentSystem paymentSystem;

    public TruckLicense() {
        this.paymentSystem = new PaymentSystem();
    }

    public void apply(String applicantName, int applicantAge) {
        Logger.info("Applying for a truck license for " + applicantName + ", age: " + applicantAge);
        if (applicantAge < 21) {
            Logger.info("Sorry, you must be at least 21 years old to apply for a truck license.");
            return;
        }

        Logger.info("Processing payment...");
        boolean paymentSuccess = paymentSystem.processPayment(100.0);
        if (paymentSuccess) {
            processApplication(applicantName);
        } else {
            Logger.info("Payment failed. Application rejected for " + applicantName);
        }
    }

    private void processApplication(String applicantName) {
        Logger.info("Processing application...");
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            Logger.error("Application process interrupted", e);
        }
        Logger.info("Application approved. Congratulations, " + applicantName + "!");
    }
}
