/*
    Group 2 edu.ucalgary.ensf409.Food Bank
    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
    version: @1.4
    since: @1.0

    This class is responsible for storing the attributes of each food item
    that was read from the inventory.sql file into a Food object
 */

package edu.ucalgary.ensf409;

public class Food {
    private final int ID;
    private final String FOODNAME;
    private final int GRAINCONTENT;
    private final int FVCONTENT;
    private final int PROTEIN;
    private final int OTHER;
    private final int CALORIES;

    /**
     * This is the constructor for the Food object
     * Note: All these values are in percentages
     * @param ID This an int that represents the unique ID of a food item
     * @param foodName This a String for a food item
     * @param grainC This an int representing the grain content
     * @param fvC This is an int representing the fruits & veggie content
     * @param proC This is an int representing the protein content
     * @param other This is an int representing the other content
     * @param calories This is an int representing the calorie content
     */
    public Food(int ID, String foodName, int grainC, int fvC, int proC, int other, int calories) {
        this.ID = ID;
        this.FOODNAME = foodName;
        this.GRAINCONTENT = grainC;
        this.FVCONTENT = fvC;
        this.PROTEIN = proC;
        this.OTHER = other;
        this.CALORIES = calories;
    }

    /**
     * This is a getter that returns an ID for the Food object
     * @return int This returns an int that corresponds to the ID
     */
    public int getID() {
        return this.ID ;
    }

    /**
     * This is a getter that returns the name for a Food object
     * @return String This returns a string that corresponds to the
     * name
     */
    public String getFoodName() {
        return this.FOODNAME;
    }

    /**
     * This is a getter that returns the amount of grain content
     * in a food item in calories
     * @return double This returns a double that corresponds to the
     * grain content
     */
    public double getGrain() {
        return this.GRAINCONTENT / 100.0 * getCalories();
    }

    /**
     * This is a getter that returns the amount of fruits and veggie
     * content in a food item in calories
     * @return double This returns a double that corresponds to the
     * grain content
     */
    public double getFV() {
        return this.FVCONTENT / 100.0 * getCalories();
    }

    /**
     * This is a getter that returns the amount of protein
     * content in a food item in calories
     * @return double This returns a double that corresponds to the
     * protein content
     */
    public double getProtein() {
        return this.PROTEIN / 100.0 * getCalories();
    }

    /**
     * This is a getter that returns the amount of other
     * content in a food item in calories
     * @return double This returns a double that corresponds to the
     * other content
     */
    public double getOther() {
        return this.OTHER / 100.0 * getCalories();
    }

    /**
     * This is a getter that returns the amount of calorie
     * content in a food item in calories
     * @return double This returns a double that corresponds to the
     * calorie content
     */
    public double getCalories() {
        return this.CALORIES;
    }
}
