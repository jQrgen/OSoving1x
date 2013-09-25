/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ageward
 */
public class Customer extends Thread {
    private SushiBar sushibar;
        private int id;
        
        public Customer(int id, SushiBar sushibar){
            this.id = id;
            this.sushibar = sushibar;
        }
        
        public void run(){
            
        }
}
