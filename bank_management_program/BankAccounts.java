/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccounts;

import java.io.IOException;

/**
 *
 * @author GRK
 */
public class BankAccounts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
       Bank bank = new Bank();
        
        bank.openBank();
        
         bank.closeBank();
    }
    
}
