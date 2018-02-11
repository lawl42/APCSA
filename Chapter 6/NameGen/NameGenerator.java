import java.util.*;
/**
 * Generates a name based on George Lucas' secret formula.
 *
 * @author Lawrence
 * @version 2/10/18
 */
public class NameGenerator
{
    /**
     * Constructor for objects of class NameGenerator
     */
    public NameGenerator()
    {
           
    }

    /**
     * 
     */
    public String generateStarWarsName(String first, String last, String maiden, String city)
    {
        return last.substring(0,3) + first.toLowerCase().substring(0,2) + " " + maiden.substring(0,2) + city.toLowerCase().substring(0,3);
    }
}
