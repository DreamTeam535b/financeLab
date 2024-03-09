import java.util.ArrayList;

public interface IManagementSystem{
    //adding transactions
    boolean addIncomeTransaction(ITransaction i); //plus money
    boolean addExpenseTransaction(ITransaction i);//minus money

    //get info about transactions and balance
    ArrayList<ITransaction> getAllTransactionsInfo(); //all transactions

    //get amount
    double getIncomeInfo(); //all income amount
    double getExpenseInfo(); //all expense amount

    //get transactions info
    ArrayList<ITransaction> getIncomeTransactionsInfo(); //all income transactions
    ArrayList<ITransaction> getExpenseTransactionsInfo(); //all expense transactions

    //output info
    String viewAllTransfersInfo(); //all transfers info
    String viewIncomeInfo();//income transactions and amount of income
    String viewExpenseInfo();//expense transactions and amount of expense
}

