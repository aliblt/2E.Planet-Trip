package GameManagement;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Serdar Taskafa
 * The general class for all types of game objects
 */

public class GameObject {
    // Variables
    private float xPosition;
    private float yPosition;
    private float xSpeed;
    private float ySpeed;
    private BufferedImage objectImages;

    // Constructor
    public GameObject(float xPosition, float yPosition, float xSpeed, float ySpeed, String imagePath ) throws IOException {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.objectImages = ImageIO.read(new File(imagePath));
    }

    // Methods
    public void setxPosition(float xPosition){
        this.xPosition = xPosition;
    }

    public void setyPosition(float yPosition){
        this.yPosition = yPosition;
    }

    public void updateObjects(float xSpeed, float ySpeed) {
        xPosition += xSpeed;
        yPosition += ySpeed;
    }

    public void setxSpeed(float xSpeed){
        this.xSpeed = xSpeed;
    }

    public void setySpeed(float ySpeed){
        this.ySpeed = ySpeed;
    }

    public float getxPosition(){
        return xPosition;
    }

    public float getyPosition(){
        return yPosition;
    }

    public float getxSpeed(){
        return xSpeed;
    }

    public float getySpeed(){
        return ySpeed;
    }

    public BufferedImage getObjectImages() {
        return objectImages;
    }

    public void draw(Graphics g, float xPosition, float yPosition) {
        g.drawImage(objectImages, (int) xPosition, (int) yPosition, null);
    }
}
