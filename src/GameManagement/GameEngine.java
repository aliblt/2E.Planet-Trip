package GameManagement;

import UserInterface.GameFrame;
import controller.InputManager;

import java.io.IOException;

public class GameEngine{

    ////////ATTRIBUTES////////
    private GameMapManager gameMapManager;
    private boolean paused;
    private int totalScore = 0;
    private InputManager inputManager;
    private boolean acquiredBonusLevel;
    private GameFrame gameFrame;
    private int counter;
    private StopWatch stopWatch;

    ////////CONSTRUCTOR////////
    public GameEngine(int level) throws IOException{
        paused = false;
        stopWatch = new StopWatch();
        counter = 0;
        gameMapManager = new GameMapManager(level);
        //inputManager = new InputManager( gameMapManager.getUserPaddle(), gameMapManager.getBalls().get(0) );
        gameFrame = new GameFrame( this );
        stopWatch.start();
        gameLoop();
    }

    ////////METHODS////////
    public void gameLoop(){
        boolean nextLevel = false;
        while( hasLive() ) {

            if( this.paused ) {
                try {
                    Thread.sleep(1000/100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }

            counter++;
            if( counter %5 == 0 ) {
                gameMapManager.destroyToBeDestroyed();
                counter = 0;
            }
            gameMapManager.updateBall();
            gameMapManager.updatePaddle();
            if( gameMapManager.getBalls().get(0).getySpeed() != 0 || gameMapManager.getBalls().get(0).getxSpeed() != 0 )
                gameMapManager.checkCollisions();
            //add repaint
            gameFrame.getGameCanvas().repaint();
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println("SA");

            if( levelPassed() ) {
                nextLevel = true;
                System.out.println("BITTI");
                break;
            }
        }
        this.stopWatch.pause();
        System.out.println(stopWatch.toString());
        if( nextLevel )
            skipNextLevel();
        else{
            System.out.println("GAME OVER");
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
        if (this.gameMapManager.getLevel() < 8) {
            try {
                int newLevel = gameMapManager.getLevel()+1;
                this.gameMapManager = new GameMapManager(newLevel);
                this.gameFrame = new GameFrame(this);
                gameLoop();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (this.gameMapManager.getLevel() == 8)
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
        System.out.println("GAME HAS ENDED");
    }

    public boolean isPaused() {
        return paused;
    }

    public int getTotalScore() {
        return totalScore + gameMapManager.getScore();
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public StopWatch getStopWatch() {
        return stopWatch;
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
