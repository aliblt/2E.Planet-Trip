package GameManagement;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameFrame extends JFrame{

    private GameEngine gameEngine;
    private JPanel contentPanel;
    private JFrame frame;
    private ImageIcon[] objectImages;
    private JLabel[] objectLabels;

    public GameFrame() throws IOException{
        frame = new JFrame("Planet Trip");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);

        //gameEngine = new GameEngine();
        frame.setLayout(null);
        objectImages = new ImageIcon[10];
        objectLabels = new JLabel[10];
        objectImages[1] = new ImageIcon("images/paddle.png");
        objectLabels[1] = new JLabel(objectImages[1]);
        objectLabels[1].setLocation(640,600);
        objectLabels[1].setSize(180,25);

        objectImages[0] = new ImageIcon("images/planet.png");
        objectLabels[0] = new JLabel(objectImages[0], JLabel.CENTER);
        objectLabels[0].setLocation(2,2);
        objectLabels[0].setSize(1000,710);

        frame.add(objectLabels[1]);
        frame.add(objectLabels[0]);

        frame.setVisible(true);
    }

    public void displayContents() {

    }

    //for test purpose
    public static void main(String[] args) {
        //EventQueue.invokeLater(new Runnable() {
            //public void run() {
                try {
                    new GameFrame();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            //}
        //});
    }
}
