import java.awt.Color;
import java.util.Random;

/**
 * Class DrawDemo - provides some short demonstrations showing how to use the 
 * Pen class to create various drawings.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class DrawDemo
{
    private Canvas myCanvas;
    private Random random;

    /**
     * Prepare the drawing demo. Create a fresh canvas and make it visible.
     */
    public DrawDemo()
    {
        myCanvas = new Canvas("Drawing Demo", 500, 400);
        random = new Random();
    }
    
    /**
     * Draw a triangle on the screen.
     */
    public void drawTriangle()
    {
        drawPolygon(3);
    }
    /**
     * Draw a square on the screen.
     */
    public void drawSquare()
    {
        drawPolygon(4);
    }

    /**
     * Draw a wheel made of many squares.
     */
    public void drawWheel()
    {
        Pen pen = new Pen(250, 200, myCanvas);
        pen.setColor(Color.RED);

        for (int i=0; i<36; i++) {
            square(pen);
            pen.turn(10);
        }
    }
    
    /**
     * Draw a polygon.
     */
    public void drawPolygon(int n)
    {
        Random rnd = new Random();
        Pen pen = new Pen(rnd.nextInt(200), rnd.nextInt(200), myCanvas);
        polygon(pen, n);
    }
    
    /**
     * Draw a polygon.
     */
    private void polygon(Pen pen, int n)
    {
        for (int i = 0; i < n; i++) {
            pen.move(50);
            pen.turn(180 - ((n - 2) * 180 / n));
        }
    }
    
    /**
     * Draw a square in the pen's color at the pen's location.
     */
    private void square(Pen pen)
    {
        for (int i=0; i<4; i++) {
            pen.move(100);
            pen.turn(90);
        }
    }

    /**
     * Draw some random squiggles on the screen, in random colors.
     */
    public void colorScribble()
    {
        Pen pen = new Pen(250, 200, myCanvas);

        for (int i=0; i<10; i++) {
            // pick a random color
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            pen.setColor(new Color(red, green, blue));
            
            pen.randomSquiggle();
        }
    }
    
    /**
     * Draw a spiral.
     */
    public void drawSpiral()
    {
        Pen pen = new Pen(100, 100, myCanvas);
        int len = 200;
        while (len > 0)
        {
            pen.move(len);
            pen.turn(90);
            pen.move(len);
            pen.turn(90);
            len -= 5;
        }
    }
    
    /**
     * Clear the screen.
     */
    public void clear()
    {
        myCanvas.erase();
    }
}
