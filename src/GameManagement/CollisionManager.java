package GameManagement;

/**
 * @author Serdar Taskafa
 * This class exhibits the Singleton design pattern.
 */
public class CollisionManager {
    // Attributes
    private static CollisionManager collisionManager;


    // Constructor
    private CollisionManager(){} // Empty constructor


    // Methods
    // The Singleton method
    public static CollisionManager getCollisionManager() {
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
        float rectX = meteor.getxPosition()+36;
        float rectY = meteor.getyPosition()+15;
        float rectWidth = 72;
        float rectHeight = 30;

        float deltaX = Math.abs(circleX - rectX);
        float deltaY = Math.abs(circleY - rectY);

        if (deltaX*deltaX + deltaY*deltaY < circleRadius*circleRadius) {
            if( Math.asin(deltaY/deltaX) < Math.asin(5.0/12.0) )
                ball.setxSpeed( ball.getxSpeed() * -1 );
            else
                ball.setySpeed( ball.getySpeed() * -1 );

            return true;
        }
        else
            return false;
    }

    //Checks the collision between ball and paddle
    //In this function, we are checking only y-values
    public boolean checkPaddleBallCollision(Paddle paddle, Ball ball){
        float ballYBottom = ball.getyPosition() + ball.getRadius();
        float ballX = ball.getxPosition();
        float paddleY = paddle.getyPosition();
        float paddleXBeg = paddle.getxPosition();
        float paddleXEnd = paddle.getxPosition()+paddle.getPaddleLength();

        return (ballYBottom >= paddleY && ballX >= paddleXBeg && ballX <= paddleXEnd );
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

        if( ballY + ballRadius >= screenHeight )
            return true;

        if( ballY - ballRadius <= 25 )
            ball.setySpeed( ball.getySpeed() * -1 );

        if( ballX - ballRadius <= 0 || ballX + ballRadius >= screenWidth)
            ball.setxSpeed( ball.getxSpeed() * -1 );

        return false;
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