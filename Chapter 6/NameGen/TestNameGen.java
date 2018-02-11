
/**
 * Write a description of class TestNameGen here.
 *
 * @author D. Lewin
 * @version 1.0 
 */
public class TestNameGen
{
   public static void main(String[] args) 
   { 
       String name; 
       NameGenerator  create = new NameGenerator(); 
       name = create.generateStarWarsName("Susan" , "Betteroff" ,
                                        "Sidefield" , "Frankfort");
       System.out.println("New Name is " + name); 
       
    }
}
