/*
    Group 2 edu.ucalgary.ensf409.Food Bank
    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
    version: @1.3
    since: @1.0
 */

package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class FoodBank {
    private final String DBURL;
    private final String USERNAME;
    private final String PASSWORD;
    private Connection dbConnect;
    private HashMap<Integer, Food> foodList = new HashMap<Integer, Food>();
    private ArrayList<String> trashList = new ArrayList<String>();

    public FoodBank(String url, String user, String pw) {
        this.DBURL = url;
        this.USERNAME = user;
        this.PASSWORD = pw;
    }

    public String getDburl() {return this.DBURL;}
    public String getUsername() {return this.USERNAME;}
    public String getPassword() {return this.PASSWORD;}

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

    public void storeFood(){
        int i = 0;
        try{
            Statement myStmt = dbConnect.createStatement();
            ResultSet foodInfo = myStmt.executeQuery("SELECT * FROM AVAILABLE_FOOD");
            while(foodInfo.next()){
                Food tmp = new Food(i, foodInfo.getString("Name"), foodInfo.getInt("GrainContent"),
                        foodInfo.getInt("FVContent"), foodInfo.getInt("ProContent"),
                        foodInfo.getInt("Other"), foodInfo.getInt("Calories"));
                foodList.put(i, tmp);
                i++;
            }
            myStmt.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FoodBank cock = new FoodBank("jdbc:mysql://localhost/FOOD_INVENTORY", "root", "topanb11");
        cock.initializeConnection();
        cock.storeFood();
        }
    }
