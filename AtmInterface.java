import java.util.*;

public class ATMApp {
    static Scanner sc = new Scanner(System.in);
    static double balance = 10000;
    static List<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        String userId = "user123";
        String userPin = "1234";

        System.out.print("Enter User ID: ");
        String enteredId = sc.nextLine();

        System.out.print("Enter PIN: ");
        String enteredPin = sc.nextLine();

        if (userId.equals(enteredId) && userPin.equals(enteredPin)) {
            System.out.println("\nLogin Successful!\n");

            while (true) {
                System.out.println("ATM Menu:");
                System.out.println("1. Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                System.out.println("6. Check Balance");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        showTransactionHistory();
                        break;
                    case 2:
                        withdraw();
                        break;
                    case 3:
                        deposit();
                        break;
                    case 4:
                        transfer();
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        System.exit(0);
                    case 6:
                        checkBalance();
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
                System.out.println();
            }

        } else {
            System.out.println("Invalid ID or PIN.");
        }
    }

    static void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction History:");
            for (String t : transactionHistory) {
                System.out.println(t);
            }
        }
    }

    static void withdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = sc.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawn: ₹" + amount);
            System.out.println("Withdrawal successful. Current balance: ₹" + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    static void deposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = sc.nextDouble();
        balance += amount;
        transactionHistory.add("Deposited: ₹" + amount);
        System.out.println("Deposit successful. Current balance: ₹" + balance);
    }

    static void transfer() {
        sc.nextLine(); 
        System.out.print("Enter recipient's name: ");
        String recipient = sc.nextLine();

        System.out.print("Enter amount to transfer: ₹");
        double amount = sc.nextDouble();

        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Transferred ₹" + amount + " to " + recipient);
            System.out.println("Transfer to " + recipient + " successful. Current balance: ₹" + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    static void checkBalance() {
        System.out.println("Your current balance is: ₹" + balance);
    }
}
