import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class ClaimProcessingSystem {
    private ClaimProcessManager claimProcessManager;
    private Scanner scanner = new Scanner(System.in);

    public ClaimProcessingSystem(ClaimProcessManager claimProcessManager) {
        this.claimProcessManager = claimProcessManager;
    }

    private void addNewClaim() {
        System.out.println("Enter Claim ID:");
        String id = scanner.nextLine();

        System.out.println("Enter Claim Amount:");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume the newline

        // Additional details gathering
        System.out.println("Enter Insured Person's Full Name:");
        String insuredPersonName = scanner.nextLine();

        System.out.println("Enter Card Number:");
        String cardNumber = scanner.nextLine();

        System.out.println("Enter Claim Date (yyyy-MM-dd):");
        String claimDateStr = scanner.nextLine();

        System.out.println("Enter Exam Date (yyyy-MM-dd):");
        String examDateStr = scanner.nextLine();

        System.out.println("Enter any Documents (comma separated):");
        String docs = scanner.nextLine();
        List<String> documents = new ArrayList<>();
        for (String doc : docs.split(",")) {
            documents.add(doc.trim());
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date claimDate = null, examDate = null;
        try {
            claimDate = sdf.parse(claimDateStr);
            examDate = sdf.parse(examDateStr);
        } catch (Exception e) {
            System.out.println("Error parsing dates. Ensure they're in the format yyyy-MM-dd.");
        }

        // Assuming PolicyHolder or Dependent instance creation here based on insuredPersonName
        // For now, just use the name directly, but you should create or find a matching Customer object in your system
        PolicyHolder insuredPerson = new PolicyHolder(id, insuredPersonName); // Example

        // Create the new claim with all gathered information
        Claim newClaim = new Claim();
        newClaim.setId(id);
        newClaim.setClaimAmount(amount);
        newClaim.setCardNumber(cardNumber);
        newClaim.setClaimDate(claimDate);
        newClaim.setExamDate(examDate);
        newClaim.setDocuments(documents);
        // This is a placeholder - typically you'd link to an actual Customer object
        newClaim.setInsuredPerson(insuredPerson);

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
