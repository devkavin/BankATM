import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATMMachine {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.checkPin();
    }
}

class ATM {
    private float Balance;
    private int PIN = 5674;
    private final List<String> transactionHistory;

    public ATM() {
        Balance = 0;
        transactionHistory = new ArrayList<>(); // Initialized transaction history
    }

    public void checkPin() {
        System.out.println("Please Enter your Pin: ");
        Scanner sc = new Scanner(System.in);
        int pin = sc.nextInt();
        if (pin == PIN) {
            System.out.println("You have entered the ATM Menu");
            menu();
        } else {
            System.out.println("Invalid Pin");
        }
    }

    private void menu() {
        System.out.println("Choose an option to continue: ");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Change PIN");
        System.out.println("5. View Transaction History");
        System.out.println("6. Exit");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        switch(option){
            case 1:
                checkBalance();
                break;
            case 2:
                withdrawMoney();
                break;
            case 3:
                depositMoney();
                break;
            case 4:
                changePin();
                break;
            case 5:
                transactionHistory();
                break;
            case 6:
                break;
            default:
                System.out.println("Invalid Option");
        }
    }

    private void checkBalance() {
        System.out.println("Your account balance is: " + Balance);
        menu();
    }

    private void withdrawMoney() {
        System.out.println("Please enter the amount to Withdraw:" );
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextInt();
        if (amount > Balance) {
            System.out.println("Insufficient Balance");
        } else {
            Balance -= amount;
            transactionHistory.add("Withdrew: LKR " + amount);
            System.out.println("Your account new balance is: " + Balance);
        }
        menu();
    }

    private void depositMoney() {
        System.out.println("Please enter the amount to Deposit:" );
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextInt();
        Balance += amount;
        transactionHistory.add("Deposited: LKR " + amount);
        System.out.println("Your account new balance is: " + Balance);
        menu();
    }

    private void changePin() {
        System.out.println("Please enter your current PIN to continue: " );
        Scanner sc = new Scanner(System.in);
        int pin = sc.nextInt();
        // Check current PIN before proceeding
        if (pin == PIN) {
            System.out.println("Please enter the new 4 digit PIN: ");
            Scanner sc2 = new Scanner(System.in);
            int pin2 = sc2.nextInt();
            if (pin2 == PIN) {
                System.out.println("Invalid PIN. Same PIN cannot be entered twice.");
                menu();
            } else {
                PIN = pin2;
                System.out.println("You have successfully changed the PIN.");
                System.out.println("Please Login again.");
                checkPin();
            }
        } else {
            System.out.println("Invalid PIN");
            menu();
        }
    }

    private void transactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transaction history available");
        } else {
            System.out.println("Transaction history: ");
            for (String s : transactionHistory) {
                System.out.println(s);
            }
        }
        menu();
    }
}
