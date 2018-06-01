import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Player {
    public Vector2D position;
    public Vector2D velocity;
    private Random random;
    private PlayerShoot playerShoot;
//    private List<Vector2D> verties;
//    private Polygon polygon;
    public double angle = 0.0;
    private PolygonRenderer renderer;

    public Player() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.random = new Random();
        this.renderer = new PolygonRenderer(
                Color.BLUE,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)

        );
        this.playerShoot = new PlayerShoot();
//        this.verties = Arrays.asList(
//                new Vector2D(),
//                new Vector2D(0, 16),
//                new Vector2D(20, 8)
//        );
//        this.polygon = new Polygon();
    }

    public void run() {
        this.position.addUp(this.velocity);
        this.renderer.angle = this.angle;
        this.backToScreen();
        this.playerShoot.run(this);
        this.playerShoot.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.run());

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

    public void render(Graphics graphics) {
        this.renderer.render(graphics,this.position);
        this.playerShoot.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.render(graphics));
    }


}