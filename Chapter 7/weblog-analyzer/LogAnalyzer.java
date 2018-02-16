/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer(String filename)
    { 
        // Create the array object to hold the hourly access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader(filename);
        analyzeHourlyData();
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }
    
    /**
     * Find the total number of accesses.
     */
    public int numberOfAccesses()
    {
        int total = 0;
        for (int hour = 0; hour < hourCounts.length; hour++) 
        {
            total += hourCounts[hour];
        }
        return total;
    }
    
    /**
     * Find the busiest hour.
     */
    public int busiestHour()
    {
        int ret = -1, count = 0;
        for (int i = 0; i < hourCounts.length; i++)
        {
            if (hourCounts[i] > count) 
            {
                count = hourCounts[i];
                ret = i;
            }
        }
        return ret;
    }
    
    /**
     * Find the quietest hour.
     */
    public int quietestHour()
    {
        int ret = -1, count = Integer.MAX_VALUE;
        for (int i = 0; i < hourCounts.length; i++)
        {
            if (hourCounts[i] < count) 
            {
                count = hourCounts[i];
                ret = i;
            }        
        }
        return ret;
    }
    
    /**
     * Find the busiest 2 hour period.
     */
    public int busy2Hours()
    {
        int ret = -1, count = 0;
        for (int i = 0; i < hourCounts.length - 1; i++)
        {
            if (hourCounts[i] + hourCounts[i+1] > count)
            {
                count = hourCounts[i] + hourCounts[i+1];
                ret = i;
            }
        }
        return ret;
    }
    
    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}
