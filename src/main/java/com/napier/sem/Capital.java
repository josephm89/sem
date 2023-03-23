package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Represents a capital city which we use for capital reports.
 * @author logan, Jack
 */
public class Capital
{
    /**
     * Capital's name
     */
    public String name;

    /**
     * Capital's Country
     */
    public String country;

    /**
     * Capital's Population
     */
    public int population;

    /**
     * @param con           the database we are connected to
     * @param location      the grouping used for where to select the capital from (country)
     * @param capitalTarget the target country to select the capitals of
     * @param limit         the number of entries to retrieve from db (0 means all entries)
     * @return an arraylist of the capitals in the database
     * @since 0.1.1.0
     */

    static ArrayList<Capital> getAllCapitals(Connection con, String location, String capitalTarget, int limit) {

        System.out.println("Getting capitals");

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.Country, city.District, city.Population " +
                            "FROM city" +
                            " RIGHT JOIN country" +
                            " on country.Capital = city.ID";


            if (!location.isEmpty()) {

                if (location.equals("Country")) {

                    strSelect = strSelect + "WHERE Country = '" + capitalTarget + "' ";

                } else {

                    strSelect = strSelect + "WHERE District = '" + capitalTarget + "'";

                }

            }

            strSelect = strSelect + "ORDER BY city.Population DESC ";

            if (limit != 0) {

                strSelect = strSelect + "LIMIT " + limit;

            }

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Capital> capitals= new ArrayList<>();
            while (rset.next()) {
                Capital capital = new Capital();
                capital.name = rset.getString("Capital.Name");
                capital.country = rset.getString("Capital.Country");
                capital.population = rset.getInt("Capital.Population");
                capitals.add(capital);
            }
            return capitals;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital details");
            return null;
        }
    }

    /**
     * @param capitals arraylist from the output of an sql query
     * @since 0.1.1.0
     */
    static void printCapitals(ArrayList<Capital> capitals) {

        System.out.println("Printing capitals\n");

        for (Capital city : capitals) {

            String formatter = String.format("%-6s %-38s %-18s %-26s %-10s %-10s", city.name, city.country, city.population);
            System.out.println(formatter);

        }

    }

}



