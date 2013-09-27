/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.

/**
 *
 * @author ageward
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class SushiBar {
	//SushiBar settings:
    	//These parameters have to be changed to check that the program works in all situations.
	private static int capacity =10; //capacity of Sushi Bar
	private static int duration = 3; // Simulation time
	public static int maxOrder = 10; // Maximum number of orders for each customer
	public static int customerWait= 500; // coefficient of eating time for customers
	public static int doorWait = 100; // coefficient of waiting time for door for creating next customer


	public static boolean isOpen=true;

	//Creating the log file
	private static File log;
	private static String path = "./";
        
	public static void main(String[] args) {

		log= new File(path + "log.txt"); 

		
		ServingArea sa = new ServingArea(capacity);
                Thread door = new Thread(new Door(sa));
                Clock clock = new Clock(duration);
                door.start();
	}

        

	//Writes actions in the log file and console
	public static void write(String str){
		try {
			FileWriter fw = new FileWriter(log.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(Clock.getTime() + ", " + str +"\n");
			bw.close();
			System.out.println(Clock.getTime() + ", " + str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
