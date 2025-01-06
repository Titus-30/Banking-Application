import java.util.Scanner;

// Interface for banking operations
interface BankingOperations {
    void deposit(double amount);
    void withdraw(double amount);
    double checkBalance();
}

// Interface for loan eligibility
interface LoanEligible {
    void applyForLoan(double amount);
    void checkLoanStatus();
}

// Abstract Account class
abstract class Account implements BankingOperations {
    private String accountNumber;
    private String holderName;
    protected double balance;

    public Account(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    public abstract void displayAccountDetails();
}

// SavingsAccount class
class SavingsAccount1 extends Account implements LoanEligible {
    private double interestRate;

    public SavingsAccount1(String accountNumber, String holderName, double initialBalance, double interestRate) {
        super(accountNumber, holderName, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " into Savings Account. New balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from Savings Account. Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient balance in Savings Account.");
        }
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan of " + amount + " applied for Savings Account.");
    }

    @Override
    public void checkLoanStatus() {
        System.out.println("Loan application status: Under Review.");
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Savings Account - Account Number: " + getAccountNumber() + ", Holder: " + getHolderName()
                + ", Balance: " + balance + ", Interest Rate: " + interestRate + "%");
    }
}

// CheckingAccount class
class CheckingAccount1 extends Account {
    private double overdraftLimit;

    public CheckingAccount1(String accountNumber, String holderName, double initialBalance, double overdraftLimit) {
        super(accountNumber, holderName, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " into Checking Account. New balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from Checking Account. Remaining balance: " + balance);
        } else {
            System.out.println("Overdraft limit exceeded in Checking Account.");
        }
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Checking Account - Account Number: " + getAccountNumber() + ", Holder: " + getHolderName()
                + ", Balance: " + balance + ", Overdraft Limit: " + overdraftLimit);
    }
}

// FixedDeposit class
class FixedDeposit extends Account {
    private double maturityAmount;
    private int durationMonths;

    public FixedDeposit(String accountNumber, String holderName, double initialBalance, double maturityAmount, int durationMonths) {
        super(accountNumber, holderName, initialBalance);
        this.maturityAmount = maturityAmount;
        this.durationMonths = durationMonths;
    }

    @Override
    public void deposit(double amount) {
        System.out.println("Deposits not allowed in Fixed Deposit Account.");
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawals not allowed before maturity in Fixed Deposit Account.");
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Fixed Deposit - Account Number: " + getAccountNumber() + ", Holder: " + getHolderName()
                + ", Balance: " + balance + ", Maturity Amount: " + maturityAmount + ", Duration: " + durationMonths + " months");
    }
}

// Main Class
public class BankingApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create accounts
        SavingsAccount1 savings = new SavingsAccount1("SA001", "Alice", 1000, 4.5);
        CheckingAccount1 checking = new CheckingAccount1("CA001", "Bob", 500, 200);
        FixedDeposit fixedDeposit = new FixedDeposit("FD001", "Charlie", 10000, 12000, 12);

        System.out.println("Select Account Type: 1. Savings  2. Checking  3. Fixed Deposit");
        int choice = scanner.nextInt();
 
        Account selectedAccount = null;
        switch (choice) {
            case 1:
                selectedAccount = savings;
                break;
            case 2:
                selectedAccount = checking;
                break;
            case 3:
                selectedAccount = fixedDeposit;
                break;
            default:
                System.out.println("Invalid choice!");
                System.exit(1);
        }

        // Display account details
        selectedAccount.displayAccountDetails();

        // Perform operations
        System.out.println("Select Operation: 1. Deposit  2. Withdraw  3. Check Balance");
        int operation = scanner.nextInt();

        switch (operation) {
            case 1:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                selectedAccount.deposit(depositAmount);
                break;
            case 2:
                System.out.print("Enter withdrawal amount: ");
                double withdrawalAmount = scanner.nextDouble();
                selectedAccount.withdraw(withdrawalAmount);
                break;
            case 3:
                System.out.println("Current Balance: " + selectedAccount.checkBalance());
                break;
            default:
                System.out.println("Invalid operation!");
        }

        // Loan operations for eligible accounts
        if (selectedAccount instanceof LoanEligible) {
            LoanEligible loanAccount = (LoanEligible) selectedAccount;
            System.out.print("Enter loan amount to apply: ");
            double loanAmount = scanner.nextDouble();
            loanAccount.applyForLoan(loanAmount);
            loanAccount.checkLoanStatus();
        }

        scanner.close();
    }
}
