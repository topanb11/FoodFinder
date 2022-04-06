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
