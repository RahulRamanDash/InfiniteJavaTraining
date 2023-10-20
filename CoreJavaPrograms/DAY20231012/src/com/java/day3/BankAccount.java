package com.java.day3;

public class BankAccount {
    private double balance; // Private attribute to encapsulate the account balance

    // Constructor to initialize the balance
    public BankAccount(double initialBalance) {
        balance = initialBalance; // Sets the initial balance
    }

    // Method to deposit funds into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount; // Increases the deposited amount
            System.out.println("Deposited: $" + amount); // Prints a deposit message
        } else {
            System.out.println("Invalid deposit amount."); // Prints an error message for invalid deposits
        }
    }

    // Method to withdraw funds from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount; // Decreases the withdrawn amount
            System.out.println("Withdrawn: $" + amount); // Prints a withdrawal message
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance."); // Prints an error message for invalid withdrawals or insufficient balance
        }
    }

    // Method to check and return the account balance
    public double getBalance() {
        return balance; // Returns the account balance
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0); // Initial balance is $1000

        System.out.println("Initial Balance: $" + account.getBalance()); // Prints the initial balance
        account.deposit(500.0); // Deposits funds into the account
        System.out.println("Current Balance: $" + account.getBalance()); // Prints the current balance
        account.withdraw(300.0); // Withdraws funds from the account
        System.out.println("Current Balance: $" + account.getBalance()); // Prints the current balance
    }
}

