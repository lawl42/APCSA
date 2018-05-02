
/**
 * Write a description of class Item here.
 *
 * @author Lawrence
 * @version 4.26.2018
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String name;
    private String description;
    private int weight;
    private boolean canBePickedUp;

    /**
     * Constructor for objects of class Item
     */
    public Item(String name, String description, int weight, boolean canBePickedUp)
    {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.canBePickedUp = canBePickedUp;
    }

    /**
     * @return The name of the item
     * (the one that was defined in the constructor).
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * @return The short description of the item
     * (the one that was defined in the constructor).
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * @return The weight of the item
     * (the one that was defined in the constructor).
     */
    public int getWeight()
    {
        return weight;
    }
    
    public boolean takeable() {
        return canBePickedUp;
    }
    
    public String displayItem() {
        return "Item: " + getName() + "; Description: " + getDescription() + "; Weight: " + getWeight();
    }
    
}
