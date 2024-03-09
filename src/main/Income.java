import java.util.ArrayList;

public class Income implements IFinancialOperations {

    public Income() {
        transactions = new ArrayList<ITransaction>();
    }

    private ArrayList<ITransaction> transactions;

    public ArrayList<ITransaction> getAllTransactions(){
        return transactions;
    }

    public double getAllIncome() {
        double income = 0;

        for (ITransaction transaction : transactions) {
            income += transaction.getAmount();
        }

        return income;
    }

    @Override
    public void addTransaction(ITransaction i) {
        transactions.add(i);
    }
}

