package GameManagement;

/**
 * @author Serdar Taskafa
 * This class exhibits the Singleton design pattern.
 */
public class CollisionManager {
    // Attributes
    private CollisionManager collisionManager;


    // Constructor
    private CollisionManager(){} // Empty constructor


    // Methods
    // The Singleton method
    public CollisionManager getCollisionManager() {
        if (collisionManager == null) {
            collisionManager = new CollisionManager();
        }
        return collisionManager;
    }

    //Checks the collision between ball and meteor
    // We assume Meteors are rectangles and balls are circles
    public boolean checkMeteorBallCollision(Meteor meteor, Ball ball){
        float circleX = ball.getxPosition();
        float circleY = ball.getyPosition();
        float circleRadius = ball.getRadius();
        float rectX = meteor.getxPosition();
        float rectY = meteor.getyPosition();
        float rectWidth = meteor.getObjectImages().getWidth();
        float rectHeight = meteor.getObjectImages().getHeight();

        float deltaX = circleX - Math.max(rectX, Math.min(circleX, rectX+rectWidth));
        float deltaY = circleY - Math.max(rectY, Math.min(circleY, rectY+rectHeight));

        return (deltaX*deltaX + deltaY*deltaY < circleRadius*circleRadius);
    }

    //Checks the collision between ball and paddle
    //In this function, we are checking only y-values
    public boolean checkPaddleBallCollision(Paddle paddle, Ball ball){
        float ballYBottom = ball.getyPosition() + ball.getRadius();
        float paddleY = paddle.getyPosition();

        return !(ballYBottom < paddleY);
    }

    //Checks the collision between bonus and paddle
    public boolean checkPaddleBonusCollision(Paddle paddle, Bonus bonus){
        float bonusY = bonus.getyPosition();
        float paddleY = paddle.getyPosition();

        float bonusX = bonus.getxPosition();
        float paddleX = paddle.getxPosition();
        float paddleLength = paddle.getPaddleLength();

        boolean horizontalCond = bonusY == paddleY;
        boolean verticalCond = (bonusX >= paddleX) && (bonusX <= (paddleX+paddleLength));

        return horizontalCond && verticalCond;
    }

    //Checks the collision between ball and walls
    //We will check the x and y-positions of the ball against sides of the panel
    public boolean checkBallWallCollision(Ball ball, float screenWidth, float screenHeight){
        float ballX = ball.getxPosition();
        float ballY = ball.getyPosition();
        float ballRadius = ball.getRadius();

        boolean isBallBelow = ballY - ballRadius <= 0;
        boolean isBallAbove = ballY + ballRadius >= screenHeight;
        boolean isBallAtLeft = ballX - ballRadius <= 0;
        boolean isBallAtRight = ballX + ballRadius >= screenWidth;

        return isBallAtLeft || isBallBelow || isBallAbove || isBallAtRight;
    }

    //Checks the collision between Gegl and laser
    public boolean checkGeglLaserCollision(Gegl gegl, Laser laser){
        float geglX = gegl.getxPosition();
        float geglY = gegl.getyPosition();
        float laserX = laser.getxPosition();
        float laserY = laser.getyPosition();

        return geglX == laserX && geglY == laserY;
    }

    //Checks the collision between Paddle and laser
    public boolean checkPaddleLaserCollision(Paddle paddle, Laser laser){
        float paddleY = paddle.getyPosition();
        float laserY = laser.getyPosition();
        float paddleX = paddle.getxPosition();
        float laserX = laser.getxPosition();
        float paddleLength = paddle.getPaddleLength();

        boolean horizontalCond = (laserX >= paddleX) && (laserX <= (paddleX+paddleLength));
        boolean verticalCond = laserY == paddleY;
        return horizontalCond && verticalCond;
    }
}