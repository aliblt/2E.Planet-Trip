package GameManagement;

import java.io.IOException;

/**
 * @author Serdar Taskafa
 */
public class Ball extends GameObject{
    // Variables
    private float radius;
    private boolean isVisible;

    // Constructor
    public Ball(float xPosition, float yPosition, float xSpeed, float ySpeed, float radius) throws IOException {
        super(xPosition, yPosition, xSpeed, ySpeed, "images/ball.png");
        this.isVisible = true;
        this.radius = radius;
    }

    public float getRadius() {
        return this.radius;
    }

    public boolean isVisible() {
        return isVisible;
    }
}
