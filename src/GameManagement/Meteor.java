package GameManagement;

import java.io.IOException;

/**
 * @author Serdar Taskafa
 * Meteor class that extends the more general GameObject class
 */

public class Meteor extends GameObject{
    // Constructor
    public Meteor(float xPosition, float yPosition, String imagePath) throws IOException {
        super(xPosition, yPosition, 0, 0, imagePath);
    }
}
