import java.awt.*;
import java.awt.image.BufferedImage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Player {
    BufferedImage image;
    public int x;
    public int y;
    public int width;
    public int height;
    public int velocityX;
    public int velocityY;

    public Player(BufferedImage image, int x, int y, int width, int height, int velocityX, int velocityY) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public void render(Graphics graphics){
        graphics.drawImage(this.image,this.x,this.y,this.width,this.height,null);
    }



}
