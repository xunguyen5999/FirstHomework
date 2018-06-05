import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Player extends GameObject{
    private PlayerShoot playerShoot;
    public PlayerMove playerMove;

    public Player() {
        this.renderer = new PolygonRenderer(
                Color.BLUE,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)

        );
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();

    }

    @Override
    public void run() {
        super.run();
        this.playerMove.run(this);
        ((PolygonRenderer)this.renderer).angle = this.playerMove.angle;
        this.playerShoot.run(this);
        this.playerShoot.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.run());

    }
    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        this.playerShoot.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.render(graphics));
    }
}