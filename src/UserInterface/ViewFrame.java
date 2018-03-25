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

public class ViewFrame extends JFrame {

    private int screen_width;
    private int screen_height;
    private JFrame frame;

    public ViewFrame( int screenWidth, int screenHeight ) {
        frame = new JFrame("Planet Trip");
        this.screen_height = screenHeight;
        this.screen_width = screenWidth;
        frame.setSize( screen_width, screen_height );
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
