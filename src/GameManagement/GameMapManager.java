package GameManagement;

import java.io.IOException;

public class GameMapManager {

    private int level;
    private int noOfLives;
    private int score;
    private long elapsedTime;
    private long startTime;
    private Paddle userPaddle;

    public GameMapManager() throws IOException{
        userPaddle = new Paddle(30, 400, 5);
    }
}
