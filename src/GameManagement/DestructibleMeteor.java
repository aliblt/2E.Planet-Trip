package GameManagement;

import java.io.IOException;

/**
 * @author Serdar Taskafa
 * General class for all destructible meteors
 */

public abstract class DestructibleMeteor extends Meteor{
    // Constants
    // Widths and heights are uniform across the class and they are both set to be 20.
    public final int METEOR_SIZE_WIDTH = 72;
    public final int METEOR_SIZE_HEIGHT = 30;

    // Constructor
    public DestructibleMeteor(float xPosition, float yPosition, String imagePath) throws IOException {
        super(xPosition, yPosition, imagePath);
    }

    public abstract int getScore();
}
