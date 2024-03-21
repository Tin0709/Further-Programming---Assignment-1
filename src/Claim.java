/**
 * @author <Nguyen Trung Tin - s3988418>
 */
import java.util.Date;
import java.util.List;

public class Claim {
    private String id;
    private Date claimDate;
    private Customer insuredPerson;
    private String cardNumber;
    private Date examDate;
    private List<String> documents;
    private double claimAmount;
    private String status;
    private String receiverBankingInfo;

    public void updateStatus(String status) {
        this.status = status;
    }

    public void addDocument(String documentName) {
        documents.add(documentName);
    }

    public void displayClaimDetails() {
        // Implement method to display claim details
    }
}
