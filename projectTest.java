/*
    Group 2 Food Bank
    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
    version: @1.3
    since: @1.0
 */

package edu.ucalgary.ensf409;

import java.util.*;
import java.beans.Transient;
import org.junit.*;
import static org.junit.Assert.*;

public class projectTest {

    public projectTest(){

    }
    @Test
    public void testOrderConstructor() {
        Order testOrder = new Order();
        assertNotNull("The order constructor did not create an object: ", order1);
    }

    @Test
    public void testHamperConstructor(){
        Hamper testHamper = new Hamper();
        assertNotNull("The hamper constructor did not create an object: ", testHamper);
    }

    @Test
    public void testHamperAddClientToHamperGoodData(){
        Hamper testHamper = new Hamper();
        Client testClient = new Client(1);
        testHamper.addClientToHamper(testClient.getClientInfo());
        ArrayList<Client> expectedList = new ArrayList<Client>();
        expectedList.add(testClient);
        foundList = testHamper.getClientList();
        assertEquals("Method addClientToHamper did not return the expected result: ", expectedList, foundList);
    }

    @Test
    public void testHamperAddClientToHamperInvalid() {
    
    }

    @Test
    public void testFoodBankConstructor() {
        FoodBank testBank = new FoodBank();
        assertNotNull("FoodBank constructor did not return the expected result: ", testBank);
    }

    @Test public void testFoodConstructor() {
        Food testFood = new Food();
        assertNotNull("Food constructor did not return the expected result: ", testFood);
    }

    // searchFood(int wholeGrain, int fV, int protein, int other, int calories) should
    // access the database and search for a food item with the given macronutrients
    // and will return the name of the food item if it exists. Otherwise false
    @Test
    public void testSearchFood() {
        FoodBank testBank = new FoodBank();
        int WG = 12;
        int fV = 15;
        int protein = 20;
        int other = 7;
        int calories = 700;

        int foundID = foodDataBase.searchFood(WG, fV, protein, other, calories);
        int expectedID = 69;
        assertEquals("Method searchFood did not return the expected result: ", expectedID, foundID);
    }

    @Test
    public void testFoodBankGetFood() {
        FoodBank testBank = new FoodBank();
        Food foundFood = testBank.getFood(69);

        int ID = 69;
        int WG = 12;
        int fV = 15;
        int protein = 20;
        int other = 7;
        int calories = 700;
        Food expectedFood = new Food(ID, WG, fV, protein, other, calories);

        assertEquals("Method getFood did not return the expected result: ", expectedFood, foundFood);
    }

    @Test
    public void testHamperAddFood() {
        testHamper.addFood(testFood);
        assertEquals("Method addFood did not return the expected result: ", expectedFood, foundFood);
    }

    @Test
    public void testAddToOrder() {
        Hamper testHamper = new Hamper();
        Order testOrder = new Order();
        testOrder.addToOrder(testHamper);
        String foundOrder = testOrder.printOrder();
        String expectedOrder = "some order w hamper items";

        assertEquals("method addToOrder did not return the expected result: ",expectedOrder, foundOrder);
    }
    @Test
    public void testPrintOrder() {
        Hamper testHamper = new Hamper();
        Order testOrder = new Order();
        String foundOrder = order.printOrder();
        String expectedOrder = "some order";

        assertEquals("method printOrder did not return the expected result: ",expectedOrder, foundOrder);
    }

    @Test
    public void testHamperAddClientToHamperInvalid {}


}