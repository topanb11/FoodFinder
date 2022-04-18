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
    private final int ORDERNUMBER = 0;
    private ArrayList<Hamper> hamperItems = new ArrayList<Hamper>();

    /**
     * Constructor for order class
     */
    public Order() {}

    /**
     * This method is responsible for adding a hamper object to the ArrayList
     * of hampers
     * @param hamper This is the hamper object that is being added to the ArrayList
     * @throws IllegalArgumentException This exception is thrown if an illegal argument
     * is provided
     */
    public void addToOrder(Hamper hamper) throws IllegalArgumentException{
        hamperItems.add(hamper);
    }

    /**
     * This method is a getter that returns the order number
     * @return int This is the int that corresponds to the order number
     */
    public int getOrderNumber() {
        return this.ORDERNUMBER;
    }

    /**
     * This method is a getter that retrieves the ArrayList of hampers
     * @return ArrayList<Hamper> This is an ArrayList of all the hampers
     * in the order
     */
    public ArrayList<Hamper> getHamperItems() {
        return this.hamperItems;
    }

    /**
     * This method is responsible for writing the order into the txt file
     */
    public void printOrder() {
        int hamperID = 1;
        try {
            FileWriter writer = new FileWriter("Order" + GUI.getClick() + ".txt");
            writer.write("Group 2 Food Bank\nHamper Order Form\n\nName: \n");
            writer.write("Date: \n\n");
            writer.write("Original Request\n");
            for(Hamper currentHamper : hamperItems) {
                writer.write("Hamper " + hamperID + ": " + currentHamper.getClientList() +"\n");
                hamperID++;
            }
            hamperID = 1;
             for (Hamper currentHamper : hamperItems) {
                 writer.write("\nHamper " + hamperID + " Items:\n");
                 currentHamper.calculateNut();
                 currentHamper.fillHamper();
                 writer.write(currentHamper.getFoodList());
                 hamperID++;
             }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
