
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorgen
 */
public class Door extends Thread {

    public int newID;
    Timer timer;
    private EatingArea ea;

    public Door(EatingArea ea) {
        newID = 0;
        this.ea = ea;
        run();
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Door.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!SushiBar.isOpen) {
                System.out.println("Shop is closed");
                break;
            }
            ea.addQueue(newID);
            newID++;
        }
    }
}
