package GameManagement;

import java.io.IOException;

/**
 * @author Serdar Taskafa
 * A general Bonus class, specific types will extend from here
 */
public class Bonus extends GameObject {
    // Variable
    public static final int SCORE = 100;   // Player will gain 100 points if they hit a bonus object

    // Constructor
    public Bonus(float xPosition, float yPosition, String imagePath) throws IOException {
        super(xPosition, yPosition, 0, 0, imagePath);
    }
}
