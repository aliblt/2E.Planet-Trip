package GameManagement;

import UserInterface.GameCanvas;
import controller.InputManager;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame{

    private GameEngine gameEngine;
    private Canvas gameCanvas;
    private JPanel contentPanel;
    private JFrame gameFrame;
    private ImageIcon[] objectImages;
    private JLabel[] objectLabels;

    public GameFrame( GameEngine gameEngine ) {

        JLabel background = new JLabel("image/planet.jpg");
        this.gameEngine = gameEngine;
        gameCanvas = new GameCanvas( this.gameEngine.getGameMapManager() );

        gameFrame=new JFrame();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameFrame.add(this.gameCanvas);
        gameFrame.setSize(1440,900);
        gameFrame.setVisible(true);
        gameFrame.addKeyListener( new InputManager( gameEngine.getGameMapManager().getUserPaddle(), gameEngine.getGameMapManager().getBalls().get(0)));
    }

    public JFrame getGameFrame() {
        return gameFrame;
    }

    public Canvas getGameCanvas() {
        return gameCanvas;
    }
}
