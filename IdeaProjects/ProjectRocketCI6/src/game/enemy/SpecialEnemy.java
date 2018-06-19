package game.enemy;


import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;

import game.EffectObject.Explosion;
import game.bullet.Bullet;
import game.EffectObject.Shield;
import game.player.Player;
import physic.BoxCollider;

import renderer.ImageRenderer;

import java.awt.*;
import java.util.Random;

public class SpecialEnemy extends Enemy {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    private Random random;
    private game.enemy.EnemyShoot enemyShoot;


    //constructor
    public SpecialEnemy(){
        this.random = new Random();
        this.velocity = new Vector2D(1,0);
        this.renderer = new ImageRenderer("resources/images/circle.png",20,20,Color.ORANGE);
        this.boxCollider = new BoxCollider(20,20);
        this.enemyShoot = new game.enemy.EnemyShoot();
    }

    @Override
    public void run(){
//        super.run();
        this.position.addUp(this.velocity);
        this.enemyShoot.run(this);
        this.boxCollider.position.set(this.position.x-10,this.position.y-10);
        this.backToScreen();
    }

    private void backToScreen() {
        if (this.position.x > 1024) {
            this.position.set(0, this.random.nextInt(600));
        }
        if (this.position.x < 0) {
            this.position.set(1024, this.random.nextInt(600));
        }
        if (this.position.y > 600) {
            this.position.set(this.random.nextInt(1024), 0);
        }
        if (this.position.y < 0) {
            this.position.set(this.random.nextInt(1024), 600);
        }
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

    @Override
    public void getHit(GameObject gameObject) {
        if(gameObject instanceof Player || gameObject instanceof Bullet || gameObject instanceof Shield){
            this.isAlive = false;
            creatExplosion();
        }

    }
}
