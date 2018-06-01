import java.awt.*;

public class Background {
    public Vector2D position;
    public Color color;
    BackgroundRenderer renderer;

    public Background() {
        this.position = new Vector2D();
        renderer = new BackgroundRenderer(this.position);
    }

    public void render(Graphics graphics) {
        renderer.render(graphics,this.position);
    }
}