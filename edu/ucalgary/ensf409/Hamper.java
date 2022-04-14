/*
    Group 2 edu.ucalgary.ensf409.Food Bank
    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
    version: @1.3
    since: @1.0
 */

package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class Hamper {
    private ArrayList<Client> clientNumber;
    private static int hamperID;
    private ArrayList<String> hamperFood;
    /**
     * This is the constructor for the hamper
     */
    public Hamper(){
        this.clientNumber = new ArrayList<>();
        this.hamperFood = new ArrayList<>();
    }
    /**
     * This method adds a client to the ArrayList clientNumber
     * @param clientType is the integer corresponding to one of the 4 types of clients
     */
    public void addClient(int clientType){
        Client client = new Client(clientType);
        this.clientNumber.add(client);
    }
    /**
     * This method removes a client from a given index and throws an IllegalArgumentException when the index is
     * greater than or equal to the size of the ArrayList
     * @param clientID the index from which a client is removed from the ArrayList
     */
    public void removeClient(int clientID){
        if(clientID >= this.clientNumber.size()){
            throw new IllegalArgumentException("Index not in the ArrayList");
        }
        this.clientNumber.remove(clientID);
    }
    /**
     * This method gets the ArrayList of clients
     * @return ArrayList<Client> this returns the ArrayList clientNumber;
     */
    public ArrayList<Client> getClient(){
        return this.clientNumber;
    }
    /**
     * This method calculates the total number of nutrients needed for the hamper
     * @return int[] this returns an integer array with each index corresponding to a nutrient
     */
    public double[] calculateNut(){
        double[] totalNut = new double[5];
        for(Client client : clientNumber){
            totalNut[0] += (client.getGrain() * client.getCalories());
            totalNut[1] += (client.getFV() * client.getCalories());
            totalNut[2] += (client.getProtein() * client.getCalories());
            totalNut[3] += (client.getOther() * client.getCalories());
            totalNut[4] += client.getCalories();
        }
        return totalNut;
    }
    fillHamper(){

    }
}
