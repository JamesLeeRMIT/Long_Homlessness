package app;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for Managing the JDBC Connection to a SQLLite Database.
 * Allows SQL queries to be used with the SQLLite Databse in Java.
 *
 * @author Timothy Wiley, 2022. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class JDBCConnection {

    // Name of database file (contained in database folder)
    private static final String DATABASE = "jdbc:sqlite:database/homeno.db";

    /**
     * This creates a JDBC Object so we can keep talking to the database
     */
    public JDBCConnection() {
        System.out.println("Created JDBC Connection Object");
    }


    public void AddData(int lga_code, int year, int status, char sex, int age, int num) {
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "INSERT INTO data VALUES ("+ lga_code +", "+ year +", "+ status +", '"+ sex +"', "+ age +", "+ num +");";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }


    public ArrayList<Homeless> getHomeless() {
        ArrayList<Homeless> datali = new ArrayList<Homeless>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM homeless";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // Create a Movie Object
                Homeless home = new Homeless();

                // Lookup the columns we want, and set the movie object field
                // BUT, we must be careful of the column type!
                home.lga_code = results.getInt("lga_code");
                home.lga_name = results.getString("lga_name");
                home.year = results.getInt("year");
                home.homeless_f_0_9 = results.getInt("homeless_f_0_9");
                home.at_risk_f_0_9 = results.getInt("at_risk_f_0_9");
                home.homeless_m_0_9 = results.getInt("homeless_m_0_9");
                home.at_risk_m_0_9 = results.getInt("at_risk_m_0_9");
                home.homeless_f_10_19 = results.getInt("homeless_f_10_19");
                home.at_risk_f_10_19 = results.getInt("at_risk_f_10_19");
                home.homeless_m_10_19 = results.getInt("homeless_m_10_19");
                home.at_risk_m_10_19 = results.getInt("at_risk_m_10_19");
                home.homeless_f_20_29 = results.getInt("homeless_f_20_29");
                home.at_risk_f_20_29 = results.getInt("at_risk_f_20_29");
                home.homeless_m_20_29 = results.getInt("homeless_m_20_29");
                home.at_risk_m_20_29 = results.getInt("at_risk_m_20_29");
                home.homeless_f_30_39 = results.getInt("homeless_f_30_39");
                home.at_risk_f_30_39 = results.getInt("at_risk_f_30_39");
                home.homeless_m_30_39 = results.getInt("homeless_m_30_39");
                home.at_risk_m_30_39 = results.getInt("at_risk_m_30_39");
                home.homeless_f_40_49 = results.getInt("homeless_f_40_49");
                home.at_risk_f_40_49 = results.getInt("at_risk_f_40_49");
                home.homeless_m_40_49 = results.getInt("homeless_m_40_49");
                home.at_risk_m_40_49 = results.getInt("at_risk_m_40_49");
                home.homeless_f_50_59 = results.getInt("homeless_f_50_59");
                home.at_risk_f_50_59 = results.getInt("at_risk_f_50_59");
                home.homeless_m_50_59 = results.getInt("homeless_m_50_59");
                home.at_risk_m_50_59 = results.getInt("at_risk_m_50_59");
                home.homeless_f_60_plus = results.getInt("homeless_f_60_plus");
                home.at_risk_f_60_plus = results.getInt("at_risk_f_60_plus");
                home.homeless_m_60_plus = results.getInt("homeless_m_60_plus");
                home.at_risk_m_60_plus = results.getInt("at_risk_m_60_plus");
                home.unknown_f = results.getInt("unknown_f");
                home.unknown_m = results.getInt("unknown_m");

                // Add the movie object to the array
                datali.add(home);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the movies
        return datali;

    }

    public ArrayList<Income> getIncome() {
        ArrayList<Income> datali = new ArrayList<Income>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM income";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // Create a Movie Object
                Income data = new Income();

                // Lookup the columns we want, and set the movie object field
                // BUT, we must be careful of the column type!
                data.lga_code = results.getInt("lga_code");
                data.lga_name = results.getString("lga_name");
                data.median_household_weekly_income = results.getInt("median_household_weekly_income");
                data.median_age = results.getInt("median_age");
                data.median_mortgage_repay_monthly = results.getInt("median_mortgage_repay_monthly");
                data.median_rent_weekly = results.getInt("median_rent_weekly");

                // Add the movie object to the array
                datali.add(data);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the movies
        return datali;

    }

    public ArrayList<Location> getLocation() {
        ArrayList<Location> datali = new ArrayList<Location>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM location";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // Create a Movie Object
                Location data = new Location();

                // Lookup the columns we want, and set the movie object field
                // BUT, we must be careful of the column type!
                data.lga_code = results.getInt("lga_code");
                data.lga_name = results.getString("lga_name");
                data.lga_type = results.getString("lga_type");
                data.area_sqkm4 = results.getString("area_sqkm4");
                data.latitude = results.getString("latitude");
                data.longitude = results.getString("longitude");

                // Add the movie object to the array
                datali.add(data);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the movies
        return datali;

    }

    public ArrayList<Population> getPopulation() {
        ArrayList<Population> datali = new ArrayList<Population>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM population";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // Create a Movie Object
                Population data = new Population();

                // Lookup the columns we want, and set the movie object field
                // BUT, we must be careful of the column type!
                data.lga_code = results.getInt("lga_code");
                data.lga_name = results.getString("lga_name");
                data.y2016 = results.getInt("2016");
                data.y2018 = results.getInt("2018");


                // Add the movie object to the array
                datali.add(data);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the movies
        return datali;

    }


    // TODO: Keep adding more methods here to answer all of the questions from the Studio Class activities
}
