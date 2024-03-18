import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UsersAccounts users = new UsersAccounts();

        User user = null;

        Scanner scanner = new Scanner(System.in);

        while (true){
            if (user != null) {
                System.out.println("You are logged in!\nYour balance = " + user.getUserBalance());
            }
            System.out.println("type \"help\" to see other commands");
            switch (scanner.nextLine().toLowerCase()){
                case "help":
                    StringBuilder sb = new StringBuilder();
                    sb.append("\"help\" - shows available commands.\n");
                    sb.append("\"create\" - creates an account.\n");
                    sb.append("\"login\" - logs into account.\n");
                    sb.append("\"submit\" - submit a transaction.\n");
                    sb.append("\"receive\" - receive a transaction.\n");
                    sb.append("\"show all\" - show all transactions and differences.\n");
                    sb.append("\"show expense\" - show expenses.\n");
                    sb.append("\"show income\" - show profit.\n");
                    System.out.println(sb.toString());
                    break;
                case "create":
                {
                    String userlogin;
                    String userpassword;
                    System.out.print("Enter login: ");
                    userlogin = scanner.nextLine();
                    System.out.print("Enter password: ");
                    userpassword = scanner.nextLine();
                    try {
                        users.createUser(userlogin, userpassword);
                    }
                    catch (Exception ex){
                        System.out.println(ex.toString());
                    }
                    break;
                }
                case "login":
                {
                    String userlogin;
                    String userpassword;
                    System.out.print("Enter login: ");
                    userlogin = scanner.nextLine();
                    System.out.print("Enter password: ");
                    userpassword = scanner.nextLine();
                    try {
                        user = users.getUser(userlogin, userpassword);
                    }
                    catch (Exception ex){
                        System.out.println(ex.toString());
                    }
                    break;
                }

                case "submit": {
                    if (user == null)
                    {
                        System.out.println("you are not logged in!");
                        break;
                    }
                    String amountStr;
                    double amount;
                    String description;
                    String destination;

                    System.out.print("Enter amount: ");
                    amountStr = scanner.nextLine();
                    try {
                        amount = Double.parseDouble(amountStr);
                    } catch (Exception exception) {
                        System.out.println("Error! Incorrect double. Try again.");
                        break;
                    }
                    System.out.print("Enter description: ");
                    description = scanner.nextLine();
                    System.out.print("Enter destination: ");
                    destination = scanner.nextLine();


                    if (user.submitTransaction(amount, description, destination)) {
                        System.out.println("Successful!");
                    } else
                        System.out.println("Failure!");

                    break;
                }
                case "receive": {
                    if (user == null)
                    {
                        System.out.println("you are not logged in!");
                        break;
                    }
                    String amountStr;
                    double amount;
                    String description;
                    String source;

                    System.out.print("Enter amount: ");
                    amountStr = scanner.nextLine();
                    try {
                        amount = Double.parseDouble(amountStr);
                    } catch (Exception exception) {
                        System.out.println("Error! Incorrect double. Try again.");
                        break;
                    }
                    System.out.print("Enter description: ");
                    description = scanner.nextLine();
                    System.out.print("Enter source: ");
                    source = scanner.nextLine();


                    if (user.receiveTransaction(amount, description, source)) {
                        System.out.println("Successful!");
                    } else
                        System.out.println("Failure!");

                    break;
                }
                case "show all":{
                    if (user == null)
                    {
                        System.out.println("you are not logged in!");
                        break;
                    }
                    System.out.println(user.viewAllTransfersInfo());
                }
                    break;
                case "show expense": {
                    if (user == null)
                    {
                        System.out.println("you are not logged in!");
                        break;
                    }
                    System.out.println(user.viewExpenseInfo());
                    break;
                }
                case "test":{
                    SwingGUI r = new SwingGUI(users);
                    r.AccountManagementGUI();
                    break;
                }
                case "show income": {
                    if (user == null)
                    {
                        System.out.println("you are not logged in!");
                        break;
                    }
                    System.out.println(user.viewIncomeInfo());
                    break;
                }
                default:
                    System.out.println("Unknown command!");
                    break;

            }
        }


    }
}

