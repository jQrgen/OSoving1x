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
    }
        
    public void run(){
        for ( int i = 0 ; i < nofOrders; i++){
                
        }
        
    }
}
