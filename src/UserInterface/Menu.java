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

public class Menu extends JPanel{

    private MenuActionListener listener;
    private HowToPlayView howToPlayPanel;
    private CredirsView creditsPanel;
    private OptionsPanel optionsPanel;
    private ViewFrame viewFrame;
    private JPanel currentPanel;
    private ResultsView resultsPanel;
    private OptionsManager optionsManager;

    public static void main( String[] args ) {
        new Menu();


    }

    public Menu() {
        viewFrame = new ViewFrame(800, 600);
        currentPanel = new MainMenuPanel();

    }

    public void switchPanel( JPanel newPanel ){
        currentPanel = newPanel;
        viewFrame.setContentPane(currentPanel);
    }

    public void displayOptions() {
        viewFrame.setContentPane(optionsPanel);
    }

    public void displayCredits() {
        viewFrame.setContentPane(creditsPanel);
    }

    public void displayResults( int score, long elapsedTime ) {
        currentPanel = new ResultsView(score, elapsedTime);
    }

    public void displayLevels() {

    }

    public void initializeGame() {

    }
}
