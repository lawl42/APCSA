
/**
 * Write a description of class TestLog here.
 *
 * @author D. Lewin
 * @version 1.0 
 */
public class TestLog
{
   public static void main(String[] args)
      {
       // Setup the logAnalyzer to read the dedualt file 
       LogAnalyzer logdata = new LogAnalyzer("weblog.txt");
       // test 7.13
       System.out.println("total number of entries is " +logdata.numberOfAccesses());
       // test 7.15
       System.out.println("the busiest hour is " +logdata.busiestHour());
       // test 7.16
       System.out.println("the quietest hour is " +logdata.quietestHour());
       // test 7.18
       System.out.println("the busiest 2 hour period is " +logdata.busy2Hours());
    }
}
