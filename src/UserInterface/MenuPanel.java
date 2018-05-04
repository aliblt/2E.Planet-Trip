package update2;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;

public class MenuPanel extends JPanel implements ActionListener {

	/**
	 * Create the panel.
	 */
	private MainFrame frame;
	private JButton btnExit;
	private JButton btnStartGame;
	private JButton btnHow;
	private JButton btnOptions;
	private JButton btnCredits;
	
	public MenuPanel(MainFrame frame) {
		this.frame = frame;
		setSize(1280,720);
		//setSize(704,540);
		setLayout(null);
		
		btnStartGame = new JButton("PLAY GAME");
		btnStartGame.setBounds(244, 100, 204, 80);
		add(btnStartGame);
		btnStartGame.addActionListener(this);
		
		btnHow = new JButton("HOW TO PLAY");
		//btnHow.setForeground(Color.WHITE);
		btnHow.setBounds(244, 200, 204, 80);
		//btnHow.setOpaque(false);
		//btnHow.setContentAreaFilled(false);
		//btnHow.setBorderPainted(false);
		add(btnHow);
		
		btnOptions = new JButton("OPTIONS");
		btnOptions.setBounds(244, 300, 204, 80);
		add(btnOptions);
		
		btnCredits = new JButton("CREDITS");
		btnCredits.setBounds(244, 400, 204, 80);
		add(btnCredits);
		
		btnExit = new JButton("EXIT");
		btnExit.setBounds(244, 500, 204, 80);
		add(btnExit);
		btnExit.addActionListener(this);
		
		
	}
	public void paintComponent(Graphics g){
		g.drawImage(new ImageIcon("src/update2/sources/main_menu.jpg").getImage(), 0, 0, getWidth(), getHeight(), this);
	}
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == btnExit){
			System.exit(0);
		}
		
		if(e.getSource() == btnStartGame){
			setVisible(false);
			
			//GamePanel gamePanel;
			
			//try {
				//PathPanel pathPanel =new PathPanel();
				//gamePanel = new GamePanel(1,frame,pathPanel);
				//gamePanel.setBounds(6, 6, 506, 506);
				
				//frame.contentPane.add(gamePanel);
				//ButtonPanel butonPanel = new ButtonPanel(gamePanel);
				//butonPanel.setBounds(510, 6, 106, 506);
				//frame.contentPane.add(butonPanel);
				
				//pathPanel.setBounds(617, 6, 86, 481);
				//frame.contentPane.add(pathPanel);
				//pathPanel.setPath(gamePanel.pathList);
			//} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
			//	e1.printStackTrace();
			}
		
			frame.repaint();
	}
}
			

