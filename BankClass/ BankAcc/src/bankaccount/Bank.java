
package bankaccount;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;


 

public class Bank {

    static private double[] accounts;
    static ReentrantLock rcl = new ReentrantLock();
    static private Condition sufficientFunds;
    int Company_id;
    double Initial_balance;
    double current_balance;
    int Account_Id;
    
    
    public Bank(int Company_id ,int Account_Id ,double initialBalance ,double current_balance) {
        this.Company_id = Company_id;
        this.Account_Id = Account_Id;
        this.Initial_balance = initialBalance;
        this.current_balance = current_balance;
        sufficientFunds = rcl.newCondition();
    }
    
  
      
     public double getBalance()
    {
        return this.current_balance;
    }
    
    public int size()
    {
     return accounts.length;
    }
    
   
    void deposit(int amount){    
       try {
        rcl.lock();
        System.out.println("going to deposit...");    
        this.current_balance+=amount; 
           System.out.println(current_balance);
        System.out.println("deposit completed... "); 
       } catch (Exception e) {
       }finally{
           sufficientFunds.signalAll();
          rcl.unlock();
       }
       
    }
    
    void withdraw(int amount){    
        System.out.println("going to withdraw..."); 
        try{
        rcl.lock();
        while(this.current_balance < amount){
            System.out.println("Less balance; waiting for deposit...");    
           sufficientFunds.await();
        }    
        }catch(Exception e){
        }finally{
          this.current_balance-=amount;
          System.out.println(current_balance);
          System.out.println("withdraw completed...");
          sufficientFunds.signalAll();
          rcl.unlock(); 
          
        }  
        
    }


}
