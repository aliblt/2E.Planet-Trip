package GameManagement;

import java.io.IOException;

/**
 * @author Serdar Taskafa
 * Laser that will be used to hit meteors
 */

public class Laser extends GameObject{
    public Laser(float xPosition, float yPosition, float xSpeed) throws IOException {
        super(xPosition, yPosition, xSpeed,0, "images/laser.png");
    }
}
