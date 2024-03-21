/**
 * @author <Nguyen Trung Tin - s3988418>
 */
import java.util.Date;

public class InsuranceCard {
    private String cardNumber;
    private Customer cardHolder;
    private PolicyHolder policyOwner;
    private Date expirationDate;

    public boolean isValid() {
        // Implement logic to check if the card is valid
        return !expirationDate.before(new Date());
    }
}
