import java.util.ArrayList;

public class ManagementSystem implements IManagementSystem {

    public ManagementSystem() {
        income = new Income();
        expense = new Expense();
        transfer = new Transfer();
    }

    private Income income;
    private Expense expense;
    private Transfer transfer;


    @Override
    public boolean addIncomeTransaction(ITransaction i) {
        if (i.getAmount() > 0){
            income.addTransaction(i);
            transfer.addTransaction(i);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean addExpenseTransaction(ITransaction i) {
        if (i.getAmount() < 0){
            expense.addTransaction(i);
            transfer.addTransaction(i);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public ArrayList<ITransaction> getAllTransactionsInfo() {
        return transfer.getAllTransactions();
    }

    @Override
    public double getIncomeInfo() {
        return income.getAllIncome();
    }

    @Override
    public double getExpenseInfo() {
        return expense.getAllExpense();
    }

    @Override
    public ArrayList<ITransaction> getIncomeTransactionsInfo() {
        return income.getAllTransactions();
    }

    @Override
    public ArrayList<ITransaction> getExpenseTransactionsInfo() {
        return expense.getAllTransactions();
    }

    @Override
    public String viewAllTransfersInfo() {
        StringBuilder b = new StringBuilder();
        b.append("difference between income and expenses: ");
        b.append(transfer.difference());
        b.append("\n");
        for (ITransaction tr : transfer.getAllTransactions()){
            b.append("Amount: ");
            b.append(tr.getAmount());
            b.append(" | ");
            b.append("description: ");
            b.append(tr.getDescription());
            b.append(" | ");
            b.append("source: ");
            b.append(tr.getSource());
            b.append(" | ");
            b.append("destination: ");
            b.append(tr.getDestination());
            b.append(" | ");
            b.append("date: ");
            b.append(tr.getDate());
            b.append("\n");
        }
        return b.toString();
    }

    @Override
    public String viewIncomeInfo() {
        StringBuilder b = new StringBuilder();
        b.append("Income of all time: ");
        b.append(income.getAllIncome());
        b.append("\n");
        for (ITransaction tr : income.getAllTransactions()){
            b.append("Amount: ");
            b.append(tr.getAmount());
            b.append(" | ");
            b.append("description: ");
            b.append(tr.getDescription());
            b.append(" | ");
            b.append("source: ");
            b.append(tr.getSource());
            b.append(" | ");
            b.append("destination: ");
            b.append(tr.getDestination());
            b.append(" | ");
            b.append("date: ");
            b.append(tr.getDate());
            b.append("\n");
        }
        return b.toString();
    }

    @Override
    public String viewExpenseInfo() {
        StringBuilder b = new StringBuilder();
        b.append("Expenses of all time: ");
        b.append(expense.getAllExpense());
        b.append("\n");
        for (ITransaction tr : expense.getAllTransactions()){
            b.append("Amount: ");
            b.append(tr.getAmount());
            b.append(" | ");
            b.append("description: ");
            b.append(tr.getDescription());
            b.append(" | ");
            b.append("source: ");
            b.append(tr.getSource());
            b.append(" | ");
            b.append("destination: ");
            b.append(tr.getDestination());
            b.append(" | ");
            b.append("date: ");
            b.append(tr.getDate());
            b.append("\n");
        }
        return b.toString();
    }
}
