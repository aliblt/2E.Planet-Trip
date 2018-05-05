package GameManagement;

import UserInterface.GameCanvas;
import controller.InputManager;

import javax.swing.*;
import java.io.IOException;

public class GameEngine{

    ////////ATTRIBUTES////////
    private GameMapManager gameMapManager;
    private boolean paused;
    private static int totalScore = 0;
    private InputManager inputManager;
    private boolean acquiredBonusLevel;
    private GameFrame gameFrame;
    private int counter;

    ////////CONSTRUCTOR////////
    public GameEngine(int level) throws IOException{
        paused = false;
        counter = 0;
        gameMapManager = new GameMapManager(level);
        //inputManager = new InputManager( gameMapManager.getUserPaddle(), gameMapManager.getBalls().get(0) );
        gameFrame = new GameFrame( this );
        gameLoop();
    }

    ////////METHODS////////
    public void gameLoop(){
        while( hasLive() ) {
            counter++;
            if( counter %5 == 0 ) {
                gameMapManager.destroyToBeDestroyed();
                counter = 0;
            }
            gameMapManager.updateBall();
            gameMapManager.updatePaddle();
            gameMapManager.checkCollisions();
            //add repaint
            gameFrame.getGameCanvas().repaint();
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println("SA");

            if( levelPassed() )
                skipNextLevel();
        }
    }

    public boolean levelPassed(){
        return ( gameMapManager.getNoOfDestMeteors() == 0);
    }

    public boolean hasLive(){
       return 0 != gameMapManager.getNoOfLives();
    }

    public void skipNextLevel(){
        totalScore += gameMapManager.getScore();
        if (gameMapManager.getLevel() < 8) {
            try {
                gameMapManager = new GameMapManager(gameMapManager.getLevel() + 1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (gameMapManager.getLevel() == 8)
            endGame();
    }

    public void pauseGame(){
        paused = true;
    }

    public void resumeGame(){
        paused = false;
    }

    public void startGame(){

    }

    public void endGame(){

    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public GameMapManager getGameMapManager() {
        return gameMapManager;
    }

    public static void main(String args[] ) {
        try {
            new GameEngine( 1 );
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        GameEngine ge = null;
        try {
            ge = new GameEngine( 1 );
        } catch (IOException e) {
            e.printStackTrace();
        }
        JFrame f=new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //f.add(ge.getGameCanvas());
        f.setSize(1440,900);
        f.setVisible(true);
        */
    }
}
