/*
    Group 2 edu.ucalgary.ensf409.Food Bank
    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
    version: @1.3
    since: @1.0
 */

package edu.ucalgary.ensf409;

public class Food {
    private final int id;
    private final String foodName;
    private final int grainContent;
    private final int fvContent;
    private final int proContent;
    private final int other;
    private final int calories;

    public Food(int id, String foodName, int grainC, int fvC, int proC, int other, int calories) {
        this.id = id;
        this.foodName = foodName;
        this.grainContent = grainC;
        this.fvContent = fvC;
        this.proContent = proC;
        this.other = other;
        this.calories = calories;
    }
}
