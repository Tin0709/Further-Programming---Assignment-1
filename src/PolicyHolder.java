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
        // Basic details
        System.out.println("Policy Holder Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + fullName);

        // Insurance card details
        System.out.println("Insurance Card Number: " + (insuranceCard != null ? insuranceCard.getCardNumber() : "No card"));

        // Dependents' details
        System.out.println("Dependents:");
        if (dependents != null && !dependents.isEmpty()) {
            for (Dependent dependent : dependents) {
                System.out.println("\tDependent Name: " + dependent.fullName);
                // You can add more details for each dependent if necessary
            }
        } else {
            System.out.println("\tNo dependents.");
        }

        // Claims details
        System.out.println("Claims:");
        if (listOfClaims != null && !listOfClaims.isEmpty()) {
            for (Claim claim : listOfClaims) {
                System.out.println("\tClaim ID: " + claim.getId() + " Amount: " + claim.getClaimAmount());
                // You can add more details for each claim if necessary
            }
        } else {
            System.out.println("\tNo claims.");
        }
    }
}
