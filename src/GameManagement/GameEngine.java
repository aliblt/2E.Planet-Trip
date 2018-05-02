package GameManagement;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class GameEngine extends GameFrame{


    ////////ATTRIBUTES////////

    private GameMapManager gameMapManager;

    private boolean paused;

    private FileManager fileManager;

    private GameMapManager gameMapManager;

    private boolean acquiredBonusLevel;


    ////////CONSTRUCTOR////////

    public GameEngine(int level) throws IOException{
        paused = false;
        gameMapManager = new GameMapManager(level);

    }


    ////////METHODS////////

    public void gameLoop(){}

    public boolean levelPassed(){}

    public boolean hasLive(){}

    public void skipNextLevel(){}

    public void pauseGame(){}

    public void resumeGame(){}

    public void startGame(){}

    public void endGame(){}

    public BufferedImage getImage(){}

/*    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode==KeyEvent.VK_W || keyCode==KeyEvent.VK_UP)
            K_UP = true;

        if(keyCode==KeyEvent.VK_A || keyCode==KeyEvent.VK_LEFT)
            K_LEFT = true;

        if(keyCode==KeyEvent.VK_D || keyCode==KeyEvent.VK_RIGHT)
            K_RIGHT = true;

        if(keyCode==KeyEvent.VK_S || keyCode==KeyEvent.VK_DOWN)
            K_DOWN = true;

        //if(keyCode==KeyEvent.VK_SPACE)
        //K_SPACE = true;
        if(keyCode==KeyEvent.VK_SPACE)
            spaceGame.getLevel().spacePressed();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode==KeyEvent.VK_W || keyCode==KeyEvent.VK_UP)
            K_UP = false;

        if(keyCode==KeyEvent.VK_A || keyCode==KeyEvent.VK_LEFT)
            K_LEFT = false;

        if(keyCode==KeyEvent.VK_D || keyCode==KeyEvent.VK_RIGHT)
            K_RIGHT = false;

        if(keyCode==KeyEvent.VK_S || keyCode==KeyEvent.VK_DOWN)
            K_DOWN = false;

        if(keyCode==KeyEvent.VK_SPACE)
            K_SPACE = false;
    }*/
}
