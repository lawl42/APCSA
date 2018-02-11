import java.util.*;
/**
 * Write a description of class MapTester here.
 *
 * @author Lawrence
 * @version 2/8/18
 */
public class MapTester
{
    // instance variables - replace the example below with your own
    private HashMap<String, String> contacts;

    /**
     * Constructor for objects of class MapTester
     */
    public MapTester()
    {
        contacts = new HashMap<>();
    }

    public void enterNumber(String name, String number) {
        contacts.put(name, number);
    }
    
    public String lookupNumber(String name) {
        return contacts.get(name);
    }
}
