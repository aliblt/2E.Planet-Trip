package GameManagement;

/**
 * @author Serdar Taskafa
 */
public class CollisionManager {
    // Attributes

    private CollisionManager collisionManager;


    // Constructor
    public CollisionManager(){} // Empty constructor


    // Methods
    //Checks the collision between ball and meteor
    public boolean checkMeteorBallCollision(Meteor meteor, Ball ball){}

    //Checks the collision between ball and paddle
    public boolean checkPaddleBallCollision(Paddle paddle, Ball ball){}

    //Checks the collision between bonus and paddle
    public boolean checkPaddleBonusCollision(Paddle paddle, Bonus bonus){}

    //Checks the collision between ball and walls
    public boolean checkBallWallCollision(Ball ball){}

    //Checks the collision between Gegl and laser
    public boolean checkGeglLaserCollision(Gegl gegl, Laser laser){}

    //Checks the collision between Paddle and laser
    public boolean checkPaddleLaserCollision(Paddle paddle, Laser laser){}
}