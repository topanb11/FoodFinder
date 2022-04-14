/*
    Group 2 edu.ucalgary.ensf409.Food Bank
    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
    version: @1.3
    since: @1.0
 */

package edu.ucalgary.ensf409;

public class Client {
    private ClientType clientType;
    private double WHOLEGRAINS;
    private double FRUITVEGGIES;
    private double PROTEIN;
    private double OTHER;
    private double CALORIES;

    /**
     *
     * @param type is an integer representing what enum to use
     */
    public Client(int type){
        if(type == 0){
            this.clientType = ClientType.ADULTMALE;
            this.WHOLEGRAINS = 0.16;
            this.FRUITVEGGIES = 0.28;
            this.PROTEIN = 0.26;
            this.OTHER = 0.30;
            this.CALORIES = 2500;
        }
        else if(type == 1){
            this.clientType = ClientType.ADULTFEMALE;
            this.WHOLEGRAINS = 0.16;
            this.FRUITVEGGIES = 0.28;
            this.PROTEIN = 0.26;
            this.OTHER = 0.30;
            this.CALORIES = 2000;
        }
        else if(type == 2){
            this.clientType = ClientType.CHILDOVER8;
            this.WHOLEGRAINS = 0.21;
            this.FRUITVEGGIES = 0.33;
            this.PROTEIN = 0.31;
            this.OTHER = 0.15;
            this.CALORIES = 2200;
        }
        else if(type == 3){
            this.clientType = ClientType.CHILDUNDER8;
            this.WHOLEGRAINS = 0.21;
            this.FRUITVEGGIES = 0.33;
            this.PROTEIN = 0.31;
            this.OTHER = 0.15;
            this.CALORIES = 1400;
        }
        else{
            throw new IllegalArgumentException();
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
