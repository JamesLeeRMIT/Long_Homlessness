package app;

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
   public int year;
   public int homeless_f_0_9;
   public int at_risk_f_0_9;
   public int homeless_m_0_9;
   public int at_risk_m_0_9;
   public int homeless_f_10_19;
   public int at_risk_f_10_19;
   public int homeless_m_10_19;
   public int at_risk_m_10_19;
   public int homeless_f_20_29;
   public int at_risk_f_20_29;
   public int homeless_m_20_29;
   public int at_risk_m_20_29;
   public int homeless_f_30_39;
   public int at_risk_f_30_39;
   public int homeless_m_30_39;
   public int at_risk_m_30_39;
   public int homeless_f_40_49;
   public int at_risk_f_40_49;
   public int homeless_m_40_49;
   public int at_risk_m_40_49;
   public int homeless_f_50_59;
   public int at_risk_f_50_59;
   public int homeless_m_50_59;
   public int at_risk_m_50_59;
   public int homeless_f_60_plus;
   public int at_risk_f_60_plus;
   public int homeless_m_60_plus;
   public int at_risk_m_60_plus;
   public int unknown_f;
   public int unknown_m;



   public Homeless() {
   }

   /**
    * Create a movie setting all of the fields
    */
   public Homeless(int lga_code, String lga_name, int year, int homeless_f_0_9, int at_risk_f_0_9, int homeless_m_0_9, int at_risk_m_0_9, int homeless_f_10_19, int at_risk_f_10_19, int homeless_m_10_19, int at_risk_m_10_19, int homeless_f_20_29, int at_risk_f_20_29, int homeless_m_20_29, int at_risk_m_20_29, int homeless_f_30_39, int at_risk_f_30_39, int homeless_m_30_39, int at_risk_m_30_39, int homeless_f_40_49, int at_risk_f_40_49, int homeless_m_40_49, int at_risk_m_40_49, int homeless_f_50_59, int at_risk_f_50_59, int homeless_m_50_59, int at_risk_m_50_59, int homeless_f_60_plus, int at_risk_f_60_plus, int homeless_m_60_plus, int at_risk_m_60_plus, int unknown_f, int unknown_m) {
       // definitions

       this.lga_code = lga_code;
       this.lga_name = lga_name;
       this.year = year;
       this.homeless_f_0_9 = homeless_f_0_9;
       this.at_risk_f_0_9 = at_risk_f_0_9;
       this.homeless_m_0_9 = homeless_m_0_9;
       this.at_risk_m_0_9 = at_risk_m_0_9;
       this.homeless_f_10_19 = homeless_f_10_19;
       this.at_risk_f_10_19 = at_risk_f_10_19;
       this.homeless_m_10_19 = homeless_m_10_19;
       this.at_risk_m_10_19 = at_risk_m_10_19;
       this.homeless_f_20_29 = homeless_f_20_29;
       this.at_risk_f_20_29 = at_risk_f_20_29;
       this.homeless_m_20_29 = homeless_m_20_29;
       this.at_risk_m_20_29 = at_risk_m_20_29;
       this.homeless_f_30_39 = homeless_f_30_39;
       this.at_risk_f_30_39 = at_risk_f_30_39;
       this.homeless_m_30_39 = homeless_m_30_39;
       this.at_risk_m_30_39 = at_risk_m_30_39;
       this.homeless_f_40_49 = homeless_f_40_49;
       this.at_risk_f_40_49 = at_risk_f_40_49;
       this.homeless_m_40_49 = homeless_m_40_49;
       this.at_risk_m_40_49 = at_risk_m_40_49;
       this.homeless_f_50_59 = homeless_f_50_59;
       this.at_risk_f_50_59 = at_risk_f_50_59;
       this.homeless_m_50_59 = homeless_m_50_59;
       this.at_risk_m_50_59 = at_risk_m_50_59;
       this.homeless_f_60_plus = homeless_f_60_plus;
       this.at_risk_f_60_plus = at_risk_f_60_plus;
       this.homeless_m_60_plus = homeless_m_60_plus;
       this.at_risk_m_60_plus = at_risk_m_60_plus;
       this.unknown_f = unknown_f;
       this.unknown_m = unknown_m;
   }
}
