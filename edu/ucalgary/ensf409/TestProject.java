package edu.ucalgary.ensf409;

/*
    Group 2 edu.ucalgary.ensf409.Food Bank
    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
    version: @1.5
    since: @1.0
 */

import java.sql.SQLException;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestProject {

    public TestProject(){

    }

    /**
     * The order class should create an order object. If this object is not created (null)
     * the constructor failed.
     */
    @Test
    public void testOrderConstructor() {
        int expectedID = 1;
        Order testOrder = new Order(expectedID);
        int actualID = testOrder.getOrderNumber();
        assertEquals("Order has incorrect ID", expectedID, actualID);
        assertNotNull("Order constructor did not create and object: ", testOrder);
    }

    @Test
    public void testAddToOrder() {
        Order testOrder = new Order(1);
        Hamper testHamper = new Hamper();
        testOrder.addToOrder(testHamper);
        assertNotNull("addToOrder() did not add the hamper to the order: ", testOrder);
    }

    /**
     * The hamper class should create a hamper object. If this object is not created (null)
     * the constructor failed.
     */
    @Test
    public void testHamperConstructor(){
        Hamper testHamper = new Hamper();
        assertNotNull("The hamper constructor did not create an object: ", testHamper);
    }

    /**
     * This test adds a client to a hamper object and checks to see if the client was succesfully added.
     */
    @Test
    public void testHamperAddClientToHamperGoodData(){
        Hamper testHamper = new Hamper();
        Client testClient = new Client(1);
        testHamper.addClient(1);
        ArrayList<Client> expectedList = new ArrayList<Client>();
        expectedList.add(testClient);
        ArrayList<Client> foundList = testHamper.getClient();
        assertEquals("Method addClientToHamper did not return the expected result: ", expectedList, foundList);
    }

    /**
     * Creates a hamper object and adds a client to the hamper with an invalid integer.
     */
    @Test
    public void testHamperAddClientToHamperInvalid() {
        Hamper testHamper = new Hamper();
        boolean test = true;
        try {
            testHamper.addClient(5);

        } catch (IllegalArgumentException e){
            test = false;
        }
        assertEquals("Method did not throw the correct exception: ", false, test);
    }

    /**
     * Creates a FoodBank object and checks to see if it was created.
     */
    @Test
    public void testFoodBankConstructor() {
        FoodBank testBank = null;
        try {
            testBank = new FoodBank();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertNotNull("FoodBank constructor did not return the expected result: ", testBank);
    }

    /**
     * Creates a Food object and check to see if it was created
     */
    @Test public void testFoodConstructor() {
        int ID = 69;
        String foodName = "kumquat";
        int grainContent = 10;
        int fvContent = 30;
        int proteinContent = 30;
        int otherContent = 30;
        int calories = 420;

        Food testFood = new Food(ID, foodName, grainContent, fvContent,
                                proteinContent, otherContent, calories);
        assertNotNull("Food constructor did not return the expected result: ", testFood);
    }

    /**
     * This test tests all the getters within the Food Object
     */
    @Test
    public void testFoodGetters() {
        int ID = 69;
        String foodName = "kumquat";
        int grainContent = 10;
        int fvContent = 30;
        int proteinContent = 30;
        int otherContent = 30;
        int calories = 420;
        Food testFood = new Food(ID, foodName, grainContent, fvContent,
                proteinContent, otherContent, calories);

        assertEquals("Method getFoodName did not return expected result: ", "kumquat", testFood.getFoodName());
        assertEquals("Method getID did not return expected result: ",69, testFood.getID());
        assertEquals("Method getGrain did not return expected result: ",42, testFood.getGrain(), 0.05);
        assertEquals("Method getFV did not return expected result: ",126, testFood.getFV(), 0.05);
        assertEquals("Method getProtein did not return expected result: ",126, testFood.getProtein(), 0.05);
        assertEquals("Method getOther did not return expected result: ",126, testFood.getOther(), 0.05);
        assertEquals("Method getCalories did not return expected result: ",420, testFood.getCalories(), 0.05);
    }

    /**
     * This test uses the searchFood method to search for a food object that has a macro-nutrient closest
     * to the targetMacro The index corresponds to which macro grouping it is searching for. In order to
     * approximate a food item, the searchFood method adds 100 to the difference to ensure an item is
     * selected and since surplus is better than under
     */
    @Test
    public void testSearchFood() {
        FoodBank testBank = null;
        try {
            testBank = new FoodBank();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int foundID = testBank.searchFood(635, 0);
        int expectedID = 142;
        assertEquals("Method searchFood did not return the expected result: ", expectedID, foundID);
    }

    /**
     * This test uses the getFood method to grab a specific food item from the HashMap, foodList
     * where the ID corresponds to the key
     */
    @Test
    public void testFoodBankGetFood() {
        FoodBank testBank = null;
        try {
            testBank = new FoodBank();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Food foundFood = testBank.getFood(1);

        assertEquals("Method getFoodName did not return expected result: ", "Tomato Sauce, jar", foundFood.getFoodName());
        assertEquals("Method getID did not return expected result: ",1, foundFood.getID());
        assertEquals("Method getGrain did not return expected result: ",0, foundFood.getGrain(), 0.05);
        assertEquals("Method getFV did not return expected result: ",96, foundFood.getFV(), 0.05);
        assertEquals("Method getProtein did not return expected result: ",12, foundFood.getProtein(), 0.05);
        assertEquals("Method getOther did not return expected result: ",12, foundFood.getOther(), 0.05);
        assertEquals("Method getCalories did not return expected result: ",120, foundFood.getCalories(), 0.05);
    }

    /**
     * This test uses the fillFood method to calculate an optimized hamper based on the
     * nutritional needs of a hamper. nutNeeds is the given needs of the hamper, expected
     * macros is what the algorithm should calculate and actualMacros is the result of using fillFood.
     */
    @Test
    public void testFillFood() {
        FoodBank testBank = null;
        try {
            testBank = new FoodBank();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        double[] nutNeeds = {6356, 10388, 9716, 7140, 33600};
        double[] actualMacros = {0, 0, 0, 0 ,0};

        for(int i = 0; i < nutNeeds.length; i++) {
            testBank.fillFood(actualMacros[i], nutNeeds[i], actualMacros, i);
        }

        assertEquals("Method fillFood did not fill grain content as expected result: ",8737, actualMacros[0], 0.05);
        assertEquals("Method fillFood did not fill fruit & veggie content as expected result: ",11650.34, actualMacros[1] , 0.05);
        assertEquals("Method fillFood did not fill protein content as expected result: ",10172.66, actualMacros[2], 0.05);
        assertEquals("Method fillFood did not fill other content as expected result: ",7161, actualMacros[3], 0.05);
        assertEquals("Method fillFood did not fill protein content as expected result: ",37721, actualMacros[4], 0.05);
    }

    /**
     * This test uses the deleteFromDB method to remove an item from the database
     * by its name. If there are multiple items with the same name, it removes one instance of it
     */
    @Test
    public void testDeleteFromDB() {
        FoodBank testBank = null;
        try {
            testBank = new FoodBank();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        testBank.deleteFromDB("Black fungus, 200 g");

//        Initalizing another FoodBank object since it will have the newly updated database

        FoodBank testBank2 = null;
        try {
            testBank2 = new FoodBank();
        } catch (SQLException e){
            e.printStackTrace();
        }
        Food actual = testBank2.getFood(169);
        Food expected = null;

        assertEquals("Method deleteFromDB did not delete from the database:", expected, actual);
    }

//    @Test
//    public void testAddToOrder() {
//        Hamper testHamper = new Hamper();
//        Order testOrder = new Order();
//        testOrder.addToOrder(testHamper);
//        String foundOrder = testOrder.printOrder();
//        String expectedOrder = "some order w hamper items";
//
//        assertEquals("Method addToOrder did not return the expected result: ",expectedOrder, foundOrder);
//    }

//    @Test
//    public void testPrintOrder() {
//        Hamper testHamper = new Hamper();
//        Order testOrder = new Order();
//        String foundOrder = testOrder.printOrder();
//        String expectedOrder = "some order";
//
//        assertEquals("Method printOrder did not return the expected result: ",expectedOrder, foundOrder);
//    }

    /**
     * Creates a client object and checks to see if the object is null. It then checks if the returned client object
     * has the correct type.
     */
    @Test
    public void clientConstructorTestGoodData(){
        Client testClient = new Client(2);
        assertNotNull("The constructor did not make a client object: ", testClient);
        String expectedClientType = "Adult Female";
        String foundClientType = testClient.getClientInfo().asString();
        assertEquals("The constructor improperly made a client object: ", expectedClientType, foundClientType);
    }

    /**
     * Creates a client object with bad data. Checks to see if client constructor throws the correct constructor.
     */
    @Test
    public void clientConstructorTestBadData(){
        boolean correctException = false;
        try{
            Client testClient = new Client(893);
        }catch(IllegalArgumentException e){
            correctException = true;
        }

        assertEquals("The constructor did not throw the exception: ", true, correctException);
    }

    /**
     * Creates a hamper and client object. it then adds the client to the hamper and checks to see if the returned arraylist
     * matches the expected arraylist with the client object added.
     */
    @Test
    public void getClientTest(){
        Hamper testHamper = new Hamper();
        testHamper.addClient(1);
        testHamper.addClient(2);
        ArrayList<Client> found = testHamper.getClient();
        ClientType[] expectedList = {ClientType.ADULTMALE,ClientType.ADULTFEMALE};
        ClientType[] foundList = {found.get(0).getClientInfo(),found.get(1).getClientInfo()};
        assertEquals("The returned ArrayList was not correct: ", expectedList[0], foundList[0]);
        assertEquals("The returned ArrayList was not correct: ", expectedList[1], foundList[1]);
    }

    /**
     * Creates a hamper object. It then adds the client to the hamper before removing it. Checks to see if the client
     * was correctly removed.
     */
    @Test
    public void removeClientTestValidData(){
        Hamper testHamper = new Hamper();
        testHamper.addClient(1);
        testHamper.removeClient(0);
        ArrayList<Client> expectedList = new ArrayList<Client>();
        ArrayList<Client> foundList = testHamper.getClient();
        assertEquals("edu.ucalgary.ensf409.Client was not removed properly: ", expectedList, foundList);
    }

    /**
     * Creates a hamper and client object. It adds a client object before removing a client object that doesn't exist.
     */
    @Test
    public void removeClientTestInvalidData(){
        boolean correctExeption = false;
        try{
            Hamper testHamper = new Hamper();
            testHamper.addClient(1);
            testHamper.removeClient(5);
        }catch(IllegalArgumentException e){
            correctExeption = true;
        }
        assertEquals("removeClient did not properly throw and exception: ", true, correctExeption);
    }
    /**
     * Creates a hamper object and adds a client to it then calculates the nutritional needs and checks
     * if it matches the expected nutrients.
     */
    @Test
    public void calculateNutTest(){
        Hamper testHamper = new Hamper();
        testHamper.addClient(1);
        double[] actualNut = testHamper.calculateNut();
        double[] expectedNut = {2800, 4900, 4550, 5250, 17500};
        assertArrayEquals("The calculated nutrients does not match the expected nutrients", expectedNut, actualNut, 0.05);
    }
    /**
     * Creates a hamper object and adds a client to it and checks if the client list string is properly output
     */
    @Test
    public void getClientListTest(){
        Hamper testHamper = new Hamper();
        testHamper.addClient(1);
        String actualString = testHamper.getClientList();
        String expectedString = "1 Adult Male";
        assertEquals("the output string did not properly create the string", expectedString, actualString);
    }
    /**
     * Creates a hamper object and adds food to it and checks if the food was properly added
     */
    @Test
    public void addFoodTest(){
        Hamper testHamper = new Hamper();
        testHamper.addFood("Tomato");
        ArrayList<String> actualList = testHamper.getFood();
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("Tomato");
        assertEquals("the method did not properly add food to the hamper", expectedList, actualList);
    }

    /**
     * Creates a hamper object and adds multiple foods and checks to see if the food list string is properly output.
     */
    @Test
    public void getFoodListTest(){
        Hamper testHamper = new Hamper();
        testHamper.addFood("Tomato");
        testHamper.addFood("Potato");
        String actualString = testHamper.getFoodList();
        String expectedString = "Tomato\nPotato\n";
        assertEquals("the output string did not properly create the string", expectedString, actualString);
    }
    /**
     * Creates a client object and checks to see if the correct enumeration (type) was created in association with the
     * client object.
     */
    @Test
    public void getClientInfoTest(){
        Client testClient = new Client(2);
        ClientType expectedClientType = ClientType.ADULTFEMALE;
        ClientType foundClientType = testClient.getClientInfo();
        assertEquals("getClientInfo returned the wrong enum: ", expectedClientType, foundClientType);
    }

    /**
     * Creates a client object and then checks to see if the expected nutritional values are returned by the getters of the
     * client object.
     */
    @Test
    public void clientTestGetters(){
        Client testClient = new Client(1);
        int expectedGrain = 16;
        int expectedFV = 28;
        int expectedProtein = 26;
        int expectedOther = 30;
        int expectedCalories = 2500;
        ClientType expectedType = ClientType.ADULTMALE;
        int foundGrain = (int)(testClient.getGrain()*100);
        int foundFV = (int)(testClient.getFV()*100);
        int foundProtein = (int)(testClient.getProtein()*100);
        int foundOther = (int)(testClient.getOther()*100);
        int foundCalories = (int)testClient.getCalories();
        ClientType foundType = testClient.getClientInfo();
        assertEquals("The getter for grain returns an incorrect double: ", expectedGrain, foundGrain);
        assertEquals("The getter for fruit and veggies returns an incorrect double: ", expectedFV, foundFV);
        assertEquals("The getter for protein returns an incorrect double: ", expectedProtein, foundProtein);
        assertEquals("The getter for other returns an incorrect double: ", expectedOther, foundOther);
        assertEquals("The getter for calories returns an incorrect double: ", expectedCalories, foundCalories);
        assertEquals("The getter for client type returned an incorrect type: ", expectedType, foundType);
    }
}
