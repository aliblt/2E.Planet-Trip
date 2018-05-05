/**
 * @Author: Aylin �akal
 * Date:    23/03/18
 * Class: OptionsPanel
 * */
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


public class OptionsPanel extends JPanel implements ActionListener
{
  private Image background;
  private JButton returnMenuButton;
  private JButton applyButton;
  private JButton unmuteButton;
  private int soundEffect;
  private JSlider adjustingVolumeButton;
  private CardLayout cardLayout;
  private JPanel mainPanel;
  
  //Create the panel...
  public OptionsPanel(JPanel mainP, CardLayout cardL){
    
    mainPanel = mainP;
    cardLayout=cardL;
    
    //For Volume Slider
    adjustingVolumeButton = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
    adjustingVolumeButton.setMajorTickSpacing(10); //max value of volume
    adjustingVolumeButton.setMinorTickSpacing(1); //min value of volume
    adjustingVolumeButton.setPaintTicks(true);
    adjustingVolumeButton.setPaintLabels(true);
    adjustingVolumeButton.setAlignmentX(Component.LEFT_ALIGNMENT);
    final Label sliderCaption = new Label("Sound Effects:");
    
    final Label soundValue = new Label(
                                       Double.toString(adjustingVolumeButton.getValue()));
    //final static Color textColor = Color.WHITE;
    
    add(adjustingVolumeButton);
    adjustingVolumeButton.setBounds(230, 216, 330, 56);
    
    adjustingVolumeButton.setOpaque(false);
    adjustingVolumeButton.setFocusable(false);
    
    //Listener for Slider
    //SliderListener sliderListener = new SliderListener();
    //adjustingVolumeButton.addChangeListener(sliderListener);
    
    setBounds(0, 0, 600, 800);
    
    setLayout(null);
    setVisible(true);
  }
  
  public void paintComponent(Graphics g){
  g.drawImage(new ImageIcon("planetTrip/images/optionsImage.jpg").getImage(), 0, 0, getWidth(), getHeight(), this);
 }
  
  public int getSoundLevel(){
    return soundEffect;
 }

  @Override
  public void actionPerformed(ActionEvent e) {

  }
}