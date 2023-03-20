package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

/**
 *
 * Represents our application.
 * This is where we run generic functions and database functions.
 * @author logan, joseph
 *
 */
public class App
{
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
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
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
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

    /*

    public Employee getEmployee(int ID)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT emp_no, first_name, last_name "
                            + "FROM employees "
                            + "WHERE emp_no = " + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next())
            {
                Employee emp = new Employee();
                emp.emp_no = rset.getInt("emp_no");
                emp.first_name = rset.getString("first_name");
                emp.last_name = rset.getString("last_name");
                return emp;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get employee details");
            return null;
        }
    }
    public void displayEmployee(Employee emp)
    {
        if (emp != null)
        {
            System.out.println(
                    emp.emp_no + " "
                            + emp.first_name + " "
                            + emp.last_name + "\n"
                            + emp.title + "\n"
                            + "Salary:" + emp.salary + "\n"
                            + emp.dept_name + "\n"
                            + "Manager: " + emp.manager + "\n");
        }
    }

     * Gets all the current employees and salaries.
     * @return A list of all employees and salaries, or null if there is an error.
*/

    /*
     * Gets all the current employees and salaries within a role. //only Engineers now
     * @return A list of all the engineer employees and salaries, or null if there is an error.

    public ArrayList<Employee> getSalariesByTitle()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT employees.emp_no, employees.first_name, employees.last_name, salaries.salary\n" +
                            "FROM employees, salaries, titles\n" +
                            "WHERE employees.emp_no = salaries.emp_no\n" +
                            "AND employees.emp_no = titles.emp_no\n" +
                            "AND salaries.to_date = '9999-01-01'\n" +
                            "AND titles.to_date = '9999-01-01'\n" +
                            "AND titles.title = 'Engineer'\n" +
                            "ORDER BY employees.emp_no ASC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Employee> employees = new ArrayList<Employee>();
            while (rset.next())
            {
                Employee emp = new Employee();
                emp.emp_no = rset.getInt("employees.emp_no");
                emp.first_name = rset.getString("employees.first_name");
                emp.last_name = rset.getString("employees.last_name");
                emp.salary = rset.getInt("salaries.salary");
                employees.add(emp);
            }
            return employees;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }

    */

    /*
    public static String targetInput()
    {

        System.out.println("Please enter a location to produce a report on:\n");
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        return input.next();  // Read user input

    }

    //For generic use in switch statements.
    public static Integer menuInput()
    {

        int option;

        System.out.println("Enter choice:");

        Scanner input = new Scanner(System.in);  // Create a Scanner object
        while(! input.hasNext()) { }
        option = Integer.parseInt(input.next());  // Read user input
        System.out.println("");

        return option;

    }

     */

    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        //Create menu here
        System.out.println("World Database!\n");

        String target = "Africa";
        ArrayList<Country> countries = Country.getAllCountries(a.con, "Continent", target, 0);
        Country.printCountries(countries);

        target = "Western Africa";
        countries = Country.getAllCountries(a.con, "Region", target, 0);
        Country.printCountries(countries);

        countries = Country.getAllCountries(a.con, "", target, 3);
        Country.printCountries(countries);

        /*

        Integer report = 0;

        while(report != 6)
        {

            System.out.println("What report would you like to produce?");
            System.out.println("1. Country report");
            System.out.println("2. City report");
            System.out.println("3. Capital report");
            System.out.println("4. Population report");
            System.out.println("5. Language report");
            System.out.println("6. Exit\n");

            report = menuInput();

            switch(report) {

                //Country report
                case 1:

                    while(report != 4)
                    {

                        System.out.println("What kind of country report would you like to produce?");
                        System.out.println("1. Countries of the world");
                        System.out.println("2. Countries of a continent");
                        System.out.println("3. Countries of a region");
                        System.out.println("4. Back to menu\n");

                        report = menuInput();

                        switch(report) {

                            case 1:

                                ArrayList<Country> countries = Country.getAllCountries(a.con, "", "");
                                Country.printCountries(countries);

                                break;
                            //World case end

                            case 2:

                                String target = targetInput();
                                countries = Country.getAllCountries(a.con, "Continent", target);
                                Country.printCountries(countries);

                                break;
                            //Continent case end

                            case 3:

                                break;
                            //Region case end

                        }

                        System.out.println("");

                    }

                    break;
                //Country case end



                //City report
                case 2:

                    break;
                //City case end



                //Capital report
                case 3:

                    break;
                //Capital case end



                //Population report
                case 4:

                    break;
                //Population case end



                //Language report
                case 5:

                    break;
                //Language case end

            }

        }

         */

        // Extract employee salary information by their title
        //ArrayList<Employee> employeesByTitle = a.getSalariesByTitle();

        // Test the size of the returned data -
        //System.out.println(employeesByTitle.size());

        // Disconnect from database
        a.disconnect();

    }
}