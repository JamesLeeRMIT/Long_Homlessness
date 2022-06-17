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


    public ArrayList<Homeless> getAllHomeless() {
        ArrayList<Homeless> homeli = new ArrayList<Homeless>();

        int homeless16;
        int homeless18;
        int atRisk16;
        int atRisk18;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "Select * from LGAData inner join population on LGAData.lga_code = population.lga_code join income on LGAData.lga_code = income.lga_code";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                Statement statement2 = connection.createStatement();
                statement2.setQueryTimeout(30);

                homeless16 = 0;
                homeless18 = 0;
                atRisk16 = 0;
                atRisk18 = 0;

                // Create a Movie Object
                Homeless home = new Homeless();

                ArrayList<Data> data16 = new ArrayList<Data>();
                ArrayList<Data> data18 = new ArrayList<Data>();

                home.lga_code = results.getInt("lga_code");
                home.lga_name = results.getString("lga_name");

                home.lga_type = results.getString("lga_type");
                home.area = results.getString("area");
                home.latitude = results.getString("latitude");
                home.longitude = results.getString("longitude");

                home.pop16 = results.getInt("Y2016");
                home.pop18 = results.getInt("Y2018");
                home.median_household_weekly_income = results.getInt("median_household_weekly_income");
                home.median_age = results.getInt("median_age");
                home.median_mortgage_repay_monthly = results.getInt("median_mortgage_repay_monthly");
                home.median_rent_weekly = results.getInt("median_rent_weekly");

                query = "Select * from data where lga_code =" + home.lga_code;

                // Get Result
                ResultSet datares = statement2.executeQuery(query);

                while (datares.next()) {
                    Data data = new Data();

                    data.status = datares.getInt("status");
                    data.sex = datares.getString("sex");
                    data.age = datares.getInt("age");
                    data.num = datares.getInt("num");


                    if (datares.getInt("year") == 2016) {
                        data16.add(data);

                        if (data.status == 0) {
                            homeless16 += data.num;
                        } else {
                            atRisk16 += data.num;
                        }
                    } else {
                        data18.add(data);

                        if (data.status == 0) {
                            homeless18 += data.num;
                        } else {
                            atRisk18 += data.num;
                        }
                    }
                }

                home.homeless16 = homeless16;
                home.homeless18 = homeless18;
                home.atRisk18 = atRisk18;
                home.atRisk16 = atRisk16;

                home.data16 = data16;
                home.data18 = data18;


                // Add the movie object to the array
                homeli.add(home);
                statement2.close();
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
        return homeli;

    }


    public Homeless getLga(String lga_code) {
        Homeless home = new Homeless();

        int homeless16;
        int homeless18;
        int atRisk16;
        int atRisk18;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "Select * from LGAData inner join population on LGAData.lga_code = population.lga_code join income on LGAData.lga_code = income.lga_code where LGAData.lga_code = " + lga_code;

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                Statement statement2 = connection.createStatement();
                statement2.setQueryTimeout(30);

                homeless16 = 0;
                homeless18 = 0;
                atRisk16 = 0;
                atRisk18 = 0;


                ArrayList<Data> data16 = new ArrayList<Data>();
                ArrayList<Data> data18 = new ArrayList<Data>();

                home.lga_code = results.getInt("lga_code");
                home.lga_name = results.getString("lga_name");

                home.lga_type = results.getString("lga_type");
                home.area = results.getString("area");
                home.latitude = results.getString("latitude");
                home.longitude = results.getString("longitude");

                home.pop16 = results.getInt("Y2016");
                home.pop18 = results.getInt("Y2018");
                home.median_household_weekly_income = results.getInt("median_household_weekly_income");
                home.median_age = results.getInt("median_age");
                home.median_mortgage_repay_monthly = results.getInt("median_mortgage_repay_monthly");
                home.median_rent_weekly = results.getInt("median_rent_weekly");

                query = "Select * from data where lga_code =" + home.lga_code;

                // Get Result
                ResultSet datares = statement2.executeQuery(query);

                while (datares.next()) {
                    Data data = new Data();

                    data.status = datares.getInt("status");
                    data.sex = datares.getString("sex");
                    data.age = datares.getInt("age");
                    data.num = datares.getInt("num");


                    if (datares.getInt("year") == 2016) {
                        data16.add(data);

                        if (data.status == 0) {
                            homeless16 += data.num;
                        } else {
                            atRisk16 += data.num;
                        }
                    } else {
                        data18.add(data);

                        if (data.status == 0) {
                            homeless18 += data.num;
                        } else {
                            atRisk18 += data.num;
                        }
                    }
                }

                home.homeless16 = homeless16;
                home.homeless18 = homeless18;
                home.atRisk18 = atRisk18;
                home.atRisk16 = atRisk16;

                home.data16 = data16;
                home.data18 = data18;


                // Add the movie object to the array
                statement2.close();
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
        return home;

    }


    public ArrayList<Homeless> getLgaState(String stateCode) {
        ArrayList<Homeless> homeli = new ArrayList<Homeless>();

        int homeless16;
        int homeless18;
        int atRisk16;
        int atRisk18;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "Select * from LGAData inner join population on LGAData.lga_code = population.lga_code join income on LGAData.lga_code = income.lga_code WHERE (LGAData.lga_code LIKE '" + stateCode + "%') GROUP BY LGAData.lga_name";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                Statement statement2 = connection.createStatement();
                statement2.setQueryTimeout(30);

                homeless16 = 0;
                homeless18 = 0;
                atRisk16 = 0;
                atRisk18 = 0;

                // Create a Movie Object
                Homeless home = new Homeless();

                ArrayList<Data> data16 = new ArrayList<Data>();
                ArrayList<Data> data18 = new ArrayList<Data>();

                home.lga_code = results.getInt("lga_code");
                home.lga_name = results.getString("lga_name");

                home.lga_type = results.getString("lga_type");
                home.area = results.getString("area");
                home.latitude = results.getString("latitude");
                home.longitude = results.getString("longitude");

                home.pop16 = results.getInt("Y2016");
                home.pop18 = results.getInt("Y2018");
                home.median_household_weekly_income = results.getInt("median_household_weekly_income");
                home.median_age = results.getInt("median_age");
                home.median_mortgage_repay_monthly = results.getInt("median_mortgage_repay_monthly");
                home.median_rent_weekly = results.getInt("median_rent_weekly");

                query = "Select * from data where lga_code =" + home.lga_code;

                // Get Result
                ResultSet datares = statement2.executeQuery(query);

                while (datares.next()) {
                    Data data = new Data();

                    data.status = datares.getInt("status");
                    data.sex = datares.getString("sex");
                    data.age = datares.getInt("age");
                    data.num = datares.getInt("num");


                    if (datares.getInt("year") == 2016) {
                        data16.add(data);

                        if (data.status == 0) {
                            homeless16 += data.num;
                        } else {
                            atRisk16 += data.num;
                        }
                    } else {
                        data18.add(data);

                        if (data.status == 0) {
                            homeless18 += data.num;
                        } else {
                            atRisk18 += data.num;
                        }
                    }
                }

                home.homeless16 = homeless16;
                home.homeless18 = homeless18;
                home.atRisk18 = atRisk18;
                home.atRisk16 = atRisk16;

                home.data16 = data16;
                home.data18 = data18;


                // Add the movie object to the array
                homeli.add(home);
                statement2.close();
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
        return homeli;

    }

    // TODO: Keep adding more methods here to answer all of the questions from the Studio Class activities
}
