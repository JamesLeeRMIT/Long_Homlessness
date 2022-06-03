package app;

/**
 * Class represeting a Movie from the Movies database
 * For simplicity this uses public fields
 * You could use private fields with getters to be safer
 *
 * @author Timothy Wiley, 2022. email: timothy.wiley@rmit.edu.au
 */
public class Population {
   // Movie id
   public int lga_code;
   public String lga_name;
   public int y2016;
   public int y2018;



   public Population() {
   }

   /**
    * Create a movie setting all of the fields
    */
   public Population(int lga_code, String lga_name, int y2016, int y2018) {
       // definitions

       this.lga_code = lga_code;
       this.lga_name = lga_name;
       this.y2016 = y2016;
       this.y2018 = y2018;
   }
}
