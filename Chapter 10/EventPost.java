
/**
 * Write a description of class EventPost here.
 *
 * @author Lawrece
 * @version 3/4/18
 */
public class EventPost extends Post
{
    // instance variables - replace the example below with your own
    private String location;
    private String event;

    /**
     * Constructor for objects of class EventPost
     */
    public EventPost(String author, String location, String event)
    {
        super(author);
        this.location = location;
        this.event = event;
    }

    /**
     * Javadoc for such an easy program is preposterous
     */
    public String getEvent()
    {
        return event;
    }
    
    /**
     * Javadoc for such an easy program is preposterous
     */
    public String getLocation()
    {
        return location;
    }
}
