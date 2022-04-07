package edu.ucalgary.ensf409;

public class Food {
    private final int ID;
    private final String FOODNAME;
    private final int GRAINCONTENT;
    private final int FVCONTENT;
    private final int PROCONTENT;
    private final int OTHER;
    private final int CALORIES;

    public Food(int ID, String foodName, int grainC, int fvC, int proC, int other, int calories) {
        this.ID = ID;
        this.FOODNAME = foodName;
        this.GRAINCONTENT = grainC;
        this.FVCONTENT = fvC;
        this.PROCONTENT = proC;
        this.OTHER = other;
        this.CALORIES = calories;
    }
}
