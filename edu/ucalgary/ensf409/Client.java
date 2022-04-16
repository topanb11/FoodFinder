/*
    Group 2 edu.ucalgary.ensf409.Food Bank
    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
    version: @1.3
    since: @1.0
 */

package edu.ucalgary.ensf409;

import java.sql.*;
public class Client extends SQL{
    private ClientType clientType;
    private double WHOLEGRAINS;
    private double FRUITVEGGIES;
    private double PROTEIN;
    private double OTHER;
    private double CALORIES;

    /**
     *Constructor for Client object
     * @param type is an integer representing what enum to use
     */
    public Client(int type){
        try {
            Statement myStmt = getDbConnect().createStatement();
            ResultSet clientInfo = myStmt.executeQuery("SELECT * FROM DAILY_CLIENT_NEEDS");
            if (type == 0) {
                this.clientType = ClientType.ADULTMALE;
                while(clientInfo.next()){
                    if(clientInfo.getString("Client").equals("Adult Male")){
                        this.WHOLEGRAINS = (double)clientInfo.getInt("WholeGrains")/100;
                        this.FRUITVEGGIES = (double)clientInfo.getInt("FruitsVeggies")/100;
                        this.PROTEIN = (double)clientInfo.getInt("Protein")/100;
                        this.OTHER = (double)clientInfo.getInt("Other")/100;
                        this.CALORIES = clientInfo.getInt("Calories");
                        break;
                    }
                }
            } else if (type == 1) {
                this.clientType = ClientType.ADULTFEMALE;
                while(clientInfo.next()){
                    if(clientInfo.getString("Client").equals("Adult Female")){
                        this.WHOLEGRAINS = (double)clientInfo.getInt("WholeGrains")/100;
                        this.FRUITVEGGIES = (double)clientInfo.getInt("FruitsVeggies")/100;
                        this.PROTEIN = (double)clientInfo.getInt("Protein")/100;
                        this.OTHER = (double)clientInfo.getInt("Other")/100;
                        this.CALORIES = clientInfo.getInt("Calories");
                        break;
                    }
                }
            } else if (type == 2) {
                this.clientType = ClientType.CHILDOVER8;
                while(clientInfo.next()){
                    if(clientInfo.getString("Client").equals("Child over 8")){
                        this.WHOLEGRAINS = (double)clientInfo.getInt("WholeGrains")/100;
                        this.FRUITVEGGIES = (double)clientInfo.getInt("FruitsVeggies")/100;
                        this.PROTEIN = (double)clientInfo.getInt("Protein")/100;
                        this.OTHER = (double)clientInfo.getInt("Other")/100;
                        this.CALORIES = clientInfo.getInt("Calories");
                        break;
                    }
                }
            } else if (type == 3) {
                this.clientType = ClientType.CHILDUNDER8;
                while(clientInfo.next()){
                    if(clientInfo.getString("Client").equals("Child under 8")){
                        this.WHOLEGRAINS = (double)clientInfo.getInt("WholeGrains")/100;
                        this.FRUITVEGGIES = (double)clientInfo.getInt("FruitsVeggies")/100;
                        this.PROTEIN = (double)clientInfo.getInt("Protein")/100;
                        this.OTHER = (double)clientInfo.getInt("Other")/100;
                        this.CALORIES = clientInfo.getInt("Calories");
                        break;
                    }
                }
            } else {
                throw new IllegalArgumentException();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    /**
     * This method is a getter for the client type
     * @return String This returns the client type of object
     */
    public ClientType getClientInfo(){
        return this.clientType;
    }
    /**
     * This method is a getter for the calories value
     * @return String This returns the integer value for calorie percentage
     */
    public double getCalories() {
        return this.CALORIES;
    }
    /**
     * This method is a getter for the Fruit and Veggies value
     * @return String This returns the integer value for Fruit and Veggies percentage
     */
    public double getFV() {
        return this.FRUITVEGGIES;
    }
    /**
     * This method is a getter for the other value
     * @return String This returns the integer value for other percentage
     */
    public double getOther() {
        return this.OTHER;
    }
    /**
     * This method is a getter for the protein value
     * @return String This returns the integer value for protein percentage
     */
    public double getProtein() {
        return this.PROTEIN;
    }
    /**
     * This method is a getter for the grain value
     * @return String This returns the integer value for grain percentage
     */
    public double getGrain(){
        return this.WHOLEGRAINS;
    }
}
