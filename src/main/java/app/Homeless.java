package app;


import java.util.ArrayList;

/**
 * Class represeting a Movie from the Movies database
 * For simplicity this uses public fields
 * You could use private fields with getters to be safer
 *
 * @author Timothy Wiley, 2022. email: timothy.wiley@rmit.edu.au
 */
public class Homeless {
   // Movie id
   public int lga_code;
   public String lga_name;

   public ArrayList<Data> data16 = new ArrayList<Data>();
   public ArrayList<Data> data18 = new ArrayList<Data>();
   public int homeless16;
   public int homeless18;
   public int atRisk16;
   public int atRisk18;


   public int pop16;
   public int pop18;
   public int median_household_weekly_income;
   public int median_age;
   public int median_mortgage_repay_monthly;
   public int median_rent_weekly;
   public String lga_type;
   public String area;
   public String latitude;
   public String longitude;

   public Homeless() {
   }

   /**
    * Create a movie setting all of the fields
    */
   public Homeless(int lga_code, String lga_name, ArrayList<Data> data16, ArrayList<Data> data18, int homeless16, int homeless18, int atRisk16, int atRisk18, int pop16, int pop18, int median_household_weekly_income, int median_age, int median_mortgage_repay_monthly, int median_rent_weekly, String lga_type, String area, String latitude, String longitude) {
       // definitions

       this.lga_code = lga_code;
       this.lga_name = lga_name;

       this.data16 = data16;
       this.data18 = data18;

       this.homeless16 = homeless16;
       this.homeless18 = homeless18;
       this.atRisk18 = atRisk18;
       this.atRisk16 = atRisk16;

       this.pop16 = pop16;
       this.pop18 = pop18;
       this.median_household_weekly_income = median_household_weekly_income;
       this.median_age = median_age;
       this.median_mortgage_repay_monthly = median_mortgage_repay_monthly;
       this.median_rent_weekly = median_rent_weekly;
       this.lga_type = lga_type;
       this.area = area;
       this.latitude = latitude;
       this.longitude = longitude;

   }
}
