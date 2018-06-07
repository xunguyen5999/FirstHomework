package game.background;

import base.GameObject;
import renderer.BackgroundRenderer;

import java.awt.*;

public class Background extends GameObject {
    public Color color;

    public Background() {
        renderer = new BackgroundRenderer(this.position);
    }

    public void render(Graphics graphics) {
        renderer.render(graphics,this.position);
    }
}