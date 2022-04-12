/*
    Group 2 edu.ucalgary.ensf409.Food Bank
    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
    version: @1.5
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
    private ArrayList<String> foodCart = new ArrayList<String>();

    public FoodBank(String url, String user, String pw) {
        this.DBURL = url;
        this.USERNAME = user;
        this.PASSWORD = pw;
    }

    public String getDburl() {return this.DBURL;}
    public String getUsername() {return this.USERNAME;}
    public String getPassword() {return this.PASSWORD;}


    public Food getFood(int ID){
        return this.foodList.get(ID);
    }

    public int searchFood(double targetMacro, int index){
        double prevDiff = targetMacro;
        double foodMacro = 0;
        int ID = 0;
        for(Integer key : foodList.keySet()){
            Food tmpItem = foodList.get(key);
            switch(index){
                case 0:
                    foodMacro = tmpItem.getGrain();
                    break;
                case 1:
                    foodMacro = tmpItem.getFV();
                    break;
                case 2:
                    foodMacro = tmpItem.getProtein();
                    break;
                case 3:
                    foodMacro = tmpItem.getOther();
                    break;
                case 4:
                    foodMacro = tmpItem.getCalories();
                    break;
            }
            double currDiff = Math.abs(targetMacro - foodMacro);
            if(currDiff < prevDiff + 100){
                prevDiff = currDiff;
                ID = tmpItem.getID();
            }
        }
        return ID;
    }

    public ArrayList<String> fillFood(double currMacro, double targetMacro, double[] calculated, int index){
        if(currMacro > targetMacro){
            return foodCart;
        } else {
            int ID = searchFood(targetMacro - currMacro, index);
            Food tmpFood = getFood(ID);
            foodCart.add(tmpFood.getFoodName());
            foodList.remove(ID);
            calculated[0] += tmpFood.getGrain();
            calculated[1] += tmpFood.getFV();
            calculated[2] += tmpFood.getProtein();
            calculated[3] += tmpFood.getOther();
            calculated[4] += tmpFood.getCalories();
            fillFood(calculated[index], targetMacro, calculated, index);
        }
        return foodCart;
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
        double[] expected = {10332, 17136, 12772, 13230, 56700};
        double[] actual = {0, 0, 0, 0, 0};
        cock.initializeConnection();
        cock.storeFood();
        ArrayList<String> weiner = new ArrayList<>();
        for(int i = 0; i < actual.length; i++){
            weiner = cock.fillFood(actual[i], expected[i], actual, i);
        }
    }
}
