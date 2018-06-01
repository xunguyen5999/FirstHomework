import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundRenderer {
    public Vector2D position;
    public Color color;

    public BackgroundRenderer(Vector2D position) {
        this.position = new Vector2D();
    }

    public void render(Graphics graphics, Vector2D position){
        graphics.setColor(Color.BLACK);
        graphics.fillRect((int) this.position.x, (int) this.position.y, 1024,600);
    }

}
