/**
 * @author <Nguyen Trung Tin - s3988418>
 */

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        ClaimProcessManager manager = new ConcreteClaimProcessManager();
//        ClaimProcessingSystem system = new ClaimProcessingSystem(manager);
//        system.userInterface();

        ConcreteClaimProcessManager manager = new ConcreteClaimProcessManager();
        List<Claim> claims = DataPersistence.loadClaimsFromTextFile();

        // Add each claim to the manager
        for (Claim claim : claims) {
            manager.add(claim);
        }

        ClaimProcessingSystem system = new ClaimProcessingSystem(manager);
        system.userInterface();


    }
}