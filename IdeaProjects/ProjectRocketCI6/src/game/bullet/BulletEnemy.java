package game.bullet;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.EffectObject.Shield;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

import java.awt.*;


public class BulletEnemy extends GameObject implements PhysicBody {

    public Vector2D velocity;
    public BoxCollider boxCollider;


    //constructor
    public BulletEnemy(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png",6,6,Color.YELLOW);
        this.boxCollider = new BoxCollider(6,6);

    }

    @Override
    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 3, this.position.y - 3);
        GameObjectManager.instance.killObject(this);

    }


    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if(gameObject instanceof Player || gameObject instanceof Bullet || gameObject instanceof Shield){
            this.isAlive = false;
        }


    }
}