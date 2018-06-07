package game.player;

import base.GameObject;
import base.Vector2D;
import renderer.PolygonRenderer;

import java.awt.*;


public class Player extends GameObject {
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

    }
}