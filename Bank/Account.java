
package bankaccounts;

import java.util.Date;

/**
 *
 * @author GRK
 */
public class Account {

    private Person owner;
    private double balance;
    private int acctNumber;
    private String transactions;

    public Account(Person p, int number) {
        owner = p;
        acctNumber = number;
        balance = 0.0;
        transactions = "";
    }

    public Account(Person p, int number, double bal, String tr) {
        owner = p;
        acctNumber = number;
        balance = bal;
        transactions = tr;
    }

    private void addTransaction(double amount) {
        Date dt = new Date();
        transactions = transactions + " " + dt.toString() + " "
                + Double.toString(amount);
    }

    public String getOwnerFirstName() {
        return owner.getFirstname();
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
        addTransaction(amount);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
            addTransaction(-amount);
            return true;
        } else
            return false;
    }

    public int getAcctNumber() {
        return acctNumber;
    }
    public String getTransaction() {
        return acctNumber + " " + owner.getFirstname() + " " + owner.getLastname() + " "
                + transactions;
    }
}
