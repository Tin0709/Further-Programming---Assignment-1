import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author <Nguyen Trung Tin - s3988418>
 */

public class DataPersistence {

    private static final String CLAIMS_FILE = "claims_data.txt";

    public static void saveClaimsToTextFile(List<Claim> claims) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CLAIMS_FILE))) {
            for (Claim claim : claims) {
                writer.write(claim.toFormattedString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Claim> loadClaimsFromTextFile() {
        List<Claim> claims = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CLAIMS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Claim claim = Claim.fromFormattedString(line);
                claims.add(claim);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return claims;
    }
}
