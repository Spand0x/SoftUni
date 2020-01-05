package com.spand0x;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    String[] input = scanner.nextLine().split(" ");
        HashMap<Integer,BankAccount> bankAccounts = new HashMap<>();
	    while (!"end".equalsIgnoreCase(input[0])){
            String command = input[0];

            switch (command){
                case "Create":
                    BankAccount account = new BankAccount();
                    bankAccounts.put(BankAccount.getId()-1,account);
                    System.out.println("Account ID" + (BankAccount.getId()-1) + " created");
                    break;
                case "Deposit":
                    int id = Integer.parseInt(input[1]);
                    double amount = Double.parseDouble(input[2]);
                    if(bankAccounts.containsKey(id)) {
                        bankAccounts.get(id).deposit(amount);
                        System.out.printf("Deposited %.0f to ID%d%n", amount, id);
                    }else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(input[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    id = Integer.parseInt(input[1]);
                    double years = Double.parseDouble(input[2]);
                    if(bankAccounts.containsKey(id)) {
                        System.out.printf("%.2f%n",bankAccounts.get(id).getInterestRate(years));
                    }else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }


	        input = scanner.nextLine().split(" ");
        }
    }
}

