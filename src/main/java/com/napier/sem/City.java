package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Represents a city which we use for city reports.
 * @author logan
 */
public class City {
    /**
     * City's Name
     */
    public String name;

    /**
     * City's Country
     */
    public String country;

    /**
     * City's district
     */
    public String district;

    /**
     * City's population
     */
    public int population;

    /**
     * @param con        the database we are connected to
     * @param location   the grouping used for where to select the countries from (region/continent)
     * @param cityTarget the target region/continent to select the countries of
     * @param limit      the number of entries to retrieve from db (0 means all entries)
     * @return an arraylist of the countries in the database
     * @since 0.1.1.0
     */

    static ArrayList<City> getAllCountries(Connection con, String location, String cityTarget, int limit) {

        System.out.println("Getting countries");

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.Country, city.District, city.Population " +
                            "FROM city" +
                            " LEFT JOIN country" +
                            "on country.Capital = city.ID";


            if (!location.isEmpty()) {

                if (location.equals("Continent")) {

                    strSelect = strSelect + "WHERE Continent = '" + cityTarget + "' ";

                } else {

                    strSelect = strSelect + "WHERE region = '" + cityTarget + "'";

                }

            }

            strSelect = strSelect + "ORDER BY city.Population DESC ";

            if (limit != 0) {

                strSelect = strSelect + "LIMIT " + limit;

            }

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("Country.Name");
                city.country = rset.getString("Country.Country");
                city.district = rset.getString("Country.District");
                city.population = rset.getInt("Country.Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * @param cities arraylist from the output of an sql query
     * @since 0.1.1.0
     */
    static void printCities(ArrayList<City> cities) {

        System.out.println("Printing cities\n");

        for (City city : cities) {

            String formatter = String.format("%-6s %-38s %-18s %-26s %-10s %-10s", city.name, city.country, city.district, city.population);
            System.out.println(formatter);

        }

    }

}

