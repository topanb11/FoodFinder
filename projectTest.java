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
}