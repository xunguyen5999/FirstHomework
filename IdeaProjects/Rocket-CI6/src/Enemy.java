import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy extends GameObject {

    public Vector2D velocity;
    private EnemyShoot enemyShoot;
    private SpecialEnemyShoot specialEnemyShoot;

    public Enemy() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources-rocket-master/resources/images/circle.png", 20, 20);
        this.enemyShoot = new EnemyShoot();
        this.specialEnemyShoot = new SpecialEnemyShoot();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.enemyShoot.run(this);
        this.enemyShoot.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
        this.specialEnemyShoot.run(this);
        this.specialEnemyShoot.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
    }


    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        this.enemyShoot.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
        this.specialEnemyShoot.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }
}