package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Represents a city which we use for city reports.
 * @author logan, jack
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
     *
     * <p>
     *     Runs our query on our database which we can then operate functions on.
     *     It changes the returned results based on the inputs we provide for it.
     * </p>
     * @param con the database we are connected to
     * @param location the grouping used for where to select the cities from (country)
     * @param cityTarget the target country to select the cities of
     * @param limit the number of entries to retrieve from db (0 means all entries)
     * @return an arraylist of the cities in the database
     * @since 0.1.1.3
     */

    static ArrayList<City> getAllCities(Connection con, String location, String cityTarget, int limit) {

        System.out.println("Getting cities");

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, IF(city.District = '–', 'N/A', city.District) AS District, city.Population " +
                            "FROM city " +
                            "LEFT JOIN country " +
                            "ON city.CountryCode = country.Code ";


            if (!location.isEmpty()) {

                if (location.equals("Country"))
                {

                    strSelect = strSelect + "WHERE country.Name = '" + cityTarget + "' ";

                }

                else if (location.equals("Region"))
                {

                    strSelect = strSelect + "WHERE country.Region = '" + cityTarget + "' ";

                }

                else if (location.equals("District"))
                {

                    strSelect = strSelect + "WHERE District = '" + cityTarget + "' ";

                }

                else
                {

                    strSelect = strSelect + "WHERE country.Continent = '" + cityTarget + "' ";

                }

            }

            strSelect = strSelect + "ORDER BY city.Population DESC ";

            if (limit != 0) {

                strSelect = strSelect + "LIMIT " + limit;

            }

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("City.Name");
                city.country = rset.getString("Country.Name");
                city.district = rset.getString("District");
                city.population = rset.getInt("City.Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     *
     * <p>
     *     Prints the given arraylist of cities, which are gathered from our database queries.
     * </p>
     *
     * @param cities arraylist from the output of an sql query
     * @since 0.1.1.3
     */
    static void printCities(ArrayList<City> cities) {

        if(cities == null || cities.isEmpty())
        {

            System.out.println("No cities");
            System.out.println();
            return;

        }

        System.out.println("Printing cities\n");

        for (City city : cities) {

            String formatter = String.format("%-26s %-38s %-20s %-9s", city.name, city.country, city.district, city.population);
            System.out.println(formatter);

        }

        System.out.println();

    }

}

