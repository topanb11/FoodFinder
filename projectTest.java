/*
    Group 2 Food Bank
    version: @1.0

 */

package edu.ucalgary.ensf409;

import java.beans.Transient;

import org.junit.;
import static org.junit.Assert.;

public class projectTest {

    public projectTest(){

    }
    @Test
    public void testOrderConstructor() {
        Order order1 = new Order();
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
    public void testFoodBankGetFood() {
        
    }
    public void testAddtoOrder() {
        order1.addToOrder(testHamper);
        Order expectedOrder = new Order();

        assertEquals("method addToOrder did not return the expected result: ",expectedOrder, foundOrder);
    }

    @Test
    public void testPrintOrder() {
        String orderString = order.printOrder();
        String expectedOrder = "lorem ipsum cock";
        assertEquals("method printOrder did not return the expected result: ",expectedOrder);
    }

    @Test
    public void testHamperAddClientToHamperInvalid {}


}