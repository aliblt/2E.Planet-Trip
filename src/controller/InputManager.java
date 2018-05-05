package controller;

import GameManagement.Ball;
import GameManagement.Paddle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class InputManager implements KeyListener {

    private Paddle userPaddle;
    private Ball ball;
    private boolean fl;

    public InputManager( Paddle paddle, Ball ball ) {
        fl = false;
        this.userPaddle = paddle;
        this.ball = ball;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("SA");
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                userPaddle.setxSpeed( -7 );
                fl = true;
                //System.out.println("LEFT");
                break;
            case KeyEvent.VK_RIGHT:
                userPaddle.setxSpeed( 7 );
                //System.out.println("RIGHT");
                fl = true;
                break;
            case KeyEvent.VK_SPACE:
                ball.setxSpeed(3);
                ball.setySpeed(-4);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("AS");
        if( fl ) {
            fl = false;
            userPaddle.setxSpeed(0);
        }
    }

}