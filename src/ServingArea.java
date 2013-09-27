
import java.util.LinkedList;

/*
 * To change this template, choose Tools | Templates


import java.util.LinkedList;

/**
 *
 * @author ageward
 */
public class ServingArea {

    LinkedList<Customer> eatingCustomers = new LinkedList<>();
    private int capacity;

    public ServingArea(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void customerEnteringTheServingArea(Customer customer) {
        SushiBar.write(Thread.currentThread().getName()
                + ":\tCustomer " + customer.getId() + " has a seat now.");
        eatingCustomers.add(customer);
    }

    public synchronized void customerLeavingTheServingArea(Customer customer) {
        if (!this.isThereAnyFreeSeats()) {
            SushiBar.write("Now there is a free seat in the shop.");
        }
        eatingCustomers.remove(customer);
        SushiBar.write(Thread.currentThread().getName()
                        + ":\tCustomer " + customer.getId() + " has left the shop.");
        
        if (SushiBar.isOpen) {
            notify();
        }
        else{
            notifyAll();
        }
        if (eatingCustomers.isEmpty() && !SushiBar.isOpen){
            SushiBar.write("***** NO MORE CUSTOMERS - THE SHOP IS CLOSED NOW. *****");
        }
    }

    public synchronized boolean isThereAnyFreeSeats() {
        if (eatingCustomers.size() >= capacity) {
            return false;
        } else {
            return true;
        }
    }
}
