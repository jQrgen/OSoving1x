/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ageward
 */
public class Customer extends Thread {
    public int id;
    private int nofOrders;
        

    public Customer(int id){
        this.id = id;
        this.nofOrders = (int)(Math.random()*10); 
        SushiBar.write(Thread.currentThread().getName()+": Customer "+customer.id+ 
                    " is now created.");
    }
        
    public void run(){
        SushiBar.write(Thread.currentThread().getName()+": Customer "+customer.id+ 
                    " is eating sushi.");
        try {
            Thread.sleep(nofOrders*SushiBar.customerWait);
        } catch (InterruptedException e){
            e.printStackTrace();
        } 
    }
}
