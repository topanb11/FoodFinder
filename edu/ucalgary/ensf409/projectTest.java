package edu.ucalgary.ensf409;

/*
    Group 2 edu.ucalgary.ensf409.Food Bank
    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
    version: @1.3
    since: @1.0
 */

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class projectTest {

    public projectTest(){

    }
    @Test
    public void testOrderConstructor() {
        Order testOrder = new Order();
        assertNotNull("The order constructor did not create an object: ", testOrder);
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
        assertNotNull("edu.ucalgary.ensf409.FoodBank constructor did not return the expected result: ", testBank);
    }

    @Test public void testFoodConstructor() {
        Food testFood = new Food();
        assertNotNull("edu.ucalgary.ensf409.Food constructor did not return the expected result: ", testFood);
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

        int foundID = testBank.searchFood(WG, fV, protein, other, calories);
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
    public void removeClientTestValidData(){
        Hamper testHamper = new Hamper();
        Client testClient = new Client(1);
        testHamper.addClientToHamper(testClient.getClientInfo());
        testHamper.removeClient(1);
        ArrayList<Client> expectedList = new ArrayList<Client>();
        ArrayList<Client> foundList = testHamper.getClientList();
        assertEquals("edu.ucalgary.ensf409.Client was not removed properly: ", expectedList, foundList);
    }
    @Test
    public void removeClientTestInvalidData(){
        boolean correctExeption = false;
        try{
            Hamper testHamper = new Hamper();
            Client testClient = new Client(1);
            testHamper.addClientToHamper(testClient.getClientInfo());
            testHamper.removeClient(5);
        }catch(IllegalArgumentException e){
            correctExeption = true;
        }
        assertEquals("removeClient did not properly throw and exception: ", true, correctExeption);
    }

    @Test
    public void getClientTest(){
        Hamper testHamper = new Hamper();
        Client testClient = new Client(1);
        testHamper.addClientToHamper(testClient.getClientInfo());
        ArrayList<Client> expectedList = new ArrayList<Client>();
        expectedList.add(testClient);
        Client testClient1 = new Client(2);
        testHamper.addClientToHamper(testClient1.getClientInfo());
        expectedList.add(testClient1);
        ArrayList<Client> foundList = testHamper.getClient();
        assertEquals("The returned ArrayList was not correct: ", expectedList, foundList);
    }

    @Test
    public void getClientInfoTest(){
        Client testClient = new Client(2);
        ClientType expectedClientType = ADULTFEMALE;
        ClientType foundClientType = testClient.getClientInfo();
        assertEquals("getClientInfo returned the wrong enum: ", expectedClientType, foundClient);
    }

    @Test
    public void clientConstructorTestGoodData(){
        Client testClient = new Client(2);
        String expectedClientType = "AdultFemale";
        String foundClientType = testClient.getClientInfo().asString();
        assertEquals("The constructor improperly made a client object: ", expectedClientType, foundClient);
    }

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
}
