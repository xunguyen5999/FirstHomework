import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Bullet extends GameObject {

    public Vector2D velocity;



    public Bullet() {

        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources-rocket-master/resources/images/circle.png",6,6);
    }
    @Override
    public void run()
    {
        super.run();
        this.position = this.position.addUp(velocity);
    }
}
