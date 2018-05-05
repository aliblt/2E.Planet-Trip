package GameManagement;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameObject {
    private float xPosition;
    private float yPosition;
    private float xSpeed;
    private float ySpeed;
    private BufferedImage objectImages;
    private String imagePath;

    public GameObject(float xPosition, float yPosition, float xSpeed, float ySpeed, String imagePath ) throws IOException {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.imagePath = imagePath;
        //this.objectImages = ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/paddle.png"));
        //this.objectImages = ImageIO.read(new File("images/paddle.png" ));
    }

    public void setxPosition(float xPosition){
        this.xPosition = xPosition;
    }

    public void setyPosition(float yPosition){
        this.yPosition = yPosition;
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

    public String getImagePath() {
        return this.imagePath;
    }

    public BufferedImage getObjectImages() {
        return objectImages;
    }
}
