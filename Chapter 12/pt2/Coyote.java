import java.util.*;
/**
 * A simple model of a coyote.
 * Coyotes age, move, eat rabbits, eat foxes, and die.
 * 
 * @author Lawrence
 * @version March 2018
 */
public class Coyote extends Animal
{
    // Characteristics shared by all coyotes (class variables).
    
    // The age at which a coyote can start to breed.
    private static final int BREEDING_AGE = 20;
    // The age to which a coyote can live.
    private static final int MAX_AGE = 200;
    // The likelihood of a coyote breeding.
    private static final double BREEDING_PROBABILITY = 0.02;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 1;
    // The food value of a single rabbit. In effect, this is the
    // number of steps a coyote can go before it has to eat again.
    private static final int RABBIT_FOOD_VALUE = 9;
    // The food value of a single rabbit. In effect, this is the
    // number of steps a coyote can go before it has to eat again.
    private static final int FOX_FOOD_VALUE = 15;

    // Individual characteristics (instance fields).
    // The fox's food level, which is increased by eating rabbits or foxes.
    private int foodLevel;
    
    /**
     * Constructor for objects of class Coyote
     */
    public Coyote(Field field, Location location)
    {
        super(field, location);
        foodLevel = FOX_FOOD_VALUE;
    }
    
    /**
     * This is what the fox does most of the time: it hunts for
     * rabbits. In the process, it might breed, die of hunger,
     * or die of old age.
     * @param field The field currently occupied.
     * @param newFoxes A list to return newly born foxes.
     */
    public void act(List<Animal> newCoyotes)
    {
        incrementAge();
        incrementHunger();
        if(isAlive()) {
            giveBirth(newCoyotes);            
            // Move towards a source of food if found.
            Location newLocation = findFood();
            if(newLocation == null) { 
                // No food found - try to move to a free location.
                newLocation = getField().freeAdjacentLocation(getLocation());
            }
            // See if it was possible to move.
            if(newLocation != null) {
                setLocation(newLocation);
            }
            else {
                // Overcrowding.
                setDead();
            }
        }
    }

    /**
     * @return The max age.
     */
    public int getMaxAge()
    {
        return MAX_AGE;
    }
    
    /**
     * Make this fox more hungry. This could result in the fox's death.
     */
    private void incrementHunger()
    {
        foodLevel--;
        if(foodLevel <= 0) {
            setDead();
        }
    }
    
    /**
     * Look for rabbits adjacent to the current location.
     * Only the first live rabbit is eaten.
     * @return Where food was found, or null if it wasn't.
     */
    private Location findFood()
    {
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if(animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if(rabbit.isAlive()) { 
                    rabbit.setDead();
                    foodLevel = RABBIT_FOOD_VALUE;
                    return where;
                }
            }
            else if (animal instanceof Fox){
                Fox fox = (Fox) animal;
                if (fox.isAlive()) {
                    fox.setDead();
                    foodLevel = FOX_FOOD_VALUE;
                    return where;
                }
            }
        }
        return null;
    }
    
    /**
     * Check whether or not this coyote is to give birth at this step.
     * New births will be made into free adjacent locations.
     * @param newCoyotes A list to return newly born foxes.
     */
    private void giveBirth(List<Animal> newCoyotes)
    {
        // New foxes are born into adjacent locations.
        // Get a list of adjacent free locations.
        Field field = getField();
        List<Location> free = field.getFreeAdjacentLocations(getLocation());
        int births = breed();
        for(int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Coyote young = new Coyote(field, loc);
            newCoyotes.add(young);
        }
    }
        
    /**
     * @return The breeding probability.
     */
    public double getBreedingProbability()
    {
        return BREEDING_PROBABILITY;
    }
    
    /**
     * @return The max litter size.
     */
    public int getLitterSize()
    {
        return MAX_LITTER_SIZE;
    }
    
    /**
     * A fox can breed if it has reached the breeding age.
     */
    public int getBreedingAge()
    {
        return BREEDING_AGE;
    }

}
