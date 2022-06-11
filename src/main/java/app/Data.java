package app;

/**
 * Class represeting a Movie from the Movies database
 * For simplicity this uses public fields
 * You could use private fields with getters to be safer
 *
 * @author Timothy Wiley, 2022. email: timothy.wiley@rmit.edu.au
 */
public class Data {
   // Movie id
   public int status;
   public String sex;
   public int age;
   public int num;



   public Data() {
   }

   /**
    * Create a movie setting all of the fields
    */
   public Data(int status, String sex, int age, int num) {
       // definitions

       this.status = status;
       this.sex = sex;
       this.age = age;
       this.num = num;
   }
}
