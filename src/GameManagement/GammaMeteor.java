package GameManagement;

import java.io.IOException;

/**
 * @author Serdar Taskafa
 * This type of meteors are destroyed after three hits
 * Note: We may want to add hit count as a variable
 */
public class GammaMeteor extends DestructibleMeteor{
    // Constants
    public static int SCORE_GAMMA = 300;  // Score is set to 300 as default.

    // Constructor
    public GammaMeteor(float xPosition, float yPosition, String imagePath) throws IOException {
        super(xPosition, yPosition, imagePath);
    }
}
