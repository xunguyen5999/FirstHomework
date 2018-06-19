package game.enemy;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.EffectObject.Explosion;
import game.EffectObject.Smoke;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

import java.awt.*;
import java.util.Random;

public class Enemy extends GameObject implements PhysicBody {

    public Vector2D velocity;
    public BoxCollider boxCollider;
    public Random random;

    public Enemy() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20, Color.YELLOW);
        this.boxCollider = new BoxCollider(20, 20);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);
        Player player = GameObjectManager.instance.findPlayer();
        if (player != null) {
            this.velocity.set(
                    player.position
                            .subtract(this.position)
                            .normalize()
                            .multiply(2.0f)
            );
        }
    }

    @Override
    public void getHit(GameObject gameObject) {

        creatExplosion();
        this.isAlive = false;
    }

    public void creatExplosion(){


        for(double angle1 = 0.0; angle1 <= 360; angle1 += 15) {
            this.random = new Random();
            for (double angle = 0.0; angle <= 360.0; angle += random.nextInt(20)+20) {
                Explosion explosion = GameObjectManager.instance.recycle(Explosion.class);
                explosion.renderer = new ImageRenderer("resources/images/star.png", 12, 12, Color.yellow);
                explosion.position.set(this.position);
                this.random = new Random();
                explosion.velocity.set((new Vector2D(this.random.nextInt(7)+3, 0)).rotate(angle));
                explosion.run();

            }
        }

    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
