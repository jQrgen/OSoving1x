
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ageward
 */
public class Customer implements Runnable {

    private int id;
    private int orders;
    private ServingArea sa;

    public Customer(int id, ServingArea sa) {
        this.id = id;
        this.sa = sa;
        this.orders = (int) (Math.random() * SushiBar.maxOrder);
    }

    @Override
    public void run() {
        SushiBar.write(Thread.currentThread().getName()
                + ":\tCustomer " + this.id + " is now created.");
        if (!sa.isThereAnyFreeSeats()) {
            synchronized (sa) {
                try {
                    SushiBar.write(Thread.currentThread().getName()
                            + ":\tCustomer " + this.id + " is waiting for a free seat.");
                    sa.wait();
                    if (SushiBar.isOpen) {
                        sa.customerEnteringTheServingArea(this);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (SushiBar.isOpen) {
            sa.customerEnteringTheServingArea(this);

            try {
                SushiBar.write(Thread.currentThread().getName()
                        + ":\tCustomer " + this.id + " is eating sushi.");
                Thread.sleep(SushiBar.customerWait * orders);
                SushiBar.write(Thread.currentThread().getName()
                        + ":\tCustomer " + this.id + " is done eating sushi.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sa.customerLeavingTheServingArea(this);
        }
    }

    public int getId() {
        return this.id;
    }
}
