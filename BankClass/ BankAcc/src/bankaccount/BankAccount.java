
package bankaccount;


public class BankAccount {

    
    public static void main(String[] args) {
        
       Company_A a = new Company_A(1,1, 50000, 50000);
       Company_B b = new Company_B(2,2, 50000, 50000);
       Company_C c = new Company_C(3,3, 50000, 50000);
       
       Runnable a_r1 = new Runnable() {
           @Override
           public void run() {
               a.deposit(5000);
           }
       };
       
       Runnable a_r2 = new Runnable() {
           @Override
           public void run() {
               a.withdraw(5000);
           }
       };
       
        Runnable a_r3 = new Runnable() {
           @Override
           public void run() {
               a.deposit(5000);
           }
       };
        
       a.add(a_r1);
       a.add(a_r2);
       a.add(a_r3);
       Thread t1 = new Thread(a_r1);
       t1.start();
       Thread t2 = new Thread(a_r2);
       t2.start();
       Thread t3 = new Thread(a_r3);
       t3.start();
    
}
    
}
