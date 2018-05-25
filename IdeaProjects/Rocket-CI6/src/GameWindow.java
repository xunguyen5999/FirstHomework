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
                    gameCanvas.positionXPlayer -=9;
                    if(gameCanvas.positionXPlayer >1024){
                        gameCanvas.positionXPlayer = 0;
                        gameCanvas.positionYPlayer = random.nextInt(600);
                    }else if(gameCanvas.positionXPlayer < 0){
                        gameCanvas.positionXPlayer = 1024;
                        gameCanvas.positionYPlayer = random.nextInt(600);
                    }
                }if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    gameCanvas.positionXPlayer +=9;
                    if(gameCanvas.positionXPlayer >1024){
                        gameCanvas.positionXPlayer = 0;
                        gameCanvas.positionYPlayer = random.nextInt(600);
                    }else if(gameCanvas.positionXPlayer < 0){
                        gameCanvas.positionXPlayer = 1024;
                        gameCanvas.positionYPlayer = random.nextInt(600);
                    }
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    gameCanvas.positionYPlayer +=9;
                    if(gameCanvas.positionYPlayer >600){
                        gameCanvas.positionYPlayer = 0;
                        gameCanvas.positionXPlayer = random.nextInt(1024);
                    }else if(gameCanvas.positionYPlayer < 0){
                        gameCanvas.positionYPlayer = 600;
                        gameCanvas.positionXPlayer = random.nextInt(1024);
                    }
                }
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    gameCanvas.positionYPlayer -=9;
                    if(gameCanvas.positionYPlayer >600){
                        gameCanvas.positionYPlayer = 0;
                        gameCanvas.positionXPlayer = random.nextInt(1024);
                    }else if(gameCanvas.positionYPlayer < 0){
                        gameCanvas.positionYPlayer = 600;
                        gameCanvas.positionXPlayer = random.nextInt(1024);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

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
