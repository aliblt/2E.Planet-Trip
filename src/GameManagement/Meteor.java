package GameManagement;

import java.io.IOException;

/**
 * @author Serdar Taskafa
 * Meteor class that extends the more general GameObject class
 */

public abstract class Meteor extends GameObject{
    // Constructor
    protected int bonusNo;

    public Meteor(float xPosition, float yPosition, String imagePath) throws IOException {
        super(xPosition, yPosition, 0, 0, imagePath);
        this.bonusNo = -1;
    }

    public int getBonusNo() {
        return bonusNo;
    }

    public int setBonusNo( int num ) {
        return this.bonusNo = num;
    }

    public abstract int getScore();
}
