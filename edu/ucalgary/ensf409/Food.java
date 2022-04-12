/*
    Group 2 edu.ucalgary.ensf409.Food Bank
    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
    version: @1.3
    since: @1.0
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

    public Food(int ID, String foodName, int grainC, int fvC, int proC, int other, int calories) {
        this.ID = ID;
        this.FOODNAME = foodName;
        this.GRAINCONTENT = grainC;
        this.FVCONTENT = fvC;
        this.PROTEIN = proC;
        this.OTHER = other;
        this.CALORIES = calories;
    }

    public int getID() {
        return this.ID ;
    }

    public String getFoodName() {
        return this.FOODNAME;
    }

    public double getGrain() {
        return this.GRAINCONTENT / 100.0 * getCalories();
    }

    public double getFV() {
        return this.FVCONTENT / 100.0 * getCalories();
    }

    public double getProtein() {
        return this.PROTEIN / 100.0 * getCalories();
    }

    public double getOther() {
        return this.OTHER / 100.0 * getCalories();
    }

    public double getCalories() {
        return this.CALORIES;
    }
}
