public class User extends ManagementSystem implements IUser {
    private String userName;
    private double balance;
    public User(double balance, String userName){
        this.balance = balance;
        this.userName = userName;
    }
    public User(String userName){
        this(0, userName);
    }


    public boolean submitTransaction(double amount, String description, String destination){

        boolean check = super.addExpenseTransaction(new Transaction(-amount, description, userName, destination));
        if (check)
            balance -= amount;

        return check;
    }
    public boolean receiveTransaction(double amount, String description, String source){
        boolean check =  super.addIncomeTransaction(new Transaction(amount, description, source, userName));
        if (check)
            balance += amount;
        return check;
    }

    @Override
    public String viewAllTransfersInfo(){
        return "balance: " + balance + "\n" + super.viewAllTransfersInfo();
    }

    @Override
    public double getUserBalance() {
        return balance;
    }
}
