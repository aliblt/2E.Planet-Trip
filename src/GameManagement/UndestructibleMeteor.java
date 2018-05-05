package GameManagement;

import java.io.IOException;

/**
 * @author Serdar Taskafa
 * You simply cannot destroy this type of meteors by hitting.
 */
public class UndestructibleMeteor extends Meteor {
    // Constants
    // Widths and heights are uniform across the class and they are both set to be 20.
    private static final int SCORE_UNDESTRUCTIBLE = 500;
    public final int METEOR_U_SIZE_WIDTH = 20;
    public final int METEOR_U_SIZE_HEIGHT = 20;

    // Constructor
    public UndestructibleMeteor(float xPosition, float yPosition) throws IOException {
        super(xPosition, yPosition, "images/UndestructibleMeteor.jpg");
    }

    public int getScore() {
        return SCORE_UNDESTRUCTIBLE;
    }
}
