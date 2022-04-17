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

    public Order(int ORDERNUMBER) {
        this.ORDERNUMBER = ORDERNUMBER;
    }

    public void addToOrder(Hamper hamper) throws IllegalArgumentException{
        hamperItems.add(hamper);
    }

    public int getOrderNumber() {
        return this.ORDERNUMBER;
    }
    
    // iterate through ArrayList<Food>hamperFood 
    // all food is already formatted 
    public void printOrder() {
        int hamperID = 1;
        try {
            FileWriter writer = new FileWriter("Order" + ORDERNUMBER + ".txt");
            writer.write("Group 2 Food Bank\nHamper Order Form\n\nName: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen\n");
            writer.write("Date: " + LocalDate.now() + "\n\n");
            writer.write("Original Request\n");
            for(Hamper currentHamper: hamperItems) {
                writer.write("Hamper " + hamperID + ": " + currentHamper.getClientList() +"\n");
                hamperID++;
            }
            hamperID = 1;
             for (Hamper currentHamper : hamperItems) {
                 writer.write("Hamper " + hamperID + " Items:\n");
                 currentHamper.calculateNut();
                 currentHamper.fillHamper();
                 writer.write(currentHamper.getFoodList());
                 hamperID++;
             }
            writer.close();
        } catch (IOException e) {}
    }
}
