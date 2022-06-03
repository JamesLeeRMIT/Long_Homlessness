package app;

/**
 * Class represeting a Movie from the Movies database
 * For simplicity this uses public fields
 * You could use private fields with getters to be safer
 *
 * @author Timothy Wiley, 2022. email: timothy.wiley@rmit.edu.au
 */
public class Income {
   // Movie id
   public int lga_code;
   public String lga_name;
   public int median_household_weekly_income;
   public int median_age;
   public int median_mortgage_repay_monthly;
   public int median_rent_weekly;



   public Income() {
   }

   /**
    * Create a movie setting all of the fields
    */
   public Income(int lga_code, String lga_name, int median_household_weekly_income, int median_age, int median_mortgage_repay_monthly, int median_rent_weekly) {
       // definitions

       this.lga_code = lga_code;
       this.lga_name = lga_name;
       this.median_household_weekly_income = median_household_weekly_income;
       this.median_age = median_age;
       this.median_mortgage_repay_monthly = median_mortgage_repay_monthly;
       this.median_rent_weekly = median_rent_weekly;
   }
}
