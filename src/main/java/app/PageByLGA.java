package app;

import java.util.ArrayList;

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
public class PageByLGA implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/LGA";

    @Override
    public void handle(Context context) throws Exception {
        // Look up some information from JDBC
        // First we need to use your JDBCConnection class
        JDBCConnection jdbc = new JDBCConnection();

        // Get stuff from the database


        // the context stuff we put in the template
        HashMap<String, Object> model = new HashMap<>();


        // render the template
        context.render("pages/byLGA.html", model);
    }

}
