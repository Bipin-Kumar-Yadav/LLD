package SOLID.LSPRule.PropertiesRule.HistoryConstraint;
// Subclass methods should not be allowed state changes that
// the base class never allowed.

class BankAccount{
    protected double balance;

    public BankAccount(double initialBalance){
        if(initialBalance < 0){
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.balance = initialBalance;
    }

    // History Constraint: withdraw should be allowed
    public void withdraw(double amount) {
        if (balance - amount < 0) throw new RuntimeException("Insufficient funds");
        balance -= amount;
        System.out.println("Amount withdrawn. Remaining balance is " + balance);
    }
}

class FixDepositAccount extends BankAccount{
    public FixDepositAccount(double initialBalance){
        super(initialBalance);
    }

    // This method violates the history constraint of the base class
    @Override
    public void withdraw(double amount){
        throw new RuntimeException("Withdraw not allowed in Fixed Deposit");
    }
}
public class HistoryConstraint {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100);
        account.withdraw(50);

        FixDepositAccount fixAccount = new FixDepositAccount(100);
        fixAccount.withdraw(50); // This violates the history constraint of BankAccount
    }
}
