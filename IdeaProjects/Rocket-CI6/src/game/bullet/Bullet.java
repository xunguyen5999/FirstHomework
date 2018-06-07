package game.bullet;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.Enemy;
import physic.BoxCollider;
import renderer.ImageRenderer;

public class Bullet extends GameObject {

    public Vector2D velocity;
    public BoxCollider boxCollider;



    public Bullet() {

        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources-rocket-master/resources/images/circle.png",6,6);
        this.boxCollider = new BoxCollider(6,6);
    }
    @Override
    public void run()
    {
        super.run();
        this.position = this.position.addUp(velocity);
        this.boxCollider.position.set(this.position.x-3,this.position.y-3);
        Enemy enemy = GameObjectManager.instance.checkCollision(this);
        if(enemy != null){
            enemy.isAlive = false;
            this.isAlive = false;


        }
    }


}
