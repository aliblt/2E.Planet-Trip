package GameManagement;

import java.io.IOException;

public class Meteor extends GameObject{
    public Meteor(float xPosition, float yPosition, float xSpeed, float ySpeed, String imagePath) throws IOException {
        super(xPosition, yPosition, xSpeed, ySpeed, imagePath);
    }
}
