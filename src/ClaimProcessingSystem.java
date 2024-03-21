import java.util.Scanner;
import java.util.List;


public class ClaimProcessingSystem {
    private ClaimProcessManager claimProcessManager;
    private Scanner scanner = new Scanner(System.in);

    public ClaimProcessingSystem(ClaimProcessManager claimProcessManager) {
        this.claimProcessManager = claimProcessManager;
    }

    private void addNewClaim() {
        System.out.println("Enter Claim ID:");
        String id = scanner.nextLine();

        // Example details gathering. Extend this as needed for your application.
        System.out.println("Enter Claim Amount:");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume the leftover newline

        // Assuming a simplified claim creation for demonstration
        Claim newClaim = new Claim();  // Assuming an appropriate constructor or setters
        newClaim.setId(id);
        newClaim.setClaimAmount(amount);
        // Set other details as necessary...

        claimProcessManager.add(newClaim);
        System.out.println("Claim added successfully.");
    }

    private void updateClaim() {
        System.out.println("Enter Claim ID to update:");
        String id = scanner.nextLine();
        Claim claim = claimProcessManager.getOne(id);

        if (claim != null) {
            // For simplicity, let's assume we're just updating the claim amount
            System.out.println("Enter new Claim Amount:");
            double newAmount = scanner.nextDouble();
            scanner.nextLine();  // Consume the leftover newline

            claim.setClaimAmount(newAmount);
            claimProcessManager.update(claim);
            System.out.println("Claim updated successfully.");
        } else {
            System.out.println("Claim not found.");
        }
    }

    private void deleteClaim() {
        System.out.println("Enter Claim ID to delete:");
        String id = scanner.nextLine();
        claimProcessManager.delete(id);
        System.out.println("Claim deleted successfully.");
    }

    private void viewClaim() {
        System.out.print("Enter Claim ID to view: ");
        String id = scanner.nextLine();
        Claim claim = claimProcessManager.getOne(id);

        if (claim != null) {
            claim.displayClaimDetails();
        } else {
            System.out.println("Claim not found.");
        }
    }


    private void viewAllClaims() {
        List<Claim> allClaims = claimProcessManager.getAll();
        if (allClaims.isEmpty()) {
            System.out.println("No claims to display.");
        } else {
            allClaims.forEach(Claim::displayClaimDetails);
        }
    }


    public void userInterface() {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Claim Processing System Menu ---");
            System.out.println("1. Add a new claim");
            System.out.println("2. Update an existing claim");
            System.out.println("3. Delete a claim");
            System.out.println("4. View a claim");
            System.out.println("5. View all claims");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    addNewClaim();
                    break;
                case 2:
                    updateClaim();
                    break;
                case 3:
                    deleteClaim();
                    break;
                case 4:
                    viewClaim();
                    break;
                case 5:
                    viewAllClaims();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting Claim Processing System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        ClaimProcessManager manager = new ConcreteClaimProcessManager();  // Your concrete implementation
        ClaimProcessingSystem system = new ClaimProcessingSystem(manager);
        system.userInterface();
    }
}
