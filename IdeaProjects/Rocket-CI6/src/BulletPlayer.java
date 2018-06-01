import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class BulletPlayer {
    BufferedImage image;
    public Vector2D position;
    public Vector2D velocity;
    public int width, height;
    private Random random;
    private ImageRenderer renderer;


    public BulletPlayer() {

        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.random = new Random();
        this.renderer = new ImageRenderer("resources-rocket-master/resources/images/circle.png",8,8);
    }

    public void run()
    {
        this.position = this.position.addUp(velocity);
    }


    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }

}
