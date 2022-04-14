/*
    Group 2 edu.ucalgary.ensf409.Food Bank
    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
    version: @1.3
    since: @1.0
 */

package edu.ucalgary.ensf409;
//TEST TEXT
public class Client {
    private ClientType clientType;
    private int WHOLEGRAINS;
    private int FRUITVEGGIES;
    private int PROTEIN;
    private int OTHER;
    private int CALORIES;

    /**
     *
     * @param type is the clientType of the client object
     */
    public Client(int type){
        if(type == 0){
            this.clientType = ClientType.ADULTMALE;
            this.WHOLEGRAINS = 16;
            this.FRUITVEGGIES = 28;
            this.PROTEIN = 26;
            this.OTHER = 30;
            this.CALORIES = 2500;
        }
        else if(type == 1){
            this.clientType = ClientType.ADULTFEMALE;
            this.WHOLEGRAINS = 16;
            this.FRUITVEGGIES = 28;
            this.PROTEIN = 26;
            this.OTHER = 30;
            this.CALORIES = 2000;
        }
        else if(type == 2){
            this.clientType = ClientType.CHILDOVER8;
            this.WHOLEGRAINS = 21;
            this.FRUITVEGGIES = 33;
            this.PROTEIN = 31;
            this.OTHER = 15;
            this.CALORIES = 2200;
        }
        else if(type == 3){
            this.clientType = ClientType.CHILDUNDER8;
            this.WHOLEGRAINS = 21;
            this.FRUITVEGGIES = 33;
            this.PROTEIN = 31;
            this.OTHER = 15;
            this.CALORIES = 1400;
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
    public int getCalories() {
        return this.CALORIES;
    }
    /**
     * This method is a getter for the Fruit and Veggies value
     * @return String This returns the integer value for Fruit and Veggies percentage
     */
    public int getFV() {
        return this.FRUITVEGGIES;
    }
    /**
     * This method is a getter for the other value
     * @return String This returns the integer value for other percentage
     */
    public int getOther() {
        return this.OTHER;
    }
    /**
     * This method is a getter for the protein value
     * @return String This returns the integer value for protein percentage
     */
    public int getProtein() {
        return this.PROTEIN;
    }
    /**
     * This method is a getter for the grain value
     * @return String This returns the integer value for grain percentage
     */
    public int getGrain(){
        return this.WHOLEGRAINS;
    }
}
