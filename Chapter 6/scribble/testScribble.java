import java.lang.Thread;
/**
 * Write a description of class testScribble here.
 *
 * @author  D. Lewin
 * @version 1.0
 */
public class testScribble
{
    
    /**
     * Constructor for objects of class testScribble
     */
    public static void main(String[] args)
    {
        DrawDemo demo;
        demo = new DrawDemo(); 
        demo.drawPolygon(8);
        try {
            // thread to sleep for 1000 milliseconds
            Thread.sleep(1000);
         } catch (Exception e) {
            System.out.println(e);
        }
        demo.clear();
        demo.drawSpiral();
        try {
            // thread to sleep for 1000 milliseconds
            Thread.sleep(1000);
         } catch (Exception e) {
            System.out.println(e);
        }
        demo.clear(); 
        demo.drawTriangle();
        
        
    }

}
