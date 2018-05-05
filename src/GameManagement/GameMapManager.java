/*
    @author: Ali Bulut
    Map logic
 */

package GameManagement;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

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
    private ArrayList<Meteor> toBeDestructed;
    private ArrayList<Ball> balls;
    private ArrayList<Bonus> bonuses;
    private ArrayList<Bonus> activeBonuses; //NEW!
    private BufferedImage backgroundImage;
    private GameEngine gameEngine;
    //private CollisionManager collisionManager;

    //first initialization of the level
    public GameMapManager( int level ) throws IOException {
        this.level = level;
        this.noOfLives = 3;
        this.score = 0;
        this.elapsedTime = 0;
        this.activeBonuses = new ArrayList<Bonus>();
        this.bonuses = new ArrayList<Bonus>();
        this.toBeDestructed = new ArrayList<Meteor>();
        startTime = System.currentTimeMillis();

        this.replaceMeteors();

        bonuses = new ArrayList<Bonus>();
        activeBonuses = new ArrayList<Bonus>();
        for (int i = 0; i < 10; i++) {
            this.meteors.get(randomFill(this.meteors.size())).setBonusNo(randomFill(6));
        }

        // initializing user paddle
        userPaddle = new Paddle(700, 722, 200);
        balls = new ArrayList<Ball>();
        balls.add(new Ball(770, 707, 0, 0, 13));
    }

    public int randomFill( int k ){
        Random rand = new Random();
        int randomNum = Math.abs(rand.nextInt())%(k);
        return randomNum;
    }

    public void updatePaddle() {
        if( userPaddle.getxPosition()+userPaddle.getxSpeed() >= 0 &&  userPaddle.getxPosition()+userPaddle.getxSpeed() <= 1440-userPaddle.getPaddleLength() )
            userPaddle.setxPosition( userPaddle.getxPosition() + userPaddle.getxSpeed());
        //userPaddle.setyPosition( userPaddle.getyPosition() + userPaddle.getySpeed());
    }

    public void updateBall() {
        for( Ball b: this.balls) {
            b.setxPosition(b.getxPosition() + b.getxSpeed());
            b.setyPosition(b.getyPosition() + b.getySpeed());
        }
    }

    private void findMeteorAt( float posX, float posY ) {
        for( Meteor m: this.meteors )
            if( m.getxPosition() == posX && m.getyPosition() == posY ) {
                toBeDestructed.add(m);
                break;
            }
    }

    public void destroyToBeDestroyed() {
        while( !toBeDestructed.isEmpty() ) {
            destroyMeteor( toBeDestructed.get(0) );
            toBeDestructed.remove( toBeDestructed.get(0) );
        }
    }

    //to destroy a meteor
    public void destroyMeteor( Meteor meteor ) {

        if( this.meteors.indexOf(meteor) < 0 )
            return;

        score += meteor.getScore();
        //System.out.println(score);
        if( meteor instanceof UndestructibleMeteor )
            return;

        noOfDestMeteors--;
        //System.out.println(noOfDestMeteors);
        // iterate meteors via iterator loop

        this.meteors.remove( meteor );

        if( meteor instanceof RadioactiveMeteor ) {
            findMeteorAt( meteor.getxPosition()+72, meteor.getyPosition() ); //sag
            findMeteorAt( meteor.getxPosition()-72, meteor.getyPosition() ); //sol
            findMeteorAt( meteor.getxPosition(), meteor.getyPosition()+30 ); //alt
            findMeteorAt( meteor.getxPosition(), meteor.getyPosition()-30 ); //ust
            findMeteorAt( meteor.getxPosition()+72, meteor.getyPosition()+30 ); //sagalt
            findMeteorAt( meteor.getxPosition()+72, meteor.getyPosition()-30 ); //sagust
            findMeteorAt( meteor.getxPosition()-72, meteor.getyPosition()+30 ); //solalt
            findMeteorAt( meteor.getxPosition()-72, meteor.getyPosition()-30 ); //solust
        }

    }

    public void lifeLost() {
        noOfLives--;
        Ball b = balls.get(0);
        b.setxPosition(770);
        b.setyPosition(707);
        b.setxSpeed(0);
        b.setySpeed(0);
        userPaddle.setxPosition(700);
        userPaddle.setyPosition(722);
    }

    // checks all possible collisions
    public void checkCollisions() {
        // ball vs meteor
        for( Ball b : this.balls )
            for( Meteor m : this.meteors ) {
                if( CollisionManager.getCollisionManager().checkMeteorBallCollision( m, b ) ) {
                    //System.out.println("CARPTIM XD");
                    destroyMeteor(m);
                    break;
                }
            }

        // ball vs wall
        for( Ball b : this.balls ) {
            if (CollisionManager.getCollisionManager().checkBallWallCollision(b, 1440, 900) ) {
                lifeLost();
            }
        }

        // ball vs paddle
        for( Ball b : this.balls ) {
            if( CollisionManager.getCollisionManager().checkPaddleBallCollision( userPaddle, b ) ){
                double k = b.getxSpeed()*b.getxSpeed() + b.getySpeed()*b.getySpeed();
                double deltaX = userPaddle.getxPosition() + 100 - b.getxPosition();
                double deltaY = userPaddle.getyPosition() + 12.5 - b.getyPosition();
                k = Math.sqrt(k);
                k /= Math.sqrt( Math.pow( deltaX, 2)+ Math.pow( deltaY, 2));
                k *= -1;
                b.setxSpeed((float) (deltaX*k));
                b.setySpeed((float) (deltaY*k));
            }

            if( enemyPaddle != null )
                CollisionManager.getCollisionManager().checkPaddleBallCollision( enemyPaddle, b );
        }

        // paddle vs bonus
        for( Bonus b : this.activeBonuses ) {
            if ( CollisionManager.getCollisionManager().checkPaddleBonusCollision( userPaddle, b ) ) {

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

    public int getNoOfLives() {
        return noOfLives;
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
                        AlphaMeteor m_tmp = new AlphaMeteor(i* SCREEN_WIDTH / 20, (lineNum+1) * 30);
                        this.meteors.add(m_tmp);
                        noOfDestMeteors++;
                    }

                    //Beta Meteor init
                    else if (line.charAt(i) == 'B') {
                        BetaMeteor m_tmp = new BetaMeteor(i * SCREEN_WIDTH / 20, (lineNum+1) * 30);
                        this.meteors.add(m_tmp);
                        noOfDestMeteors++;
                    }

                    //Gamma Meteor init
                    else if (line.charAt(i) == 'G') {
                        GammaMeteor m_tmp = new GammaMeteor(i * SCREEN_WIDTH / 20, (lineNum+1) * 30);
                        this.meteors.add(m_tmp);
                        noOfDestMeteors++;
                    }

                    //Radiactive Meteor init
                    else if (line.charAt(i) == 'R') {
                        RadioactiveMeteor m_tmp = new RadioactiveMeteor(i * SCREEN_WIDTH / 20, (lineNum+1) * 30);
                        this.meteors.add(m_tmp);
                        noOfDestMeteors++;
                    }

                    //Undestructable Meteor init
                    else if (line.charAt(i) == 'U') {
                        UndestructibleMeteor m_tmp = new UndestructibleMeteor(i * SCREEN_WIDTH / 20, (lineNum+1) * 30);
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
        balls.get(0).setxSpeed((float) (balls.get(0).getxSpeed() * 1.5));
        balls.get(0).setySpeed((float) (balls.get(0).getySpeed() * 1.5));
    }

    public void activateEnemyPaddle( ) {
        if ( enemyPaddle == null ) {
            try {
                enemyPaddle  = new Paddle( 700, 20, 100);
            } catch (IOException e) {
                e.printStackTrace();
            }
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

    public int getScore() {
        return score;
    }

    public int getLevel() {
        return level;
    }

    public int getNoOfDestMeteors() {
        return noOfDestMeteors;
    }
    /*
    public static void main( String args[] ) throws IOException {

        JLabel background = new JLabel("image/planet.jpg");
        GameMapManager gmm = new GameMapManager( 2 );
        GameCanvas m = new GameCanvas( gmm );
        JFrame f=new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //f.setContentPane(background);
        f.add(m);
        f.setSize(1440,900);
        f.setVisible(true);
    }
    */
}
