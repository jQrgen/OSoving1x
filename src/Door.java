/*
 * To change this template, choose Tools | Templates


/**
 *
 * @author ageward
 */
public class Door implements Runnable{
    
    int counter = 0;
    private ServingArea sa;
    
    public Door(ServingArea sa){
        this.sa = sa;
    }
    
    @Override
    public void run() {
        while(SushiBar.isOpen){
            try{
                (new Thread(new Customer(counter++, sa))).start();
                Thread.sleep(SushiBar.doorWait);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
}
