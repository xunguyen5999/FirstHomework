import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {
    BufferedImage backBuffered;
    Graphics graphics;

    Background background;
    public Player player;
    private Random random = new Random();
    private EnemySpawner enemySpawner = new EnemySpawner();
    private StarSpawner starSpawner = new StarSpawner();

    public GameCanvas() {
        this.setSize(1024, 600);
        this.setupBackBuffered();
        this.setupCharacter();

        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter() {
        this.background = new Background();
        this.background.color = Color.BLACK;
        this.setupPlayer();
    }

    private void setupPlayer(){
        this.player = new Player();
        this.player.position.set(500, 300);
        this.player.playerMove.velocity.set(4,0);
    }


    @Override
    protected void paintComponent(Graphics g) {
        // lat backbuffered
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.background.render(this.graphics);

        this.starSpawner.stars.forEach(star -> star.render(graphics));

        this.player.render(this.graphics);

        this.enemySpawner.enemies.forEach(enemy -> enemy.render(graphics));

        this.repaint();
    }

    public void runAll() {
        this.starSpawner.stars.forEach(star -> star.run());



        this.enemySpawner.enemies.forEach(enemy -> enemy.run());
        this.enemySpawner.enemies.forEach(enemy -> {
            Vector2D velocity = player.position.subtract(enemy.position).normalize().multiply(random.nextInt(2)+1);
            enemy.velocity.set(velocity);
        });
        this.enemySpawner.run();
        this.starSpawner.run();
        this.player.run();
    }








}
