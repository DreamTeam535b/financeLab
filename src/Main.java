import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        User user = new User("DreamTeam");

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Your balance = " + user.getUserBalance());
            System.out.println("type \"help\" to see other commands");
            switch (scanner.nextLine().toLowerCase()){
                case "help":
                    StringBuilder sb = new StringBuilder();
                    sb.append("\"help\" - shows available commands.\n");
                    sb.append("\"submit\" - submit a transaction.\n");
                    sb.append("\"receive\" - receive a transaction.\n");
                    sb.append("\"show all\" - show all transactions and differences.\n");
                    sb.append("\"show expense\" - show expenses.\n");
                    sb.append("\"show income\" - show profit.\n");
                    System.out.println(sb.toString());
                    break;
                case "submit": {
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
                    System.out.println(user.viewAllTransfersInfo());
                }
                    break;
                case "show expense": {
                    System.out.println(user.viewExpenseInfo());
                    break;
                }
                case "show income": {
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