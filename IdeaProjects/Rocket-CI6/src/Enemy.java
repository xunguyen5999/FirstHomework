import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy {

    BufferedImage image;
    public Vector2D position;
    public Vector2D velocity;
    public int width, height;
    private Random random;

    public Player player = new Player();

    public Enemy(BufferedImage image, int width, int height) {

        this.image = image;
        this.position = new Vector2D();
        this.width = width;
        this.height = height;
        this.velocity = new Vector2D();
        this.random = new Random();
    }

    public void run(Vector2D positionPlayer)
    {

        this.velocity = this.followPlayer(positionPlayer).multiply(3);

//        this.velocity = this.velocity.multiply(3);

//        xyPlayer(player.position);
//        velocity = this.xyPlayer(player.position).m;

        this.position = this.position.addUp(velocity);
        this.backToScreen();
    }


    private void backToScreen() {
        if (position.x > 1024)   {
            position.set(0, random.nextInt(600));
        }
        if (position.x < 0)  {
            position.set(1024, random.nextInt(600));
        }
        if (position.y > 600)    {
            position.set(random.nextInt(1024), 0);
        }
        if (position.y < 0)    {
            position.set(random.nextInt(1024), 600);
        }
    }

    private Vector2D followPlayer(Vector2D positionPlayer){
        Vector2D velocitySubtract;
        velocitySubtract = positionPlayer.subtract(this.position);
        return velocitySubtract.normalize();
    }

    public void render(Graphics graphics){
        graphics.drawImage(this.image, (int)position.x, (int)position.y, this.width, this.height, null);
    }
}