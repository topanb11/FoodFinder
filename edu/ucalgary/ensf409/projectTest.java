//package edu.ucalgary.ensf409;
//
///*
//    Group 2 edu.ucalgary.ensf409.Food Bank
//    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
//    version: @1.3
//    since: @1.0
// */
//
//import java.util.*;
//import org.junit.*;
//import org.testng.annotations.Test;
//import static org.junit.Assert.*;
//
//public class projectTest {
//
//    public projectTest(){
//
//    }
//
//    /**
//     * The order class should create an order object. If this object is not created (null)
//     * the constructor failed.
//     */
//    @Test
//    public void testOrderConstructor() {
//        Order testOrder = new Order();
//        assertNotNull("The order constructor did not create an object: ", testOrder);
//    }
//
//    /**
//     * The hamper class should create a hamper object. If this object is not created (null)
//     * the constructor failed.
//     */
//    @Test
//    public void testHamperConstructor(){
//        Hamper testHamper = new Hamper();
//        assertNotNull("The hamper constructor did not create an object: ", testHamper);
//    }
//
//    /**
//     * This test adds a client to a hamper object and checks to see if the client was succesfully added.
//     */
//    @Test
//    public void testHamperAddClientToHamperGoodData(){
//        Hamper testHamper = new Hamper();
//        Client testClient = new Client(1);
//        testHamper.addClientToHamper(1);
//        ArrayList<Client> expectedList = new ArrayList<Client>();
//        expectedList.add(testClient);
//        foundList = testHamper.getClientList();
//        assertEquals("Method addClientToHamper did not return the expected result: ", expectedList, foundList);
//    }
//
//    /**
//     * Creates a hamper object and adds a client to the hamper with an invalid integer.
//     */
//    @Test
//    public void testHamperAddClientToHamperInvalid() {
//        Hamper testHamper = new Hamper();
//        boolean test = true;
//        try {
//            testHamper.addClientToHamper(5);
//
//        } catch (IllegalArgumentException e){
//            test = false;
//        }
//        assertEquals("Method did not throw the correct exception: ", false, test);
//    }
//
//    /**
//     * Creates a FoodBank object and checks to see if it was created.
//     */
//    @Test
//    public void testFoodBankConstructor() {
//        FoodBank testBank = new FoodBank();
//        assertNotNull("FoodBank constructor did not return the expected result: ", testBank);
//    }
//
//    @Test public void testFoodConstructor() {
//        int ID = 69;
//        String foodName = "kumquat";
//        int grainContent = 10;
//        int fvContent = 30;
//        int proteinContent = 30;
//        int otherContent = 30;
//        int calories = 420;
//
//        Food testFood = new Food(ID, foodName, grainContent, fvContent,
//                                proteinContent, otherContent, calories);
//        assertNotNull("Food constructor did not return the expected result: ", testFood);
//    }
//
//    /**
//     * This test should search for a food item that has a macro-nutrient closest to the targetMacro
//     * The index corresponds to which macro grouping it is searching for
//     */
//    @Test
//    public void testSearchFood() {
//        FoodBank testBank = new FoodBank();
//        int foundID = testBank.searchFood(635, 0);
//        int expectedID = 72;
//        assertEquals("Method searchFood did not return the expected result: ", expectedID, foundID);
//    }
//
//    /**
//     * This test should grab a specific food item from the HashMap, foodList where the ID corresponds
//     * to the key
//     */
//    @Test
//    public void testFoodBankGetFood() {
//        FoodBank testBank = new FoodBank();
//        testBank.initializeConnection();
//        testBank.storeFood();
//        Food foundFood = testBank.getFood(0);
//
//
//        assertEquals("Method getFood did not return the expected result: ", expectedFood, foundFood);
//    }
//
//    @Test
//    public void testAddToOrder() {
//        Hamper testHamper = new Hamper();
//        Order testOrder = new Order();
//        testOrder.addToOrder(testHamper);
//        String foundOrder = testOrder.printOrder();
//        String expectedOrder = "some order w hamper items";
//
//        assertEquals("method addToOrder did not return the expected result: ",expectedOrder, foundOrder);
//    }
//    @Test
//    public void testPrintOrder() {
//        Hamper testHamper = new Hamper();
//        Order testOrder = new Order();
//        String foundOrder = testOrder.printOrder();
//        String expectedOrder = "some order";
//
//        assertEquals("method printOrder did not return the expected result: ",expectedOrder, foundOrder);
//    }
//
//    /**
//     * Creates a client object and checks to see if the object is null. It then checks if the returned client object
//     * has the correct type.
//     */
//    @Test
//    public void clientConstructorTestGoodData(){
//        Client testClient = new Client(1);
//        assertNotNull("The constructor did not make a client object: ", testClient);
//        String expectedClientType = "AdultFemale";
//        String foundClientType = testClient.getClientInfo().asString();
//        assertEquals("The constructor improperly made a client object: ", expectedClientType, foundClientType);
//    }
//
//    /**
//     * Creates a client object with bad data. Checks to see if client constructor throws the correct constructor.
//     */
//    @Test
//    public void clientConstructorTestBadData(){
//        boolean correctException = false;
//        try{
//            Client testClient = new Client(893);
//        }catch(IllegalArgumentException e){
//            correctException = true;
//        }
//
//        assertEquals("The constructor did not throw the exception: ", true, correctException);
//    }
//
//    /**
//     * Creates a hamper and client object. it then adds the client to the hamper and checks to see if the returned arraylist
//     * matches the expected arraylist with the client object added.
//     */
//    @Test
//    public void getClientTest(){
//        Hamper testHamper = new Hamper();
//        Client testClient = new Client(1);
//        testHamper.addClientToHamper(testClient.getClientInfo());
//        ArrayList<Client> expectedList = new ArrayList<Client>();
//        expectedList.add(testClient);
//        Client testClient1 = new Client(2);
//        testHamper.addClientToHamper(testClient1.getClientInfo());
//        expectedList.add(testClient1);
//        ArrayList<Client> foundList = testHamper.getClient();
//        assertEquals("The returned ArrayList was not correct: ", expectedList, foundList);
//    }
//
//    /**
//     * Creates a hamper and client object. It then adds the client to the hamper before removing it. Checks to see if the client
//     * was correctly removed.
//     */
//    @Test
//    public void removeClientTestValidData(){
//        Hamper testHamper = new Hamper();
//        Client testClient = new Client(1);
//        testHamper.addClientToHamper(testClient.getClientInfo());
//        testHamper.removeClient(1);
//        ArrayList<Client> expectedList = new ArrayList<Client>();
//        ArrayList<Client> foundList = testHamper.getClientList();
//        assertEquals("edu.ucalgary.ensf409.Client was not removed properly: ", expectedList, foundList);
//    }
//
//    /**
//     * Creates a hamper and client object. It adds a client object before removing a client object that doesn't exist.
//     */
//    @Test
//    public void removeClientTestInvalidData(){
//        boolean correctExeption = false;
//        try{
//            Hamper testHamper = new Hamper();
//            Client testClient = new Client(1);
//            testHamper.addClientToHamper(testClient.getClientInfo());
//            testHamper.removeClient(5);
//        }catch(IllegalArgumentException e){
//            correctExeption = true;
//        }
//        assertEquals("removeClient did not properly throw and exception: ", true, correctExeption);
//    }
//
//    /**
//     * Creates a client object and checks to see if the correct enumeration (type) was created in association with the
//     * client object.
//     */
//    @Test
//    public void getClientInfoTest(){
//        Client testClient = new Client(1);
//        ClientType expectedClientType = ClientType.ADULTFEMALE;
//        ClientType foundClientType = testClient.getClientInfo();
//        assertEquals("getClientInfo returned the wrong enum: ", expectedClientType, foundClientType);
//    }
//
//    /**
//     * Creates a client object and then checks to see if the expected nutritional values are returned by the getters of the
//     * client object.
//     */
//    @Test
//    public void clientTestGetters(){
//        Client testClient = new Client(0);
//        double expectedGrain = 16;
//        double expectedFV = 28;
//        double expectedProtein = 26;
//        double expectedOther = 30;
//        double expectedCalories = 2500;
//        double foundGrain = testClient.getGrain();
//        double foundFV = testClient.getFV();
//        double foundProtein = testClient.getProtein();
//        double foundOther = testClient.getOther();
//        double foundCalories = testClient.getCalories();
//        assertEquals("The getter for grain returns an incorrect double: ", expectedGrain, foundGrain);
//        assertEquals("The getter for fruit and veggies returns an incorrect double: ", expectedFV, foundFV);
//        assertEquals("The getter for protein returns an incorrect double: ", expectedProtein, foundProtein);
//        assertEquals("The getter for other returns an incorrect double: ", expectedOther, foundOther);
//        assertEquals("The getter for calories returns an incorrect double: ", expectedCalories, foundCalories);
//    }
//}
