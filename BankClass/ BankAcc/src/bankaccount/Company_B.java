
package bankaccount;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Company_B extends Bank{
    
    ArrayList<Runnable> users;
    
    public Company_B(int Company_id, int Account_Id, double initialBalance, double current_balance) {
        super(Company_id, Account_Id, initialBalance, current_balance);
        users = new  ArrayList<>(); 
    }
    
    public void add(Runnable r){
        this.users.add(r);
    }

      
}
