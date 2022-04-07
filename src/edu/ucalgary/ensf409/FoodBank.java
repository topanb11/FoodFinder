package edu.ucalgary.ensf409;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class FoodBank {
    private final String DBURL;
    private final String USERNAME;
    private final String PASSWORD;
    private Connection dbConnect;
    private ArrayList<Food> foodList = new ArrayList<>();

    public FoodBank(String url, String user, String pw) {
        this.DBURL = url;
        this.USERNAME = user;
        this.PASSWORD = pw;
    }

    public Food getFood(int ID){
        return null;
    }

    public int searchFood(int wG, int fV, int pro, int other, int calories) {
        return 0;
    }

    public void initializeConnection() {
        try{
            dbConnect = DriverManager.getConnection(getDburl(), getUsername(), getPassword());
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public String getDburl() {return this.DBURL;}
    public String getUsername() {return this.USERNAME;}
    public String getPassword() {return this.PASSWORD;}
}
