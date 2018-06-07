package game.player;

import base.FrameCounter;
import base.GameObjectManager;
import game.bullet.Bullet;

public class PlayerShoot {
    private FrameCounter frameCounter;
    public PlayerShoot(){
        this.frameCounter = new FrameCounter(20);
    }
    public void run(Player player){
        //create bullet
        if(this.frameCounter.run()) {
            Bullet bulletPlayer = new Bullet();
            bulletPlayer.position.set(player.position);
            bulletPlayer.velocity.set(player.playerMove.velocity.add(player.playerMove.velocity.normalize()).multiply(3));
            GameObjectManager.instance.add(bulletPlayer);
            this.frameCounter.reset();

        }
    }
}
