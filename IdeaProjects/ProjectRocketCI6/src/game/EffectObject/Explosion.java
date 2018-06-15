package game.EffectObject;

import base.FrameCounter;
import base.GameObject;
import base.Vector2D;
import game.enemy.Enemy;
import renderer.ImageRenderer;

public class Explosion extends GameObject {

    public FrameCounter frameCounter;
    public Vector2D velocity;


    public Explosion() {
        this.frameCounter = new FrameCounter(3);

        this.velocity = new Vector2D();
    }

    @Override
    public void run(){
        super.run();
        ImageRenderer imageRenderer = (ImageRenderer)this.renderer;
        this.position.addUp(velocity);

        if(frameCounter.run()) {
            if (imageRenderer != null) {
                imageRenderer.width -= 1;
                imageRenderer.height -= 1;
                if (imageRenderer.width == 0 || imageRenderer.height == 0) {
                    this.isAlive = false;
                }
            }
            frameCounter.reset();
        }

    }
}
