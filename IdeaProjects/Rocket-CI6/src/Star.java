
import java.awt.*;
import java.awt.image.BufferedImage;

public class Star extends GameObject {

    public Vector2D velocity;

    public Star() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources-rocket-master/resources/images/star.png",5,5);
    }
    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
    }
    @Override
    public void render(Graphics graphics) {
        this.renderer.render(graphics,this.position);
    }
}
