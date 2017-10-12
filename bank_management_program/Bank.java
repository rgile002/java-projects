/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccounts;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author GRK
 */
public class Bank {
    private int lastAcctNumber = 1000;
    private ArrayList<Account> accounts = new ArrayList<Account>();

    private String dataFileName = "data.txt";

    private Scanner kb = new Scanner(System.in);

    private void openAccount() {

        System.out.println("What is your first name?");
        String fName = kb.next();
        System.out.println("What is your last name?");
        String lName = kb.next();

        Person p = new Person(fName, lName);

        Account acct = new Account(p, lastAcctNumber);
        lastAcctNumber = lastAcctNumber + 1;

        accounts.add(acct);

        System.out.println("Acct information :" + acct.getTransaction());

    }

    private void getCommands() {
        System.out.println("in commands");

        System.out.println("Enter the next command");
        String cmd = kb.next();

        while (!cmd.equals("quit")) {
            if (cmd.equals("open"))
                openAccount();
            else {
                System.out.println("What is your account number");
                int acctNumber = kb.nextInt();

                Account acct = findAccount(acctNumber);

                if (acct == null)
                    System.out.println("invalid account number");
                else if (cmd.equals("deposit")) {
                    System.out.println("How much you want to deposit?");
                    double amount = kb.nextDouble();
                    acct.deposit(amount);
                } else if (cmd.equals("withdraw")) {
                    System.out.println("How much you want to withdraw?");
                    double amount = kb.nextDouble();
                    if (!acct.withdraw(amount))
                        System.out.println("Withdraw failed!!");
                } else if (cmd.equals("myBalance"))
                    System.out.println("Your balance is: " + acct.getBalance());
                else
                    System.out.println("invalid command");
            }

            for (int i = 0; i < accounts.size(); i = i + 1)
                System.out.println(accounts.get(i).getTransaction());

            System.out.println("Enter the next command");
            cmd = kb.next();
        }

    }

    private Account findAccount(int acctNumber) {
        for (int i = 0; i < accounts.size(); i = i + 1)
            if (accounts.get(i).getAcctNumber() == acctNumber)
                return accounts.get(i);
        return null;
    }

    public void openBank() throws IOException{

        File dataFile = new File(dataFileName);

        if (dataFile.exists()) {
            Scanner inp = new Scanner(dataFile);
            lastAcctNumber = inp.nextInt();
            
            while (inp.hasNext()) {
                int acctNumber = inp.nextInt();
                double balance = inp.nextDouble();
                System.out.println(acctNumber);
                String fName = inp.next();
                String lName = inp.next();
                
                Person p = new Person(fName, lName);
                
                String transactions = inp.nextLine();
                
                Account acct = new Account(p, acctNumber, balance, transactions);
                
                accounts.add(acct);
            }
        }
        
        
        
        getCommands();
    }

    public void closeBank() throws IOException {
        PrintWriter outFile = new PrintWriter(dataFileName);
        outFile.println(lastAcctNumber);
        for (int i = 0; i < accounts.size(); i = i + 1)
            outFile.println(accounts.get(i).getTransaction());
        outFile.close();

        System.out.println("bye");
    }


}
