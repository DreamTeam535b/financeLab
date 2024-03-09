import java.util.ArrayList;

public class Expense implements IFinancialOperations {

    @Override
    public void addTransaction(ITransaction i) {
        transactions.add(i);
    }


    public Expense() {
        transactions = new ArrayList<ITransaction>();
    }

    private ArrayList<ITransaction> transactions;

    public ArrayList<ITransaction> getAllTransactions(){
        return transactions;
    }



    public double getAllExpense() {
        double expense = 0;

        for (ITransaction transaction : transactions) {
             expense += transaction.getAmount();
        }

        return expense;
    }
}

