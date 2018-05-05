package controller;

import GameManagement.Ball;
import GameManagement.GameEngine;
import GameManagement.Paddle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class InputManager implements KeyListener {

    private GameEngine gameEngine;
    private Paddle userPaddle;
    private Ball ball;
    private boolean fl;
    private boolean isStarted;

    public InputManager(GameEngine gameEngine) {
        fl = false;
        this.isStarted = false;
        this.gameEngine = gameEngine;
        this.userPaddle = gameEngine.getGameMapManager().getUserPaddle();
        this.ball = gameEngine.getGameMapManager().getBalls().get(0);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("SA");
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if( !isStarted ) {
                    ball.setxSpeed(-7);
                    ball.setySpeed(0);
                }
                userPaddle.setxSpeed( -7 );
                fl = true;
                //System.out.println("LEFT");
                break;
            case KeyEvent.VK_RIGHT:
                if( !isStarted ) {
                    ball.setxSpeed(7);
                    ball.setySpeed(0);
                }
                userPaddle.setxSpeed( 7 );
                //System.out.println("RIGHT");
                fl = true;
                break;
            case KeyEvent.VK_SPACE:
                if( !isStarted ) {
                    ball.setxSpeed(3);
                    ball.setySpeed(-4);
                    isStarted = true;
                }
                break;
            case KeyEvent.VK_P:
                if( gameEngine.isPaused() ) {
                    gameEngine.getStopWatch().resume();
                    gameEngine.resumeGame();
                }
                else {
                    gameEngine.getStopWatch().pause();
                    gameEngine.pauseGame();
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("AS");
        if( fl ) {
            if( !isStarted ) {
                ball.setxSpeed(0);
                ball.setySpeed(0);
            }
            fl = false;
            userPaddle.setxSpeed(0);
        }
    }

}