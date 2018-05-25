import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy {
    BufferedImage image;
    public int x;
    public int y;
    public int width;
    public int height;
    public int velocityX;
    public int velocityY;
    public Player player;
    private Random random = new Random();

    public Enemy(BufferedImage image, int x, int y, int width, int height, int velocityX, int velocityY) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public void runSmall(){
        this.x +=this.velocityX;
        this.y += this.velocityY;
    }

    public void run(int playerX, int playerY){
        runSmall();
        follow(playerX, playerY);
        if(this.x > 1024){
            this.x = 0;
            this.y = this.random.nextInt(600);
            run(playerX,playerY);
        }else if (this.x<0){
            this.x = 1024;
            this.y = this.random.nextInt(600);
            run(playerX,playerY);
        }

        if(this.y > 600){
            this.y = 0;
            this.x = this.random.nextInt(1024);
            run(playerX,playerY);
        }else if(this.y<0){
            this.y = 600;
            this.x = this.random.nextInt(1024);
            run(playerX,playerY);
        }
    }

    public void follow(int playerX, int playerY){
        if(this.x == playerX && this.y == playerY){
            this.velocityX = 0;
            this.velocityY = 0;
        }else if(this.x == playerX){
            this.velocityX = 0;
            this.velocityY = (playerY-this.y)/Math.abs(playerY-this.y);
        }else if (this.y == playerY){
            this.velocityY = 0;
            this.velocityX = (playerX-this.x)/Math.abs(playerX-this.x);
        }else{
            this.velocityX = (playerX-this.x)/Math.abs(playerX-this.x);
            this.velocityY = (playerY-this.y)/Math.abs(playerY-this.y);

        }
    }



    public void render(Graphics graphics){
        graphics.drawImage(this.image,this.x,this.y,this.width,this.height,null);
    }

}
