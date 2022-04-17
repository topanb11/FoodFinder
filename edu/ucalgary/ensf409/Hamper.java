/*
    Group 2 edu.ucalgary.ensf409.Food Bank
    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
    version: @1.4
    since: @1.0
 */

package edu.ucalgary.ensf409;

import java.sql.SQLException;
import java.util.ArrayList;

public class Hamper {
    private ArrayList<Client> clientNumber;
    private static int hamperID;
    private ArrayList<String> hamperFood;
    /**
     * This is the constructor for the hamper
     */
    public Hamper() {
        this.clientNumber = new ArrayList<>();
        hamperFood = new ArrayList<>();
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
            totalNut[0] += ((client.getGrain() * client.getCalories()) * 7);
            totalNut[1] += ((client.getFV() * client.getCalories()) * 7);
            totalNut[2] += ((client.getProtein() * client.getCalories()) * 7);
            totalNut[3] += ((client.getOther() * client.getCalories()) * 7);
            totalNut[4] += (client.getCalories() * 7);
        }
        return totalNut;
    }
    /**
     * This method fills the hamperFood ArrayList based on the calculated nutrients of the hamper
     */
    public void fillHamper(){
        FoodBank bank = null;
        try {
            bank = new FoodBank();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        double[] expected = calculateNut();
        double[] actual = {0, 0, 0, 0, 0};
        for (int i = 0; i < actual.length; i++) {
            this.hamperFood = bank.fillFood(actual[i], expected[i], actual, i);
        }
        for(int i = 0; i < actual.length; i++){
            if(actual[i] < expected[i]){
                if(i == 0){
                    System.out.println("Not enough grains");
                }
                if(i == 1){
                    System.out.println("Not enough fruits and veggies");
                }
                if(i == 2){
                    System.out.println("Not enough protein");
                }
                if(i == 3){
                    System.out.println("Not enough other nutrients");
                }
                if(i == 4){
                    System.out.println("Not enough calories");
                }
            }
        }
    }
    /**
     * This method turns the clientNumber ArrayList into a String with the amount of clients
     * @return String this returns the clients in the ArrayList as a String
     */
    public String getClientList(){
        int adultMaleNum = 0;
        int adultFemaleNum = 0;
        int childOver8Num = 0;
        int childUnder8Num = 0;
        String list = "";
        for(Client client : this.clientNumber){
            if(client.getClientInfo().asString().equals("Adult Male")){
                adultMaleNum++;
            }
            else if(client.getClientInfo().asString().equals("Adult Female")){
                adultFemaleNum++;
            }
            else if(client.getClientInfo().asString().equals("Child Over 8")){
                childOver8Num++;
            }
            else if(client.getClientInfo().asString().equals("Child Under 8")){
                childUnder8Num++;
            }
        }
        if(adultMaleNum > 0){
            list += (adultMaleNum + " Adult Male");
        }
        if(adultFemaleNum > 0){
            list += (", " + adultFemaleNum + " Adult Female");
        }
        if(childOver8Num > 0){
            list += (", " + childOver8Num + " Child Over 8");
        }
        if(childUnder8Num > 0){
            list += (", " + childUnder8Num + " Child Under 8");
        }
        return list;
    }
    /**
     * This method turns the ArrayList hamperFood into a String with each of the foods listed
     * @return String this returns the food in the ArrayList as a String
     */
    public String getFoodList(){
        String list = "";
        for(String food : hamperFood){
            list += (food + "\n");
        }
        return list;
    }
}
