package app;

/**
 * Class represeting a Movie from the Movies database
 * For simplicity this uses public fields
 * You could use private fields with getters to be safer
 *
 * @author Timothy Wiley, 2022. email: timothy.wiley@rmit.edu.au
 */
public class Location {
   // Movie id
   public int lga_code;
   public String lga_name;
   public String lga_type;
   public String area_sqkm4;
   public String latitude;
   public String longitude;



   public Location() {
   }

   /**
    * Create a movie setting all of the fields
    */
   public Location(int lga_code, String lga_name, String lga_type, String area_sqkm4, String latitude, String longitude) {
       // definitions

       this.lga_code = lga_code;
       this.lga_name = lga_name;
       this.lga_type = lga_type;
       this.area_sqkm4 = area_sqkm4;
       this.latitude = latitude;
       this.longitude = longitude;
   }
}
