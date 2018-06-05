import java.util.ArrayList;
import java.util.List;

public class PlayerShoot {
    public List<Bullet> bulletPlayers;
    private int count = 0;
    public PlayerShoot(){
        this.bulletPlayers = new ArrayList<>();
    }
    public void run(Player player){
        //create bullet
        if(count == 50) {
            Bullet bulletPlayer = new Bullet();
            bulletPlayer.position.set(player.position);
            bulletPlayer.velocity.set(player.playerMove.velocity.add(player.playerMove.velocity.normalize()).multiply(3));
            this.bulletPlayers.add(bulletPlayer);
            count=0;
        }else{
            count++;
        }
    }
}
