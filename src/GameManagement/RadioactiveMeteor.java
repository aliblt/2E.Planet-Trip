package GameManagement;

import java.io.IOException;

/**
 * @author Serdar Taskafa
 * This type of meteors destroy surrounding meteors if they get hit
 * Note: Image path can be added as a static constant
 */

public class RadioactiveMeteor extends DestructibleMeteor {
    // Constants
    public static int SCORE_RADIOACTIVE = 100;  // Score is set to 100 as default.

    // Constructor
    public RadioactiveMeteor(float xPosition, float yPosition) throws IOException {
        super(xPosition, yPosition, "images/RadioactiveMeteor.png");
    }
}
