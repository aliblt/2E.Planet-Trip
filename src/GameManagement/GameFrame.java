package GameManagement;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameFrame extends JFrame{

    private GameEngine gameEngine;
    private JPanel contentPanel;

    public GameFrame() throws IOException{
        gameEngine = new GameEngine();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(200, 200);
        contentPanel = new JPanel();


        setVisible(true);
    }

    public void displayContents() {

    }

    //for test purpose
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GameFrame frame = new GameFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
