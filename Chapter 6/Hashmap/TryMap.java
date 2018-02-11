/**
 * Tester for the Hash Map code
 *
 * @author D. Lewin 
 * @version 1.0 
 */
public class TryMap
{
    // instance variables - replace the example below with your own
   public static void main(String args[]) 
     { 
       MapTester mapTest = new MapTester(); 
       mapTest.enterNumber("John Road", "(859) 245 3450");
       mapTest.enterNumber("Selen East", "(859) 283 9091");
       mapTest.enterNumber("Lisa Butterfield", "(916) 283 5611");
       
       mapTest.lookupNumber("(859) 283 9091");
       System.out.println(" Selen East number is " + mapTest.lookupNumber("Selen East" ));
    }
}