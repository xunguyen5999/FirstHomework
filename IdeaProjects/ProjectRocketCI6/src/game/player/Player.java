package game.player;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.EffectObject.Shield;
import game.EffectObject.TripleShot;
import game.bullet.Bullet;
import game.enemy.Enemy;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.PolygonRenderer;

import java.awt.*;

public class Player extends GameObject implements PhysicBody {
    public PlayerMove playerMove;
    public PlayerShoot playerShoot;
    public BoxCollider boxCollider;
    private RunHitObject runHitObject;

    private int life;
    public boolean tripleShot;


    public Player() {
        this.position = new Vector2D();
        this.renderer = new PolygonRenderer(
                Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
        this.boxCollider = new BoxCollider(20,8);
        this.runHitObject = new RunHitObject(
                Enemy.class,
                Bullet.class,
                TripleShot.class,

                Shield.class);
        this.life =1;
        this.tripleShot = false;

    }

    @Override
    public void run() {
        super.run();
        this.playerMove.run(this);
        this.playerShoot.run(this);
        ((PolygonRenderer) this.renderer).angle = this.playerMove.angle;
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 5);
        this.runHitObject.run(this);


    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if(gameObject instanceof Enemy) {
            if(this.life==1){
                this.isAlive = false;
            }
            else{
                this.life -=1;
            }
        }
        if(gameObject instanceof Shield){
            this.life = 4;
        }
        if(gameObject instanceof TripleShot){
            this.tripleShot =true;
        }
    }

    @Override
    public void render(Graphics graphics){
        super.render(graphics);
        if(this.life >1){
            graphics.setColor(Color.BLUE);
            for(int i = 40; i<55; i++) {
                graphics.drawOval((int) this.position.x - i/2, (int) this.position.y - i/2, i, i);
            }
        }
    }

}
