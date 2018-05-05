package GameManagement;

import java.io.IOException;

/**
 * @author Serdar Taskafa
 */
public class EnemyBonus extends Bonus {
    public EnemyBonus(float xPosition, float yPosition) throws IOException {
        super(xPosition, yPosition, "images/bonus.png");
    }
}
