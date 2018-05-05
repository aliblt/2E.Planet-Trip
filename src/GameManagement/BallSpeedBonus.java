package GameManagement;

import java.io.IOException;

/**
 * @author Serdar Taskafa
 */
public class BallSpeedBonus extends Bonus {
    // Variable
    private int ballSpeed;

    // Constructor
    public BallSpeedBonus(float xPosition, float yPosition, int ballSpeed) throws IOException {
        super(xPosition, yPosition, "images/bonus.png");
        this.ballSpeed = ballSpeed;
    }

    // Method
    public int getBallSpeed() {
        return this.ballSpeed;
    }
}
