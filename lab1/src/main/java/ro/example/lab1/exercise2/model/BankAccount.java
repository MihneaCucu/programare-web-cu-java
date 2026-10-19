package ro.example.lab1.exercise2.model;

public class BankAccount {

    private final String accountNumber;
    private final String owner;
    private double balance;

    public BankAccount(String accountNumber, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Owner: " + owner);
        System.out.println("Balance: " + balance);
    }
}
