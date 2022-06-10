package app;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
public class ImportData implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/";

    @Override
    public void handle(Context context) throws Exception {
        // Look up some information from JDBC
        // First we need to use your JDBCConnection class
        JDBCConnection jdbc = new JDBCConnection();

        // Get stuff from the database


        try (CSVReader reader = new CSVReader(new FileReader("/home/fish/programing/based/dataset-Homelessness/homeless-2018.csv"))) {
            String[] lineInArray;

            lineInArray = reader.readNext();

            int age = 0;
            int agec = 0;
            String lga;
            char sex = 'f';
            int sexc = 0;
            int status = 0;

            while ((lineInArray = reader.readNext()) != null) {
                age = 0;
                agec = 0;
                sex = 'f';
                sexc = 0;
                status = 0;

                lga = lineInArray[0];
                for (int i = 1; i < lineInArray.length - 2; ++i) {
                    System.out.println(lga + lineInArray[i] + "My" + age + sex + status);

                    jdbc.AddData(Integer.parseInt(lga), 2018, status, sex, age, Integer.parseInt(lineInArray[i]));

                    agec++;
                    sexc++;

                    if (agec == 4) {
                        age++;
                        agec = 0;
                    }
                    if (sexc == 2) {
                        sexc = 0;
                        if (sex == 'f') {
                            sex = 'm';
                        } else {
                            sex = 'f';
                        }
                    }
                    if (status == 0) {
                        status = 1;
                    } else {
                        status = 0;
                    }
                }
            }
        } catch(Exception e) {
            System.out.println(e);//  Block of code to handle errors
        }


        // the context stuff we put in the template
        HashMap<String, Object> model = new HashMap<>();


        // render the template
        context.render("pages/main.html", model);
    }

}
