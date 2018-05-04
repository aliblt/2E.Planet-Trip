package UserInterface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.SwingUtilities;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;

public class CreditsPanel {
	
	private JButton returnMenuButton;
	
	public CreditsPanel(MenuActionListener listener)
	{
			/**
			 * Create the panel.
			 */
			public CreditsPanel() {
				setForeground(Color.WHITE);
				setBackground(Color.BLACK);
				setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
				
				Component verticalGlue = Box.createVerticalGlue();
				add(verticalGlue);
				
				JLabel creditsLabel = new JLabel("CREDITS");
				creditsLabel.setBackground(Color.BLACK);
				creditsLabel.setForeground(Color.WHITE);
				creditsLabel.setFont(new Font("Chiller", Font.BOLD, 59));
				creditsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
				add(creditsLabel);
				
				Component verticalGlue_1 = Box.createVerticalGlue();
				add(verticalGlue_1);
				
				JLabel creatorsLabel = new JLabel("Developers of PLANETTRIP");
				creatorsLabel.setFont(new Font("sasaas", Font.BOLD, 17));
				creatorsLabel.setForeground(Color.CYAN);
				creatorsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
				add(creatorsLabel);
				
				Component verticalGlue_5 = Box.createVerticalGlue();
				add(verticalGlue_5);
				
				JLabel aliLabel = new JLabel("Ali Bulut");
				aliLabel.setBackground(Color.BLACK);
				aliLabel.setForeground(Color.WHITE);
				aliLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
				add(aliLabel);
				
				JLabel aylinLabel = new JLabel("Aylin Cakal");
				aylinLabel.setBackground(Color.BLACK);
				aylinLabel.setForeground(Color.WHITE);
				aylinLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
				add(aylinLabel);
				
				JLabel atalayLabel = new JLabel("Serdar Atalay");
				atalayLabel.setBackground(Color.BLACK);
				atalayLabel.setForeground(Color.WHITE);
				atalayLabelsetAlignmentX(Component.CENTER_ALIGNMENT);
				add(atalayLabel);
				
				JLabel taskafaLabel = new JLabel("Serdar Taskafa");
				taskafaLabel.setBackground(Color.BLACK);
				taskafaLabel.setForeground(Color.WHITE);
				taskafaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
				add(taskafaLabel);
				
				Component verticalGlue_4 = Box.createVerticalGlue();
				add(verticalGlue_4);
				
				Component verticalGlue_3 = Box.createVerticalGlue();
				add(verticalGlue_3);
				
				returnMenuButton = new JButton("Return Menu");
				returnMenuButton.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent e) {
						JFrame mainFrame= (JFrame) SwingUtilities.getRoot(returnMenuButton.getParent());
						if(mainFrame.getName()=="MainMenu"){
							mainFrame.dispose();
						}
						else{
							CardLayout layout = (CardLayout)mainFrame.getContentPane().getLayout();
							layout.show(mainFrame.getContentPane(), "main");
							mainFrame.validate();
							mainFrame.setVisible(true);
						}
					}
				});
				
			
				returnMenuButton.setFont(new Font("SANS_SERIF", Font.BOLD, 15));
				returnMenuButton.setForeground(Color.WHITE);
				returnMenuButton.setContentAreaFilled(false);
				returnMenuButton.setBackground(Color.BLACK);
				returnMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
				add(returnMenuButton);
				
				Component verticalGlue_2 = Box.createVerticalGlue();
				add(verticalGlue_2);

			}

		}
	}
}