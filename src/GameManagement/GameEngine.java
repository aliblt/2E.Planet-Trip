package GameManagement;

import javax.swing.*;
import java.io.IOException;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class GameEngine extends GameFrame{


    ////////ATTRIBUTES////////

    private GameMapManager gameMapManager;

    private boolean paused;

    //private FileManager fileManager;

    private boolean acquiredBonusLevel;


    ////////CONSTRUCTOR////////

    public GameEngine(int level) throws IOException{
        paused = false;
        gameMapManager = new GameMapManager(level);

    }


    ////////METHODS////////

    public void gameLoop(){

    }
    /*
    public boolean levelPassed(){
        return (getNoOfDestMeteors() == 0);
    }

    public boolean hasLive(){
       return (0 != getHealthValue());
    }

    public void skipNextLevel(){
        if (gameMapManager.getLevel() < 7)
            gameMapManager = new GameMapManager(gameMapManager.getLevel() + 1);
        else if (gameMapManager.getLevel() == 7)
            endGame();
    }

    public void pauseGame(){
        paused = true;
    }

    public void resumeGame(){
        paused = false;
    }

    public void startGame(){}

    public void endGame(){}

    public BufferedImage getImage(){}
    */
}
