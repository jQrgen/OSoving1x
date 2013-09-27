import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EatingArea {
    public LinkedList seats = new LinkedList();
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
            SushiBar.write(Thread.currentThread().getName()+": Customer "+queue.getFirst().id+ 
                    " has a seat now.");
            seats.add(queue.removeFirst());
            }
        }
    }
    
    public void customerLeft(Customer customer) {
        synchronized(lock){
                SushiBar.write(Thread.currentThread().getName()+": Customer "+customer.id+ 
                    " has left the shop.");
                if (seats.size() == 10){
                    SushiBar.write("Now there is a free seat in the shop.");
                }
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