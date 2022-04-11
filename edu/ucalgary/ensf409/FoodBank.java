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

    public int searchFood(float currMacro, int index){
        float prevDiff = currMacro;
        int ID = 0;
        float foodMacro = 0;
        for(Integer key : foodList.keySet()){
            Food tmpItem = foodList.get(key);
            switch(index){
                case 2:
                    foodMacro = tmpItem.getGrain();
                    break;
                case 3:
                    foodMacro = tmpItem.getFV();
                    break;
                case 4:
                    foodMacro = tmpItem.getProtein();
                    break;
                case 5:
                    foodMacro = tmpItem.getOther();
                    break;
                case 6:
                    foodMacro = tmpItem.getCalories();
                    break;
            }
            float currDiff = Math.abs(currMacro - foodMacro);
            if(currDiff <= prevDiff){
                ID = tmpItem.getID();
                prevDiff = currDiff;
            }
        }
        return ID;
    }

    public void fillFood(float targetMacro, float total, int[] calculated, int index){
        if(targetMacro > total){
            return;
        } else {
            int ID = searchFood(total - targetMacro, index + 2);
            Food tmpFood = getFood(ID);
            foodCart.add(tmpFood.getFoodName());
            foodList.remove(ID);
            calculated[0] += tmpFood.getGrain();
            calculated[1] += tmpFood.getFV();
            calculated[2] += tmpFood.getProtein();
            calculated[3] += tmpFood.getOther();
            calculated[4] += tmpFood.getCalories();
            fillFood(targetMacro + calculated[index], total, calculated, index);
        }
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
        int[] expected = {10332, 17136, 16002, 13230, 56700};
        int[] actual = {0, 0, 0, 0, 0};
        cock.initializeConnection();
        cock.storeFood();
        ArrayList<String> weiner = new ArrayList<>();
        for(int i = 0; i < actual.length; i++){
            cock.fillFood(actual[i], expected[i], actual, i);
        }
    }
}
