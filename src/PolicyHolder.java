import java.util.List;
/**
 * @author <Nguyen Trung Tin - s3988418>
 */
public class PolicyHolder extends Customer {
    private List<Dependent> dependents;

    public void addDependent(Dependent dependent) {
        dependents.add(dependent);
    }

    public void removeDependent(Dependent dependent) {
        dependents.remove(dependent);
    }

    public List<Dependent> displayDependents() {
        return dependents;
    }

    @Override
    public void displayDetails() {
        System.out.println("Policy Holder Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + fullName);

        // Use getCardNumber() to get the insurance card number
        System.out.println("Insurance Card Number: " + (insuranceCard != null ? insuranceCard.getCardNumber() : "No card"));

        System.out.println("Dependents:");
        if (dependents != null && !dependents.isEmpty()) {
            for (Dependent dependent : dependents) {
                System.out.println("\tDependent Name: " + dependent.fullName);
                // Additional details for each dependent can be displayed here
            }
        } else {
            System.out.println("\tNo dependents.");
        }

        System.out.println("Claims:");
        if (listOfClaims != null && !listOfClaims.isEmpty()) {
            for (Claim claim : listOfClaims) {
                // Use getId() and getClaimAmount() to access Claim properties
                System.out.println("\tClaim ID: " + claim.getId() + " - Amount: $" + claim.getClaimAmount());
                // Further details for each claim can be displayed here
            }
        } else {
            System.out.println("\tNo claims.");
        }
    }
}
