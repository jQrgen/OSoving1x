/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package asd;

/**
 *
 * @author ageward
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;


public class Clock{
	Timer timer;
	
	public Clock(int seconds){
		timer = new Timer();  //At this line a new Thread will be created
		timer.schedule(new RemindTask(), seconds*1000); //delay in milliseconds
	}
	
	 class RemindTask extends TimerTask {
	        public void run() {
	            SushiBar.isOpen= false; //prevents creating new customers.
	            timer.cancel();
	        }
	 }
	 
	 public static String getTime(){
		// get current time
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(cal.getTime()) ;
	}
}