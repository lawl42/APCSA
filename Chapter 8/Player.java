import java.util.*;
/**
 * Write a description of class Player here.
 *
 * @author Lawrence
 * @version 5.2.2018
 */
public class Player
{
    // instance variables - replace the example below with your own
    private static final int MAX_WEIGHT = 10;
    private String name;
    private Room currentRoom;
    private List<Item> items;
    private int currentWeight;

    /**
     * Constructor for objects of class Player
     */
    public Player(String name)
    {
        this.name = name;
        items = new ArrayList<>();
        currentWeight = 0;
    }
    
    public String getName() {
        return name;
    }

    public void setCurrentRoom(Room newRoom) {
        currentRoom = newRoom;
    }
    
    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    public boolean takeItem(Item item) {
        if (currentWeight + item.getWeight() > MAX_WEIGHT) return false;
        items.add(item);
        currentWeight += item.getWeight();
        return true;
    }
    
    public List<Item> getItems() {
        return items;
    }
    
    public void dropItem(Item item) {
        currentWeight -= item.getWeight();
        items.remove(item);
    }
    
    public void displayItems() {
        System.out.println("You have the following items:");
        for (Item item : items) {
            System.out.println(item.displayItem());
        }
        System.out.println("Total weight = " + currentWeight);
    }
}
