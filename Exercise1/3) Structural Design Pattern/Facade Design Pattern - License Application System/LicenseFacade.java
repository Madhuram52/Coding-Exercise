// LicenseFacade.java
public class LicenseFacade {
    public void applyForLicense(LicenseType licenseType, String applicantName, int applicantAge) {
        License license = null;
        switch (licenseType) {
            case CAR:
                license = new CarLicense();
                break;
            case MOTORCYCLE:
                license = new MotorcycleLicense();
                break;
            case TRUCK:
                license = new TruckLicense();
                break;
            default:
                Logger.info("Sorry, we do not issue licenses for this type of vehicle.");
                return;
        }
        license.apply(applicantName, applicantAge);
    }
}
