/**
 * @author <Nguyen Trung Tin - s3988418>
 */
import java.text.SimpleDateFormat;
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


    public void displayClaimDetails() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("Claim ID: " + id);
        System.out.println("Claim Date: " + (claimDate != null ? dateFormat.format(claimDate) : "N/A"));
        System.out.println("Insured Person: " + (insuredPerson != null ? insuredPerson.getFullName() : "N/A"));
        System.out.println("Card Number: " + (cardNumber != null ? cardNumber : "N/A"));
        System.out.println("Exam Date: " + (examDate != null ? dateFormat.format(examDate) : "N/A"));
        System.out.println("Documents:");
        if (documents != null && !documents.isEmpty()) {
            for (String document : documents) {
                System.out.println("\t" + document);
            }
        } else {
            System.out.println("\tNo documents.");
        }
        System.out.println("Claim Amount: $" + String.format("%.2f", claimAmount));
        System.out.println("Status: " + status);
        System.out.println("Receiver Banking Info: " + receiverBankingInfo);
    }
    public String getId() {
        return id;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public void setDocuments(List<String> documents) {
        this.documents = documents;
    }

    public void setInsuredPerson(Customer insuredPerson) {
        this.insuredPerson = insuredPerson;
    }
}

