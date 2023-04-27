package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * Represents our application.
 * This is where we run generic functions and database functions.
 * @author logan, joseph, jack
 *
 */
public class App
{
    /**
     * Connection to MySQL database.
     * Used for passing into functions.
     */
    private Connection con = null;

    /**
     * <p>
     * Connect to the MySQL database.
     * </p>
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * <p>
     * Disconnect from the MySQL database.
     * </p>
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        //Create menu here
        System.out.println("World Database!\n");

        ArrayList<Country> countries = Country.getAllCountries(a.con, "", "", 0);
        Country.printCountries(countries);

        String target = "Africa";
        countries = Country.getAllCountries(a.con, "Continent", target, 4);
        Country.printCountries(countries);

        target = "Western Africa";
        countries = Country.getAllCountries(a.con, "Region", target, 2);
        Country.printCountries(countries);

        countries = Country.getAllCountries(a.con, "", "", 3);
        Country.printCountries(countries);

        target = "France";
        ArrayList<City> cities = City.getAllCities(a.con, "Country", target, 4);
        City.printCities(cities);

        target = "Zuid-Holland";
        cities = City.getAllCities(a.con, "District", target, 3);
        City.printCities(cities);

        target = "Africa";
        cities = City.getAllCities(a.con, "Continent", target, 5);
        City.printCities(cities);

        target = "Western Africa";
        cities = City.getAllCities(a.con, "Region", target, 4);
        City.printCities(cities);

        cities = City.getAllCities(a.con, "", "", 3);
        City.printCities(cities);

        cities = City.getAllCities(a.con, "", "", 0);
        City.printCities(cities);

        ArrayList<Capital> capitals = Capital.getAllCapitals(a.con, "", "", 3);
        Capital.printCapitals(capitals);

        capitals = Capital.getAllCapitals(a.con, "Continent", "Europe", 5);
        Capital.printCapitals(capitals);

        capitals = Capital.getAllCapitals(a.con, "Region", "Western Africa", 4);
        Capital.printCapitals(capitals);


        // Disconnect from database
        a.disconnect();

    }
}