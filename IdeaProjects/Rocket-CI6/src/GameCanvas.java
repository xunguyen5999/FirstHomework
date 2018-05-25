import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {

    BufferedImage playerImage;
    BufferedImage backBuffered;
    Graphics graphics;
    Player player;


    List<Star> stars;
    List<Enemy> enemies;
    private Random random = new Random();
    private int countStar = 0;
    private int countEnemy = 0;


    public int positionXPlayer = 500;
    public int positionYPlayer = 200;

    public GameCanvas(){
        this.setSize(1024,600);

        this.setupCharacter();

        this.setupBackBuffered();

        this.setVisible(true);

    }

    private void setupBackBuffered(){
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter(){

        //this.playerImage = this.loadImage("resources-rocket-master/resources/images/circle.png");
        this.setupStar();
        this.setupEnemy();

    }

    private void setupStar(){
        this.stars = new ArrayList<>();


    }
    private void setupEnemy(){
        this.enemies = new ArrayList<>();
    }

    private void createPlayer(){
        Player player = new Player(this.loadImage("resources-rocket-master/resources/images/circle.png"),
                positionXPlayer,
                positionYPlayer,
                30,
                30,
                3,
                3
        );
        player.render(graphics);
    }
    @Override
    protected void paintComponent(Graphics g) {// lat backbuffered
        g.drawImage(this.backBuffered,0,0,null);
//        g.setColor(Color.BLACK);
//        g.fillRect(0,0,1024,600);
//        g.drawImage(this.starImage,positionXStar,positionYStar,10,10,null);
//        g.drawImage(this.enemyImage,positionXEnemy,positionYEnemy,20,20,null);
//        g.drawImage(this.playerImage,positionXPlayer,positionYPlayer,30,30,null);
    }

    public void renderAll(){
        //this.renderBackground();
        this.createBackground();
        this.createPlayer();
        this.stars.forEach(star->star.render(graphics));
        this.enemies.forEach(enemy -> enemy.render(graphics));
        //this.graphics.drawImage(this.playerImage,positionXPlayer,positionYPlayer,30,30,null);

        this.repaint();

    }

//    private void renderBackground(){
//        this.graphics.setColor(Color.BLACK);
//        this.graphics.fillRect(0,0,1024,600);
//
//    }

    public void createBackground(){
      Background background = new Background(0,0,1024,600,Color.BLACK);
      background.backgroundRender(graphics);
    }

    public void runAll(){
        this.stars.forEach(star -> star.run());
        this.enemies.forEach(enemy -> enemy.run(positionXPlayer,positionYPlayer));
        this.createStar();
        this.createEnemy();
    }

    private void createStar(){
        if(this.countStar==5){
        Star star = new Star(
                this.loadImage("resources-rocket-master/resources/images/star.png"),
                1024,
                this.random.nextInt(600),
                5,5,
                -this.random.nextInt(3)-1,
                0
        );
        this.stars.add(star);
        this.countStar = 0;
        }else{
            this.countStar += 1;
        }
    }

    private void createEnemy(){
        if(this.countEnemy==200){
            Enemy enemy = new Enemy(
                    this.loadImage("resources-rocket-master/resources/images/circle.png"),
                    this.random.nextInt(1024),
                    this.random.nextInt(600),
                    15,15,
                    (this.random.nextInt(2)+1)*randomNum(),
                    (this.random.nextInt(2)+1)*randomNum()
            );
            this.enemies.add(enemy);
            this.countEnemy = 0;
        }else{
            this.countEnemy += 1;
        }
    }

    private int randomNum(){
        if(this.random.nextInt(2)==0){
            return -1;
        }
        else return 1;
    }

    private BufferedImage loadImage(String path){
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }




}
