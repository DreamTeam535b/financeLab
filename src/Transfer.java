import java.util.ArrayList;

public class Transfer implements IFinancialOperations {

    public Transfer() {
        transactions = new ArrayList<ITransaction>();
    }

    private ArrayList<ITransaction> transactions;

    public ArrayList<ITransaction> getAllTransactions() {
        return transactions;
    }


    public double difference() {
        double d = 0;

        for (ITransaction transaction : transactions) {
            d += transaction.getAmount();
        }

        return d;
    }

    @Override
    public void addTransaction(ITransaction i) {
        transactions.add(i);
    }
}
