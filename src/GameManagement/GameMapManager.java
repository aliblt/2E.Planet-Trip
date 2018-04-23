package GameManagement;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class GameMapManager {

    private int level;
    private int noOfLives;
    private int score;
    private long elapsedTime;
    private long startTime;
    private Paddle userPaddle;
    private Paddle enemyPaddle;
    private ArrayList<Meteor> meteors;
    private ArrayList<Ball> balls;
    //private ArrayList<Bonus> bonuses;
    private BufferedImage backgroundImage;
    private GameEngine gameEngine;

    //first initialization of the level
    public GameMapManager( int level ) throws IOException{
        this.level = level;
        userPaddle = new Paddle(30, 400, 5);
        // ToDo initialize all necessary elements of a map
    }

    public void updatePaddle() {

    }

    public void updateBall() {

    }

    //to destroy a meteor
    public void destroyMeteor( Meteor meteor ) {

    }

    // to set new direction to ball
    public void reflectBall( Ball ball ) {

    }

    // checks all possible collisions
    public void checkCollisions() {

    }

    // sets speed of a given Game Object
    public void setSpeed( GameObject gameObject, float speedX, float speedY ) {
        gameObject.setxSpeed(speedX);
        gameObject.setySpeed(speedY);
    }

    public void addLife( int life ) {
        this.noOfLives += life;
    }

    public void replaceMeteors() {

    }

    public void setNewPaddleSize( int newSize ) {
        userPaddle.setPaddleLength( newSize );
    }

    public void increaseBallSpeed( ) {

    }

    public void activateEnemyPaddle( ) {

    }

    public void controlEnemyPaddle() {

    }

    public void activateGeglBonus() {

    }

    public void shoot( ) {

    }

}
