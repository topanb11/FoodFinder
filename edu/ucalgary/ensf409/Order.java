/*
    Group 2 edu.ucalgary.ensf409.Food Bank
    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
    version: @1.3
    since: @1.0
 */

package edu.ucalgary.ensf409;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private final int ORDERNUMBER;
    private ArrayList<Hamper> hamperItems = new ArrayList<Hamper>();

    public Order() {
        this.ORDERNUMBER = 69;
    }

    public void addToOrder(Hamper hamper) throws IllegalArgumentException{
        hamperItems.add(hamper);
    }
    
    // iterate through ArrayList<Food>hamperFood 
    // all food is already formatted 
    public void printOrder() {
        try {
            FileWriter writer = new FileWriter("Order.txt");
            writer.write("Group 2 Food Bank\nHamper Order Form\n\nName: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen\n");
            writer.write("Date: " + LocalDate.now() + "\n\n");
            writer.write("Original Request\n");
            // for (Hamper currentHamper : hamperItems) {
            //     writer.write("Hamper " + currentHamper. + "Items:\n");
            //     writer.write(hamperItems);
            // }
            writer.close();
        } catch (IOException e) {}
    }
}
