package GameManagement;

import java.io.IOException;

public class GameEngine {

    private GameMapManager gameMapManager;
    private boolean isPaused;

    public GameEngine() throws IOException{
        isPaused = false;
        gameMapManager = new GameMapManager();
    }
}
