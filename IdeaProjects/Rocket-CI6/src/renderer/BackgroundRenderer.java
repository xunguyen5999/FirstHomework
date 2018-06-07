package renderer;

import base.Vector2D;

import java.awt.*;

public class BackgroundRenderer implements Renderer {
    public Vector2D position;
    public Color color;

    public BackgroundRenderer(Vector2D position) {
        this.position = new Vector2D();
    }

    @Override
    public void render(Graphics graphics, Vector2D position){
        graphics.setColor(Color.BLACK);
        graphics.fillRect((int) this.position.x, (int) this.position.y, 1024,600);
    }

}
