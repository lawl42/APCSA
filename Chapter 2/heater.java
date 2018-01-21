/**
 * Write a description of class heater here.
 *
 * @author Lawrence
 * @version 1.0
 */
public class heater
{
    // instance variables - replace the example below with your own
    double temperature;
    double min, max, increment;

    /**
     * Constructor for objects of class heater
     */
    public heater(double MIN_TEMP, double MAX_TEMP)
    {
        // initialise instance variables
        temperature = 15.0;
        min = MIN_TEMP;
        max = MAX_TEMP;
        increment = 5.0;
    }

    /**
     * raise temp
     */
    public void warmer()
    {
        temperature += increment;
        if (temperature > max) temperature = max;
    }
    
    /*
     * lower temp
     */
    public void cooler()
    {
        temperature -= increment;
        if (temperature < min) temperature = min;
    }
    
    /*
     * get temp
     */
    public double getTemp()
    {
        return temperature;
    }
    
    /*
     * set inc
     */
    public void setInc(double newInc)
    {
        if (newInc < 0) System.out.println("Give a non-negative increment.");
        else increment = newInc;
    }
}
