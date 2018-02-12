import java.awt.Color;
import java.util.*;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @editor Lawrence
 * @version 2/11/18
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private ArrayList<BouncingBall> balls;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo(int n)
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        Random rnd = new Random();
        int ground = 400;
        balls = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            balls.add(new BouncingBall(rnd.nextInt(100), rnd.nextInt(100), rnd.nextInt(20), Color.BLUE, ground, myCanvas)); 
        }
    }
    
    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);

        // create and show the balls
        for (BouncingBall ball : balls)
            ball.draw();

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            for (BouncingBall ball : balls)
                ball.move();
            // stop once ball has travelled a certain distance on x axis
            finished = true;
            for (BouncingBall ball : balls)
                if (ball.getXPosition() < 550)
                    finished = false;
        }
    }
}
