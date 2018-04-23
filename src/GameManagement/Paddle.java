package GameManagement;

import java.awt.image.BufferedImage;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Paddle extends GameObject{

    private int paddleLength;

    public Paddle(float xPosition, float yPosition, int length ) throws IOException {
        super(xPosition,yPosition,0,0, "images/paddle.png");
        this.paddleLength = length;
    }

    public void setPaddleLength(int length){
        this.paddleLength = length;
    }

    public int getPaddleLength() {
        return paddleLength;
    }
}
