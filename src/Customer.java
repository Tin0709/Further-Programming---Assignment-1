import java.util.List;
/**
 * @author <Nguyen Trung Tin - s3988418>
 */
public abstract class Customer {
    protected String id;
    protected String fullName;
    protected InsuranceCard insuranceCard;
    protected List<Claim> listOfClaims;

    public abstract void displayDetails();
}
