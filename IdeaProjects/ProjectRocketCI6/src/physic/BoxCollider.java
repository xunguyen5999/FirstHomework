package physic;

import base.Vector2D;

import java.awt.*;

public class BoxCollider {

    public Vector2D position;
    private int width;
    private int height;

    public BoxCollider(int width, int height) {
        this.width = width;
        this.height = height;
        this.position = new Vector2D();
    }

    public boolean checkBoxCollider(BoxCollider other) {
        Rectangle r1 = new Rectangle((int) this.position.x, (int) this.position.y, this.width, this.height);
        Rectangle r2 = new Rectangle((int) other.position.x, (int) other.position.y, other.width, other.height);
        return r1.intersects(r2);
    }
}
