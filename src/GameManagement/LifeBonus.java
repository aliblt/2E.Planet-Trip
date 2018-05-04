package GameManagement;

import java.io.IOException;

/**
 * @author Serdar Taskafa
 */
public class LifeBonus extends Bonus {
    // Variable
    private int healthValue;

    // Constructor
    public LifeBonus(float xPosition, float yPosition, int health_value) throws IOException {
        super(xPosition, yPosition, "images/bonus.png");
        this.healthValue = health_value;
    }

    // Method
    public int getHealthValue() {
        return this.healthValue;
    }
}
