import java.util.ArrayList;
import java.util.List;

public class PlayerShoot {
    public List<BulletPlayer> bulletPlayers;
    private int count = 0;
    public PlayerShoot(){
        this.bulletPlayers = new ArrayList<>();
    }
    public void run(Player player){
        //create bullet
        if(count == 50) {
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(player.position);
            bulletPlayer.velocity.set(player.velocity.add(player.velocity.normalize()).multiply(3));
            this.bulletPlayers.add(bulletPlayer);
            count=0;
        }else{
            count++;
        }
    }
}
