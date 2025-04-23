
interface InsuranceOperations {
    double calculatePremium();
    void displayPolicy();
}

class InvalidPolicyDataException extends Exception {
    public InvalidPolicyDataException(String message) {
        super(message);
    }
}

class InvalidPremiumException extends Exception {
    public InvalidPremiumException(String message) {
        super(message);
    }
}

abstract class InsurancePolicy implements InsuranceOperations {
    protected String customerName;
    protected String policyNumber;
    protected double sumInsured;
    protected double premiumRate;

    public InsurancePolicy(String customerName, String policyNumber, double sumInsured, double premiumRate)
            throws InvalidPolicyDataException, InvalidPremiumException {

        if (!policyNumber.matches("POL\\d{3}")) {
            throw new InvalidPolicyDataException("Policy number must start with 'POL' followed by 3 digits.");
        }

        if (!customerName.matches("[A-Za-z]+\\s[A-Za-z]+")) {
            throw new InvalidPolicyDataException("Customer name must contain only alphabets and one space.");
        }

        if (sumInsured <= 0 || premiumRate <= 0) {
            throw new InvalidPremiumException("Sum insured and premium rate must be greater than 0.");
        }

        this.customerName = customerName;
        this.policyNumber = policyNumber;
        this.sumInsured = sumInsured;
        this.premiumRate = premiumRate;
    }

    @Override
    public void displayPolicy() {
        System.out.println("Policy Number: " + policyNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Sum Insured: " + sumInsured);
        System.out.println("Premium Rate: " + premiumRate);
    }
}

class HealthInsurancePolicy extends InsurancePolicy {
    private int customerAge;

    public HealthInsurancePolicy(String customerName, String policyNumber, double sumInsured, double premiumRate, int customerAge)
            throws InvalidPolicyDataException, InvalidPremiumException {
        super(customerName, policyNumber, sumInsured, premiumRate);
        this.customerAge = customerAge;
    }

    @Override
    public double calculatePremium() {
        if (customerAge > 60) {
            return sumInsured * premiumRate * 1.2;
        }
        return sumInsured * premiumRate;
    }

    @Override
    public void displayPolicy() {
        super.displayPolicy();
        System.out.println("Customer Age: " + customerAge);
        System.out.println("Calculated Premium: " + calculatePremium());
    }
}

class AutoInsurancePolicy extends InsurancePolicy {
    private String vehicleType;
    public AutoInsurancePolicy(String customerName, String policyNumber, double sumInsured, double premiumRate, String vehicleType)
            throws InvalidPolicyDataException, InvalidPremiumException {
        super(customerName, policyNumber, sumInsured, premiumRate);
        this.vehicleType = vehicleType;
    }

    @Override
    public double calculatePremium() {
        double extra = 0.0;
        switch (vehicleType.toLowerCase()) {
            case "suv":
                extra = 0.3;
                break;
            case "truck":
                extra = 0.5;
                break;
            case "car":
                extra = 0.0;
                break;
            default:
                System.out.println("Unknown vehicle type. No extra premium applied.");
        }
        return sumInsured * premiumRate * (1 + extra);
    }

    @Override
    public void displayPolicy() {
        super.displayPolicy();
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Calculated Premium: " + calculatePremium());
    }
}

public class PolicyInsuranceDemo{
    public static void main(String[] args) {
        try {
            InsurancePolicy healthPolicy = new HealthInsurancePolicy("Alice Brown", "POL123", 100000, 0.05, 65);
            InsurancePolicy autoPolicy = new AutoInsurancePolicy("John Smith", "POL456", 200000, 0.04, "SUV");

            System.out.println("---- Health Insurance Policy ----");
            healthPolicy.displayPolicy();

            System.out.println("\n---- Auto Insurance Policy ----");
            autoPolicy.displayPolicy();

        } catch (InvalidPolicyDataException | InvalidPremiumException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            InsurancePolicy invalidPolicy = new HealthInsurancePolicy("Bob@Smith", "P123", -10000, 0, 45);
        } catch (Exception e) {
            System.out.println("\nException on invalid policy: " + e.getMessage());
        }
    }
}