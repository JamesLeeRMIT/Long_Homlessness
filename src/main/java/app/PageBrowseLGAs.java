package app;

import java.util.ArrayList;
import java.util.Arrays;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.HashMap;

/**
 * Example Index HTML class using Javalin
 * <p>
 * Generate a static HTML page using Javalin
 * by writing the raw HTML into a Java String object
 *
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class PageBrowseLGAs implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/browse/*";

    @Override
    public void handle(Context context) throws Exception {
        // Look up some information from JDBC
        // First we need to use your JDBCConnection class
        JDBCConnection jdbc = new JDBCConnection();


        String state = context.path().substring(8);

        String[] states = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        ArrayList<String> statesli = new ArrayList<String>(Arrays.asList(states));


        if (statesli.contains(state)) {
            // Get stuff from the database
            ArrayList<Homeless> lgas = new ArrayList<Homeless>();

            lgas = jdbc.getLgaState(state);


            // the context stuff we put in the template
            HashMap<String, Object> model = new HashMap<>();
            model.put("lgas", lgas);

            // render the template
            context.render("pages/browseLGAs.html", model);
        } else {
            // Get stuff from the database

            ArrayList<Homeless> lgas = new ArrayList<Homeless>();

            lgas = jdbc.getAllHomeless();

            // the context stuff we put in the template
            HashMap<String, Object> model = new HashMap<>();
            model.put("lgas", lgas);


            // render the template
            context.render("pages/browseLGAs.html", model);
        }
    }

}
