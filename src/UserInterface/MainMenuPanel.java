package UserInterface;
import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.plaf.basic.BasicSliderUI;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javafx.scene.paint.Color;

public class MainMenuPanel extends JPanel implements ActionListener {

    public MainMenuPanel (MouseListener listener)()
    {
        setLayout(null);
        setBackground(java.awt.Color.BLACK);
        private JButton playButton = new JButton("Play");
        private JButton howToPlayButton = new JButton("How to Play");
        private JButton creditsButton = new JButton("Credits");
        private JButton optionsButton = new JButton("Options");
        private JButton exitButton = new JButton("Exit");

        add (playButton);
        add (optionsButton);
        add (howToPlayButton);
        add (creditsButton);
        add (exitButton);

    }

}
