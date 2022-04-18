package edu.ucalgary.ensf409;

///*
//    Group 2 edu.ucalgary.ensf409.Food Bank
//    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
//    version: @1.3
//    since: @1.0
// */
//
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class clientTest {

    public clientTest(){

    }
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
     * Creates a hamper and client object. It then adds the client to the hamper before removing it. Checks to see if the client
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
