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
	Image UndestructibleIm=t.getImage("images/RadioactiveMeteor.png"); //to be changed with undest
	Image paddleIm=t.getImage("images/paddle.png");
	Image ballIm=t.getImage("images/ball.png");
	Image lifeIm=t.getImage("images/life.png");
	Image backgroundIm = t.getImage("images/background.jpeg");

	private GameMapManager gameMapManager;

	public GameCanvas(GameMapManager gameMapManager ) {
	    this.gameMapManager = gameMapManager;
    }

	public void paint(Graphics g) {

		g.drawImage( backgroundIm, 0, 0, this);

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

		g.drawImage(paddleIm, (int) gameMapManager.getUserPaddle().getxPosition(), (int)gameMapManager.getUserPaddle().getyPosition(), this);
		g.drawImage(ballIm, (int)gameMapManager.getBalls().get(0).getxPosition(), (int)gameMapManager.getBalls().get(0).getyPosition(), this);

	}

}