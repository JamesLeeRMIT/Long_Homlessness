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
            int homeless16 = 0;
            int homeless18 = 0;
            int atRisk16 = 0;
            int atRisk18 = 0;
            int pop16 = 0;
            int pop18 = 0;
            int median_household_weekly_income  = 0;
            int median_age  = 0;
            int median_mortgage_repay_monthly = 0;
            int median_rent_weekly = 0;

            lgas = jdbc.getLgaState(state);

            for (Homeless lga: lgas) {
                homeless16 += lga.homeless16;
                homeless18 += lga.homeless18;
                atRisk18 += lga.atRisk18;
                atRisk16 += lga.atRisk16;
                pop16 += lga.pop16;
                pop18 += lga.pop18;
                median_household_weekly_income += lga.median_household_weekly_income;
                median_age += lga.median_age;
                median_mortgage_repay_monthly += lga.median_mortgage_repay_monthly;
                median_rent_weekly += lga.median_rent_weekly;
            }

            median_household_weekly_income = median_household_weekly_income/ lgas.size();
            median_age = median_age/ lgas.size();
            median_mortgage_repay_monthly = median_mortgage_repay_monthly/ lgas.size();
            median_rent_weekly = median_rent_weekly/ lgas.size();


            // the context stuff we put in the template
            HashMap<String, Object> model = new HashMap<>();

            model.put("homeless16", homeless16);
            model.put("homeless18", homeless18);
            model.put("atRisk18", atRisk18);
            model.put("atRisk16", atRisk16);
            model.put("pop16", pop16);
            model.put("pop18", pop18);
            model.put("median_household_weekly_income", median_household_weekly_income);
            model.put("median_age", median_age);
            model.put("median_mortgage_repay_monthly", median_mortgage_repay_monthly);
            model.put("median_rent_weekly", median_rent_weekly);


            model.put("lgas", lgas);

            // render the template
            context.render("pages/browseLGAs.html", model);
        } else {
            // Get stuff from the database

            ArrayList<Homeless> lgas = new ArrayList<Homeless>();

            int homeless16 = 0;
            int homeless18 = 0;
            int atRisk16 = 0;
            int atRisk18 = 0;
            int pop16 = 0;
            int pop18 = 0;
            int median_household_weekly_income  = 0;
            int median_age  = 0;
            int median_mortgage_repay_monthly = 0;
            int median_rent_weekly = 0;

            lgas = jdbc.getLgaState(state);

            for (Homeless lga: lgas) {
                homeless16 += lga.homeless16;
                homeless18 += lga.homeless18;
                atRisk18 += lga.atRisk18;
                atRisk16 += lga.atRisk16;
                pop16 += lga.pop16;
                pop18 += lga.pop18;
                median_household_weekly_income += lga.median_household_weekly_income;
                median_age += lga.median_age;
                median_mortgage_repay_monthly += lga.median_mortgage_repay_monthly;
                median_rent_weekly += lga.median_rent_weekly;
            }

            median_household_weekly_income = median_household_weekly_income/ lgas.size();
            median_age = median_age/ lgas.size();
            median_mortgage_repay_monthly = median_mortgage_repay_monthly/ lgas.size();
            median_rent_weekly = median_rent_weekly/ lgas.size();

            // the context stuff we put in the template
            HashMap<String, Object> model = new HashMap<>();

            model.put("homeless16", homeless16);
            model.put("homeless18", homeless18);
            model.put("atRisk18", atRisk18);
            model.put("atRisk16", atRisk16);
            model.put("pop16", pop16);
            model.put("pop18", pop18);
            model.put("median_household_weekly_income", median_household_weekly_income);
            model.put("median_age", median_age);
            model.put("median_mortgage_repay_monthly", median_mortgage_repay_monthly);
            model.put("median_rent_weekly", median_rent_weekly);

            model.put("lgas", lgas);


            // render the template
            context.render("pages/browseLGAs.html", model);
        }
    }

}
