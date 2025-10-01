package SOLID.LSPRule.PropertiesRule.ClassInvariant;
// Class Invariant of a parent class Object should not be broken by child class Object.
// Hence child class can either maintain or strengthen the invariant but never narrows it down.

// Invariant: Balance cannot be negative

class BankAccount{
    protected double balance;
    public BankAccount(double initialBalance){
        if(initialBalance < 0){
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.balance = initialBalance;
    }
    public void withdraw(double amount){
        if(amount > balance){
            throw new IllegalArgumentException("Insufficient funds.");
        }
        balance -= amount;
        System.out.println("Amount withdrawn. Remaining balance is " + balance);
    }
}

class CheatAccount extends BankAccount{
    public CheatAccount(double initialBalance){
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount){
        balance -= amount; // This can lead to negative balance, violating the invariant
        System.out.println("Amount withdrawn. Remaining balance is " + balance);
    }
}
public class ClassInvariant {
    public static void main(String[] args){
        BankAccount account = new BankAccount(100);
        account.withdraw(50);

        CheatAccount cheatAccount = new CheatAccount(100);
        cheatAccount.withdraw(150); // This breaks the invariant of BankAccount
    }
}
