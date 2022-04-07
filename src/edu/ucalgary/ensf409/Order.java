/*
    Group 2 edu.ucalgary.ensf409.Food Bank
    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
    version: @1.3
    since: @1.0
 */

package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class Order {
    private final int ORDERNUMBER;
    private ArrayList<Hamper> hamperItems;

    public Order() {
        this.ORDERNUMBER = 69;
    }

    public void addToOrder(Hamper hamper) throws IllegalArgumentException{
    }

    public String printOrder() {}
}
