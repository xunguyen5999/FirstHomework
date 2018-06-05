import java.util.ArrayList;
import java.util.List;

public class EnemyShoot {

    public List<Bullet> bulletEnemies;
    private int count = 0;
    public EnemyShoot(){
        this.bulletEnemies = new ArrayList<>();
    }
    public void run(Enemy enemy){
        //create bullet
        if(count == 40) {
            Bullet bullet = new Bullet();
            bullet.position.set(enemy.position);
            bullet.velocity.set(enemy.velocity.multiply(3));
            this.bulletEnemies.add(bullet);
            count=0;
        }else{
            count++;
        }
    }
}
