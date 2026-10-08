import java.util.Scanner;

class BankAccount {
    // Data members
    String accountNumber;
    String accountHolderName;
    double balance;

    // Parameterized constructor to initialize account details
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Method to deposit amount
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw amount if sufficient balance is available
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }

    // Method to check current balance
    public double checkBalance() {
        return balance;
    }

    // Method to display account details and balance
    public void displayAccount() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Current Balance: " + balance);
    }
}

public class BankAccountManagement {

    // Separate method to handle deposit operation
    public static void performDeposit(BankAccount account, Scanner scanner) {
        System.out.print("\nEnter amount to deposit: ");
        double depositAmount = scanner.nextDouble();
        account.deposit(depositAmount);
    }

    // Separate method to handle withdrawal operation
    public static void performWithdrawal(BankAccount account, Scanner scanner) {
        System.out.print("\nEnter amount to withdraw: ");
        double withdrawAmount = scanner.nextDouble();
        account.withdraw(withdrawAmount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read account details and initial balance from the user
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String holderName = scanner.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initialBalance = scanner.nextDouble();

        // Create a BankAccount object using the parameterized constructor
        BankAccount account = new BankAccount(accNum, holderName, initialBalance);

        // Perform one deposit operation using a separate method
        performDeposit(account, scanner);

        // Perform one withdrawal operation using a separate method
        performWithdrawal(account, scanner);

        // Display the final account details
        account.displayAccount();

        scanner.close();
    }
}

