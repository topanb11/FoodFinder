/*
    Group 2 edu.ucalgary.ensf409.Food Bank
    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
    version: @1.3
    since: @1.0

    This interface is responsible for sharing the SQL database methods to the FoodBank
    and Client class
 */

package edu.ucalgary.ensf409;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class SQL {
    private final String DBURL = "jdbc:mysql://localhost/FOOD_INVENTORY";
    private final String USERNAME = "root";
    private final String PASSWORD = "topanb11";
    private Connection dbConnect;

    /**
     * This method is a getter for the database url
     * @return String This returns the url of the databse
     */
    public String getDburl() {
        return this.DBURL;
    }

    /**
     * This method is a getter for the username to access
     * the database
     * @return String This returns the username for the database
     */
    public String getUsername() {return this.USERNAME;}

    /**
     * This method is a getter for the password to access
     * the database
     * @return String This returns the password for the database
     */
    public String getPassword() {return this.PASSWORD;}

    /**
     * This method is a getter for the dbConnect to access
     * the database
     * @return String This returns the connection for the database
     */
    public Connection getDbConnect() {return this.dbConnect;}

    /**
     * This method is responsible for initializing the connection to the inventory.sql
     */
    public void initializeConnection() {
        try{
            dbConnect = DriverManager.getConnection(getDburl(), getUsername(), getPassword());
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

}
