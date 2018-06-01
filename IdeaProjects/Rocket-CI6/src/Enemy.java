import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy {

    public Vector2D position;
    public Vector2D velocity;
    private ImageRenderer renderer;
    private EnemyShoot enemyShoot;
    private SpecialEnemyShoot specialEnemyShoot;

    public Enemy() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources-rocket-master/resources/images/circle.png", 20, 20);
        this.enemyShoot = new EnemyShoot();
        this.specialEnemyShoot = new SpecialEnemyShoot();
    }

    public void run() {
        this.position.addUp(this.velocity);
        this.enemyShoot.run(this);
        this.enemyShoot.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
        this.specialEnemyShoot.run(this);
        this.specialEnemyShoot.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
    }


    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
        this.enemyShoot.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
        this.specialEnemyShoot.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }
}