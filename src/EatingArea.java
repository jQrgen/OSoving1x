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
    Door door;
    private Object lock = new Object();
    
    public EatingArea(Door door){
    this.door = door;
    
    }
    
    public void AddToEatingArea() {
        while(true){
            synchronized(lock){
                while(seats.size() == 10){ 
                    try {
                        lock.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(EatingArea.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            seats.add(door.getCustomerInFrontOfTheLine());
            }
        }
    }
    
    public void costumerLeft(Customer customer) {
        synchronized(lock){
                    SushiBar.write(Thread.currentThread().getName()+": Customer "+customer.id+ 
                    " has finished eating.");
            seats.remove(customer);
            lock.notify();
        }
    }
    
}