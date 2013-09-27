import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EatingArea {
    private LinkedList seats = new LinkedList();
    private final int capacity = 10;
    private Object lock = new Object();
    private LinkedList<Customer> queue = new LinkedList();
    
    public EatingArea(){
    }
    
    public void addToEatingArea() {
        while(true){
            synchronized(lock){
                while(seats.size() == 10){ 
                    try {
                        lock.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(EatingArea.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            seats.add(queue.removeFirst());
            }
        }
    }
    
    public void customerLeft(Customer customer) {
        synchronized(lock){
                    SushiBar.write(Thread.currentThread().getName()+": Customer "+customer.id+ 
                    " has finished eating.");
            seats.remove(customer);
                if(SushiBar.isOpen){
                    lock.notify();
                }
            }
        
    }
    public void addQueue(int newID){
        queue.add(new Customer(newID,this));
    }
    
    
}