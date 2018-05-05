package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InputManager implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                //move the paddle left
                break;
            case KeyEvent.VK_RIGHT:
                //move the paddle right
                break;
            case KeyEvent.VK_SPACE:
                //throw ball in the beginning
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}