package com.spand0x;

public class BankAccount {
    private static int id = 1;
    private double balance;
    private static double interestRate = 0.02;

    public BankAccount(){
        id++;
        this.balance = 0;
    }

    public static int getId() {
        return id;
    }

    public void deposit(double amount){
        this.balance = amount;
    }

    public double getInterestRate(double years) {
        return BankAccount.interestRate * years * this.balance;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }
}
