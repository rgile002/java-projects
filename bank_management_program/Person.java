/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccounts;

/**
 *
 * @author GRK
 */
public class Person {
    private String fName;
    private String lName;
    
    public Person (String f , String l){
        fName=f;
        lName=l;
        
    }
    
    public String getFirstname(){
        return fName;
    }
     public String getLastname(){
         return lName;
     }
}
