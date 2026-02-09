package coe318.lab4;


public class Account {
    private String name;    
    private int number;     
    private double balance; 


    public Account(String name, int number, double initialBalance) {
        this.name = name;
        this.number = number;
        this.balance = initialBalance;
    }


    public String getName() {
        return name;
    }


    public double getBalance() {
        return balance;
    }


    public int getNumber() {
        return number;
    }


    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }


    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }


    @Override
    public String toString() { // DO NOT MODIFY
        return "(" + getName() + ", " + getNumber() + ", " +
                String.format("$%.2f", getBalance()) + ")";
    }
}
