/*
    @author: Ali Bulut
    Map logic
 */

package GameManagement;

import UserInterface.*;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class GameMapManager {

    private static final int SCREEN_WIDTH = 1440;
    private static final int SCREEN_HEIGTH = 900;

    private int level;
    private int noOfDestMeteors;
    private int noOfLives;
    private int score;
    private long elapsedTime;
    private long startTime;
    private Paddle userPaddle;
    private Paddle enemyPaddle;
    private ArrayList<Meteor> meteors;
    private ArrayList<Ball> balls;
    private ArrayList<Bonus> bonuses;
    private ArrayList<Bonus> activeBonuses; //NEW!
    private BufferedImage backgroundImage;
    private GameEngine gameEngine;
    private CollisionManager collisionManager;

    //first initialization of the level
    public GameMapManager( int level ) throws IOException{
        this.level = level;

        this.replaceMeteors();
        this.collisionManager = CollisionManager.getCollisionManager();

        // initializing user paddle
        userPaddle = new Paddle(700, 710, 20);
        balls = new ArrayList<Ball>();
        balls.add(new Ball(750, 679,0, 0, 3) );
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

        //score += meteor.getScore();
        if( meteor instanceof UndestructibleMeteor );
        else
            noOfDestMeteors--;

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
                if( collisionManager.checkMeteorBallCollision( m, b ) ) {

                }
            }

        // ball vs wall
        for( Ball b : this.balls ) {

        }

        // ball vs paddle
        for( Ball b : this.balls ) {
            collisionManager.checkPaddleBallCollision( userPaddle, b );

            if( enemyPaddle != null )
                collisionManager.checkPaddleBallCollision( enemyPaddle, b );
        }

        // paddle vs bonus
        for( Bonus b : this.activeBonuses ) {
            if ( collisionManager.checkPaddleBonusCollision( userPaddle, b ) ) {

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

    public ArrayList<Meteor> getMeteors() {
        return meteors;
    }

    public Paddle getUserPaddle() {
        return userPaddle;
    }

    public Paddle getEnemyPaddle() {
        return enemyPaddle;
    }

    public ArrayList<Ball> getBalls(){
        return balls;
    }

    public ArrayList<Bonus> getBonuses() {
        return bonuses;
    }

    public ArrayList<Bonus> getActiveBonuses() {
        return activeBonuses;
    }

    // This method replaces all meteors in current level
    public void replaceMeteors() {
        meteors = new ArrayList<Meteor>();
        String filename,line;
        int lineNum = 0;

        filename = "levels/level" + level + ".txt";

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
                        AlphaMeteor m_tmp = new AlphaMeteor((i + 1) * SCREEN_WIDTH / 20, (lineNum+1) * 30);
                        this.meteors.add(m_tmp);
                        noOfDestMeteors++;
                    }

                    //Beta Meteor init
                    else if (line.charAt(i) == 'B') {
                        BetaMeteor m_tmp = new BetaMeteor((i + 1) * SCREEN_WIDTH / 20, (lineNum+1) * 30);
                        this.meteors.add(m_tmp);
                        noOfDestMeteors++;
                    }

                    //Gamma Meteor init
                    else if (line.charAt(i) == 'G') {
                        GammaMeteor m_tmp = new GammaMeteor((i + 1) * SCREEN_WIDTH / 20, (lineNum+1) * 30);
                        this.meteors.add(m_tmp);
                        noOfDestMeteors++;
                    }

                    //Radiactive Meteor init
                    else if (line.charAt(i) == 'R') {
                        RadioactiveMeteor m_tmp = new RadioactiveMeteor((i + 1) * SCREEN_WIDTH / 20, (lineNum+1) * 30);
                        this.meteors.add(m_tmp);
                        noOfDestMeteors++;
                    }

                    //Undestructable Meteor init
                    else if (line.charAt(i) == 'U') {
                        UndestructibleMeteor m_tmp = new UndestructibleMeteor((i + 1) * SCREEN_WIDTH / 20, (lineNum+1) * 30);
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
        if( enemyPaddle != null ) {
            if( balls.get(0).getxPosition() > enemyPaddle.getxPosition() );

        }
    }

    public void activateGeglBonus() {

    }

    public void shoot( ) {

    }

    public int getLevel() {
        return level;
    }

    public int getNoOfDestMeteors() {
        return noOfDestMeteors;
    }

    public static void main( String args[] ) throws IOException {

        JLabel background = new JLabel("image/planet.jpg");
        GameMapManager gmm = new GameMapManager( 1 );
        GameCanvas m = new GameCanvas( gmm );
        JFrame f=new JFrame();

        //f.setContentPane(background);
        f.add(m);
        f.setSize(1440,900);
        f.setVisible(true);
    }
}
