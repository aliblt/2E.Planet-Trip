package GameManagement;

import java.io.IOException;

/**
 * @author Serdar Taskafa
 */
public class PaddleLengthBonus extends Bonus {
    // Variable
    private int paddle_length = 10;

    // Constructor
    public PaddleLengthBonus(float xPosition, float yPosition, String imagePath, int paddle_length) throws IOException {
        super(xPosition, yPosition, "images/bonus.png");
        this.paddle_length = paddle_length;
    }

    // Method
    public int getPaddle_length() {
        return this.paddle_length;
    }
}
