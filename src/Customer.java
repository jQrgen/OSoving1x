
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
    private EatingArea ea;
        

    public Customer(int id, EatingArea ea){
        this.id = id;
        this.nofOrders = (int)(Math.random()*10); 
        this.ea = ea;
        SushiBar.write(Thread.currentThread().getName()+": Customer "+this.id+ 
                    " is now created.");
    }
        
    public void run(){
        SushiBar.write(Thread.currentThread().getName()+": Customer "+this.id+ 
                    " is eating sushi.");
        try {
            Thread.sleep(nofOrders*SushiBar.customerWait);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        ea.customerLeft(this);
    }
}
