
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class ClockDisplay
{
    private NumberDisplay seconds;
    private int hr;
    private int min;
    private int sec;
    private String displayString;    // simulates the actual display
    private int[] hour;
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        seconds = new NumberDisplay(86400);
        hour = new int[12];
        hour[0] = 12;
        for (int i = 1; i < 12; i++)
            hour[i] = i;
        setTime(0, 0, 0);
        updateDisplayAM();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hr, int min, int sec)
    {
        seconds = new NumberDisplay(86400);
        hour = new int[12];
        hour[0] = 12;
        for (int i = 1; i < 12; i++)
            hour[i] = i;
        setTime(hr, min, sec);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        seconds.increment();
        int temp = seconds.getValue();
        this.hr = temp / 3600;
        temp %= 3600;
        this.min = temp / 60;
        temp %= 60;
        this.sec = temp;
        setTime(this.hr, this.min, this.sec);
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hr, int min, int sec)
    {
        seconds.setValue(hr * 3600 + min * 60 + sec);
        this.hr = hour[hr % 12];
        this.min = min;
        this.sec = sec;
        if (hr >= 12)
            updateDisplayPM();
        else
            updateDisplayAM();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplayAM()
    {
        String min = (this.min < 10 ? "0" : "") + this.min;
        String sec = (this.sec < 10 ? "0" : "") + this.sec;
        displayString = hr + ":" + min + "." + sec + " AM";
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplayPM()
    {
        String min = (this.min < 10 ? "0" : "") + this.min;
        String sec = (this.sec < 10 ? "0" : "") + this.sec;
        displayString = hr + ":" + min + "." + sec + " PM";
    }
}
