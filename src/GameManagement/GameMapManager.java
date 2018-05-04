package GameManagement;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

public class GameMapManager {

    private static final int SCREEN_WIDTH = 1440;
    private static final int SCREEN_HEIGTH = 900;

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
    //private ArrayList<Bonus> activeBonuses; //NEW!
    private BufferedImage backgroundImage;
    private GameEngine gameEngine;

    //first initialization of the level
    public GameMapManager( int level ) {//throws IOException{
        this.level = level;

        this.replaceMeteors();

        // initializing user paddle
        //userPaddle = new Paddle(30, 400, 20);
        // ToDo initialize all necessary elements of a map
    }

    public void updatePaddle() {

        userPaddle.setxPosition( userPaddle.getxPosition() + userPaddle.getxSpeed());
        userPaddle.setyPosition( userPaddle.getyPosition() + userPaddle.getySpeed());
    }

    public void updateBall() {
        for( Ball b: this.balls) {
            b.setxPosition(b.getxPosition() + b.getxSpeed());
            b.setyPosition(b.getyPosition() + b.getySpeed());
        }
    }

    //to destroy a meteor
    public void destroyMeteor( Meteor meteor ) {

        // iterate meteors via iterator loop
        for (  Meteor tmp : this.meteors ) {
            if( tmp == meteor ) {
                this.meteors.remove( meteors.indexOf(tmp) );
                break;
            }
        }
    }

    // to set new direction to ball
    public void reflectBall( Ball ball ) {

    }

    // checks all possible collisions
    public void checkCollisions() {

        // ball vs meteor
        for( Ball b : this.balls )
            for( Meteor m : this.meteors ) {
                if( checkMeteorBallCollision( m, b ) ) {

                }
            }

        // ball vs wall
        for( Ball b : this.balls ) {

        }

        // ball vs paddle
        for( Ball b : this.balls ) {
            checkPaddleBallCollision( userPaddle, b );

            if( enemyPaddle != null )
                checkPaddleBallCollision( enemyPaddle, b );
        }

        // paddle vs bonus
        for( Bonus b : this.activeBonuses ) {
            if ( checkPaddleBonusCollision( userPaddle, b ) ) {

            }
        }
    }

    // sets speed of a given Game Object
    public void setSpeed( GameObject gameObject, float speedX, float speedY ) {
        gameObject.setxSpeed(speedX);
        gameObject.setySpeed(speedY);
    }

    public void addLife( int life ) {
        this.noOfLives += life;
    }


    // This method replaces all meteors in current level
    public void replaceMeteors() {

        String filename,line;
        int lineNum = 0;

        filename = "./../../levels/level" + level + ".txt";

        Scanner fileIn = null;
        try {
            fileIn = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while( fileIn.hasNext() )
        {
            lineNum++;
            line = fileIn.nextLine();
            //System.out.println(line);
            try {
                for (int i = 0; i < line.length(); i++) {

                    //Alpha Meteor init
                    if (line.charAt(i) == 'A') {
                        Meteor m_tmp = new AlphaMeteor((i + 1) * SCREEN_WIDTH / 20, lineNum * 30, "./../../images/AlphaMeteor.jpg");
                        this.meteors.add(m_tmp);
                    }

                    //Beta Meteor init
                    else if (line.charAt(i) == 'B') {
                        Meteor m_tmp = new BetaMeteor((i + 1) * SCREEN_WIDTH / 20, lineNum * 30, "./../../images/BetaMeteor.jpg");
                        this.meteors.add(m_tmp);
                    }

                    //Gamma Meteor init
                    else if (line.charAt(i) == 'G') {
                        Meteor m_tmp = new GammaMeteor((i + 1) * SCREEN_WIDTH / 20, lineNum * 30, "./../../images/GammaMeteor.jpg");
                        this.meteors.add(m_tmp);
                    }

                    //Radiactive Meteor init
                    else if (line.charAt(i) == 'R') {
                        Meteor m_tmp = new RadioactiveMeteor((i + 1) * SCREEN_WIDTH / 20, lineNum * 30, "./../../images/RadioactiveMeteor.jpg");
                        this.meteors.add(m_tmp);
                    }

                    //Undestructable Meteor init
                    else if (line.charAt(i) == 'U') {
                        Meteor m_tmp = new UndestructibleMeteor((i + 1) * SCREEN_WIDTH / 20, lineNum * 30, "./../../images/UndestructibleMeteor.jpg");
                        this.meteors.add(m_tmp);
                    }
                }
            }
            catch ( IOException e ) {

            }
        }
        fileIn.close();
    }

    public void setNewPaddleSize( int newSize ) {
        userPaddle.setPaddleLength( newSize );
    }

    public void increaseBallSpeed( ) {

    }

    public void activateEnemyPaddle( ) {
        if ( enemyPaddle == null ) {
            try {
                enemyPaddle  = new Paddle( 5, 300, 5);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //display enemy paddle
        }
    }

    public void controlEnemyPaddle() {

    }

    public void activateGeglBonus() {

    }

    public void shoot( ) {

    }

    public int getLevel() {
        return level;
    }

}
