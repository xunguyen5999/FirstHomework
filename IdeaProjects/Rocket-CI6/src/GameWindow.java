import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;



public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    long lastTime = 0;
    private Random random = new Random();


    public GameWindow(){
        this.setSize(1024,600); //set size window

        this.setupGameCanvas();

        this.event();

        this.setVisible(true);

    }



    private void setupGameCanvas(){
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
    }

    private void event(){
        this.keyboardEvent();
        this.windowEvent();
    }

    private void keyboardEvent(){
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    gameCanvas.player.velocity.x = -9;
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    gameCanvas.player.velocity.x = 9;
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN) {
                    gameCanvas.player.velocity.y = 9;
                }
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    gameCanvas.player.velocity.y = -9;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                gameCanvas.player.velocity.x = 0;
                gameCanvas.player.velocity.y = 0;
            }
        });
    }

    private void windowEvent(){
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    public void gameLoop(){
        while(true){
            long currentTime = System.nanoTime();
            if(currentTime - lastTime >= 17_000_000){
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }
        }
    }
}
