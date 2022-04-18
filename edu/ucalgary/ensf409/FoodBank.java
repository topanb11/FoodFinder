/*
    Group 2 edu.ucalgary.ensf409.Food Bank
    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
    version: @1.9
    since: @1.0

    This class is responsible for connecting to the database as well as maintaining the
    items used in it
 */

package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class FoodBank extends SQL {
    private HashMap<Integer, Food> foodList = new HashMap<Integer, Food>();
    private ArrayList<String> foodCart = new ArrayList<String>();

    /**
     * This is the constructor for the FoodBank object
     */
    public FoodBank() throws SQLException{
        initializeConnection();
        storeFood();
    }

    /**
     * This is a getter that retrieves the food item from the foodList
     * hashmap, using the ID which corresponds to the key in foodList
     * @param ID This is a unique int that corresponds to a specific food object
     * @return Food This returns a Food object with the matching ID
     */
    public Food getFood(int ID){
        return this.foodList.get(ID);
    }

    /**
     * This method is responsible for searching for a Food object that has
     * macro-nutrients that are closest to the targetMacro
     * @param targetMacro This is a double that represents the macro-nutrient we
     *                    are searching for
     * @param index This is an int corresponding to each food grouping, i.e 0 is grain and 1
     *              would be fruits & veggies
     * @return int This returns an int that corresponds to the unique ID for a Food object
     */
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
            double currDiff = targetMacro - foodMacro;
            if(currDiff < prevDiff && currDiff > 0){
                prevDiff = currDiff;
                ID = tmpItem.getID();
            }
        }
        return ID;
    }

    /**
     * This method is a recursive function that is used to fill the foodCart ArrayList
     * with Food objects that best suit the user's nutritional needs
     * @param currMacro This is a double that represents the value of the
     *                  macro-nutrient that is being filled
     * @param targetMacro This is a double that represents the total value
     *                    of the specific macro-nutrient that is being filled
     * @param calculated This is a double array that contains all the calculated
     *                   value when searching for the most suitable Food items
     * @param index This is an int that corresponds to a specific food grouping
     *              i.e) 0 is for grain and 1 is for fruits & veggies
     * @return ArrayList<String> This returns an ArrayList of all the found food items
     */
    public ArrayList<String> fillFood(double currMacro, double targetMacro, double[] calculated, int index){
        if(currMacro > targetMacro){
            return foodCart;
        } else {
            int ID = 0;
            if(Math.abs(targetMacro - currMacro) >= 50) {
                ID = searchFood(targetMacro - currMacro, index);
            } else {
                ID = searchFood((targetMacro - currMacro) + 50, index);
            }
            Food tmpFood = getFood(ID);
            String line = String.format("%s\t\t%s", tmpFood.getID(), tmpFood.getFoodName());
            deleteFromDB(tmpFood.getFoodName());
            foodCart.add(line);
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

    /**
     * This method is responsible for reading the Food items from the inventory.sql
     * database and storing all the items locally. This also assigns each Food item
     * a unique ID
     */
    public void storeFood() {
        int i = 1;
        try {
            Statement myStmt = getDbConnect().createStatement();
            ResultSet foodInfo = myStmt.executeQuery("SELECT * FROM AVAILABLE_FOOD");
            while (foodInfo.next()) {
                Food tmp = new Food(i, foodInfo.getString("Name"), foodInfo.getInt("GrainContent"),
                        foodInfo.getInt("FVContent"), foodInfo.getInt("ProContent"),
                        foodInfo.getInt("Other"), foodInfo.getInt("Calories"));
                foodList.put(i, tmp);
                i++;
            }
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is responsible for deleting the items from the database
     * once they have been fetched
     * @param key This parameter is the String which specifies the name of the
     *            Food item that needs to be deleted
     */
    public void deleteFromDB(String key) {
        try {
            String query = "DELETE FROM AVAILABLE_FOOD WHERE Name= ? LIMIT 1";
            PreparedStatement preparedStmt = getDbConnect().prepareStatement(query);
            preparedStmt.setString(1, key);
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}