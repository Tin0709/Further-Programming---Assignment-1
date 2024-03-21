/**
 * @author <Nguyen Trung Tin - s3988418>
 */
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class InsuranceCard {
    private String cardNumber;
    private Customer cardHolder;
    private PolicyHolder policyOwner;
    private Date expirationDate;

    // Constructor, getters, and setters would be here

    public boolean isValid() {
        // Convert the expiration date to LocalDate
        LocalDate expirationLocalDate = expirationDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        // Get today's date as LocalDate
        LocalDate today = LocalDate.now();

        // Check if today's date is before or equal to the expiration date
        return !today.isAfter(expirationLocalDate);
    }

}

