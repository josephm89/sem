package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;

/**
 * Represents a country which we use for country reports.
 * @author logan
 */
public class Country
{
    /**
     * Country's Code
     */
    public String code;

    /**
     * Country's Name
     */
    public String name;

    /**
     * Country's Continent
     */
    public String continent;

    /**
     * Country's Region
     */
    public String region;

    /**
     * Country's Population
     */
    public int population;

    /**
     * Country's Capital
     */
    public String capital;


    /**
     *
     * @param con the database we are connected to
     * @param location the grouping used for where to select the countries from (region/continent)
     * @param target the target region/continent to select the countries of
     * @param limit the number of entries to retrieve from db (0 means all entries)
     * @return an arraylist of the countries in the database
     * @since 0.1.1.0
     */
    static ArrayList<Country> getAllCountries(Connection con, String location, String target, int limit)
    {

        System.out.println("Getting countries");

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, IFNULL(city.Name, 'N/A') AS Capital "
                            + "FROM country "
                            + "LEFT JOIN city "
                            + "ON country.Capital = city.ID ";

                            if(!location.isEmpty())
                            {

                                if(location.equals("Continent"))
                                {

                                    strSelect = strSelect + "WHERE Continent = '" + target + "' ";

                                }

                                else
                                {

                                    strSelect = strSelect + "WHERE region = '" + target + "'";

                                }

                            }

                            strSelect = strSelect + "ORDER BY country.Population DESC ";

                            if(limit != 0)
                            {

                                strSelect = strSelect + "LIMIT " + limit;

                            }

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next())
            {
                Country cntry = new Country();
                cntry.code = rset.getString("Country.Code");
                cntry.name = rset.getString("Country.Name");
                cntry.continent = rset.getString("Country.Continent");
                cntry.region = rset.getString("Country.Region");
                cntry.population = rset.getInt("Country.Population");
                cntry.capital = rset.getString("Capital");
                countries.add(cntry);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /*

    public void printSalaries(ArrayList<Employee> employees)
    {
        // Print header
        System.out.println(String.format("%-10s %-15s %-20s %-8s", "Emp No", "First Name", "Last Name", "Salary"));
        // Loop over all employees in the list
        for (Employee emp : employees)
        {
            String emp_string =
                    String.format("%-10s %-15s %-20s %-8s",
                            emp.emp_no, emp.first_name, emp.last_name, emp.salary);
            System.out.println(emp_string);
        }
    }

     */

    /**
     *
     * @param countries arraylist from the output of an  sql query
     * @return nothing, it creates output within the function
     * @since 0.1.1.0
     */
    static void printCountries(ArrayList<Country> countries)
    {

        System.out.println("Printing countries\n");

        for(Country country : countries)
        {

            String formatter = String.format("%-6s %-38s %-18s %-26s %-10s %-10s", country.code, country.name, country.continent, country.region, country.population, country.capital);
            System.out.println(formatter);

        }

    }

}