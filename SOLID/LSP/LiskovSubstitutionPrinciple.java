package SOLID.LSP;

import java.util.ArrayList;
import java.util.List;

interface DepositOnlyAccount{
        void deposit(double amount);
}

interface WithdrawableAccount extends DepositOnlyAccount{
    void withdraw(double amount);
}

class SavingAccount implements WithdrawableAccount{
    private double balance;

    public SavingAccount(double initialBalance){
        this.balance = initialBalance;
    }

    public double getBalance(){
        return balance;
    }
    @Override
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposited in Saving Account: " + amount);
            System.out.println("New Balance in Saving Account: "+ balance);
        }
        else{
            System.out.println("Deposit amount must be positive.");
        }
    }

    @Override
    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Withdraw in Saving Account: " + amount);
            System.out.println("New Balance in Saving Account: "+ balance);
        }
        else{
            System.out.println("Invalid withdraw amount.");
        }
    }
}

class CurrentAccount implements WithdrawableAccount {
    private double balance;

    public CurrentAccount(double initialBalance){
        this.balance = initialBalance;
    }

    public double getBalance(){
        return balance;
    }

    @Override
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposited in Current Account: " + amount);
            System.out.println("New Balance in Current Account: "+ balance);
        }
        else{
            System.out.println("Deposit amount must be positive.");
        }
    }

    @Override
    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Withdraw in Current Account: " + amount);
            System.out.println("New Balance in Current Account: "+ balance); 
       }
        else{
            System.out.println("Invalid withdraw amount.");
        }
    }
}

class FixedDepositAccount implements DepositOnlyAccount{
    private double balance;

    public FixedDepositAccount(double initialBalance){
        this.balance = initialBalance;
    }

    public double getBalance(){
        return balance;
    }

    @Override
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposited in Fix Deposit Account: " + amount);
            System.out.println("New Balance in Fix Depost Account: "+ balance);
        }
        else{
            System.out.println("Deposit amount must be positive.");
        }
    }
}

class BankClient{
    private List<DepositOnlyAccount> accounts;
    private List<WithdrawableAccount> withdrawableAccounts;


    public BankClient(List<DepositOnlyAccount> accounts, List<WithdrawableAccount> withdrawableAccounts){
        this.accounts = accounts;
        this.withdrawableAccounts = withdrawableAccounts;
    }

    public void performTransactions(){
        for(DepositOnlyAccount acc: accounts){
            acc.deposit(1000);
        }
        for(WithdrawableAccount acc: withdrawableAccounts){
            acc.deposit(1000);
            acc.withdraw(500);
        }
    }
}

public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) {
        List<DepositOnlyAccount> depositOnlyAccounts = new ArrayList<>();
        depositOnlyAccounts.add(new FixedDepositAccount(0));

        List<WithdrawableAccount> withdrawableAccounts = new ArrayList<>();
        withdrawableAccounts.add(new SavingAccount(5000));
        withdrawableAccounts.add(new CurrentAccount(2000));

        BankClient client = new BankClient(depositOnlyAccounts,withdrawableAccounts);
        client.performTransactions();
    }
}