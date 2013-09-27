import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorgen
 */
public class Door {
    public int newID;
    LinkedList<Customer> queue = new LinkedList();
    public static boolean open = true;
    Timer timer;
    private EatingArea ea;
    
    public Door(EatingArea ea){
        newID = 0;
        this.ea = ea;
        timer = new Timer();
        timer.schedule(new newCustomer(),SushiBar.doorWait);
    }
    
    class newCustomer extends TimerTask {
           public void run() {
               if(!open){
                   System.out.println("Shop is closed");
                   timer.cancel();
               }else{ 
               ea.addQueue(newID);
               newID++;
               timer.schedule(new newCustomer(),SushiBar.doorWait);  
               }
           }
    
    }
}
