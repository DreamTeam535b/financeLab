import java.util.Date;

public class Transaction implements ITransaction {

    public Transaction(double amount, String description, String source, String destination) {
        this.amount = amount;
        this.description = description;
        this.date = new Date();
        this.source = source;
        this.destination = destination;
    }

    private double amount;
    private Date date;
    private String description;
    private String source;
    private String destination;

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public String getDestination() {
        return destination;
    }
}
