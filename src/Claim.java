/**
 * @author <Nguyen Trung Tin - s3988418>
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;


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
        System.out.println("Receiver Banking Info: " + receiverBankingInfo + "\n" +
                "----------------------------------------\n");
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

    public void setStatus(String status) {
        this.status = status;
    }

    public void setReceiverBankingInfo(String receiverBankingInfo) {
        this.receiverBankingInfo = receiverBankingInfo;
    }

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public String toFormattedString() {
        // Using pipe '|' as a delimiter to avoid conflicts with commas in the data
        return String.join("|",
                this.id,
                this.claimDate != null ? dateFormat.format(this.claimDate) : "null",
                this.insuredPerson != null ? this.insuredPerson.getId() : "null",
                this.cardNumber != null ? this.cardNumber : "null",
                this.examDate != null ? dateFormat.format(this.examDate) : "null",
                String.join(";", this.documents), // Assuming documents are semi-colon delimited within this field
                String.valueOf(this.claimAmount),
                this.status != null ? this.status : "null",
                this.receiverBankingInfo != null ? this.receiverBankingInfo : "null"
        );
    }

    public static Claim fromFormattedString(String line) {
        String[] parts = line.split("\\|");
        Claim claim = new Claim();

        claim.setId(parts[0]);
        try {
            claim.setClaimDate(parts[1].equals("null") ? null : dateFormat.parse(parts[1]));
        } catch (ParseException e) {
            // Handle the case where the date is not in the expected format
            e.printStackTrace();
        }

        // You'll need logic to retrieve the insuredPerson by ID here
        String insuredPersonId = parts[2].equals("null") ? null : parts[2];
        // Example: claim.setInsuredPerson(findInsuredPersonById(insuredPersonId));

        claim.setCardNumber(parts[3].equals("null") ? null : parts[3]);

        try {
            claim.setExamDate(parts[4].equals("null") ? null : dateFormat.parse(parts[4]));
        } catch (ParseException e) {
            // Handle the case where the date is not in the expected format
            e.printStackTrace();
        }

        claim.setDocuments(parts[5].equals("null") ? List.of() : Arrays.asList(parts[5].split(";")));
        claim.setClaimAmount(Double.parseDouble(parts[6]));
        claim.setStatus(parts[7].equals("null") ? null : parts[7]);
        claim.setReceiverBankingInfo(parts[8].equals("null") ? null : parts[8]);

        return claim;
    }
}

