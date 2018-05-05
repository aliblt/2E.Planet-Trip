package UserInterface;
import GameManagement.*;

import java.awt.*;
import javax.swing.*;

public class GameCanvas extends Canvas {
	Toolkit t=Toolkit.getDefaultToolkit();

	Image alphaIm=t.getImage("images/AlphaMeteor.png");
	Image BetaIm=t.getImage("images/BetaMeteor.png");
	Image GammaIm=t.getImage("images/GammaMeteor.png");
	Image RadioactiveIm=t.getImage("images/RadioactiveMeteor.png");
	Image UndestructibleIm=t.getImage("images/UndestructibleMeteor.png");
	Image paddleIm=t.getImage("images/paddle.png");
	Image ballIm=t.getImage("images/ball.png");
	Image lifeIm=t.getImage("images/life.png");
	Image backgroundIm = t.getImage("images/background.jpeg");

	private GameMapManager gameMapManager;
	private GameEngine gameEngine;
	private int counter = 0;

	public GameCanvas(GameEngine gameEngine ) {
	    this.gameEngine = gameEngine;
	    this.gameMapManager = gameEngine.getGameMapManager();
    }

	private void createRepaintTimer(final JFrame frame) {
		final Timer timer = new Timer(15, null);

		timer.addActionListener(e -> {
			if (!frame.isVisible()) {
				timer.stop();
			} else {
				frame.repaint();
			}
		});

		timer.start();
	}

    @Override
	public void paint(Graphics g) {

		g.drawImage( backgroundIm, 0, 0, this);

		counter ++;
		//g.drawImage( RadioactiveIm, 20*counter+10, 20, this );

		for (Meteor m : gameMapManager.getMeteors() ) {

			Image i;
			if (m instanceof AlphaMeteor)
				i = alphaIm;
			else if (m instanceof BetaMeteor)
				i = BetaIm;
			else if (m instanceof GammaMeteor)
				i = GammaIm;
			else if (m instanceof RadioactiveMeteor)
				i = RadioactiveIm;
			else
				i = UndestructibleIm;

			g.drawImage(i, (int) m.getxPosition(), (int) m.getyPosition(), this);
		}

		int remaining = gameMapManager.getNoOfLives();
		for( int i=0 ; i<remaining && i<5 ; i++ )
			g.drawImage(lifeIm, 1400-i*50, 15, this);

		g.drawImage(paddleIm, (int) gameMapManager.getUserPaddle().getxPosition(), (int)gameMapManager.getUserPaddle().getyPosition(), this);
		g.drawImage(ballIm, (int)gameMapManager.getBalls().get(0).getxPosition()-13, (int)gameMapManager.getBalls().get(0).getyPosition()-13, this);
        g.drawString( gameEngine.getStopWatch().toString(), 100, 20);
	}

}