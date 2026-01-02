package bouncingtext.bouncingtextapplet.java;

import java.applet.Applet;
import java.awt.*;

/**
 * A simple bouncing text applet.
 * Replace "YOUR NAME" with your actual name.
 */
public class BouncingTextApplet extends Applet implements Runnable {

    private Thread animationThread;      // The thread for animation
    private String name = "YOUR NAME";   // Replace with your name
    private int xCoord = 0;              // Current x-coordinate for the text
    private final int yCoord = 50;       // Fixed y-coordinate (vertical position)
    private final int textSpeed = 3;     // Speed of movement

    /**
     * Called when the applet is first loaded.
     */
    public void init() {
        setSize(400, 100);                // Set the applet's size
        setBackground(Color.BLACK);      // Set a background color
    }

    /**
     * Called to create and start the animation thread.
     */
    public void start() {
        if (animationThread == null) {
            animationThread = new Thread(this);
            animationThread.start();
        }
    }

    /**
     * The thread's main execution loop.
     */
    public void run() {
        while (Thread.currentThread() == animationThread) {
            xCoord += textSpeed;

            if (xCoord > getWidth()) {
                xCoord = -getFontMetrics(getFont()).stringWidth(name); // reset text off-screen
            }

            repaint(); // Request the applet to redraw

            try {
                Thread.sleep(100); // Pause animation
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    /**
     * Called to stop the thread when the applet is inactive.
     */
    public void stop() {
        if (animationThread != null) {
            animationThread.interrupt();
            animationThread = null;
        }
    }

    /**
     * Draws the text on the screen.
     */
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawString(name, xCoord, yCoord);
    }
}
