import java.util.ArrayList;
import java.util.List;

public class EnemyShoot {

    public List<BulletEnemy> bulletEnemies;
    private int count = 0;
    public EnemyShoot(){
        this.bulletEnemies = new ArrayList<>();
    }
    public void run(Enemy enemy){
        //create bullet
        if(count == 40) {
            BulletEnemy bulletEnemy = new BulletEnemy();
            bulletEnemy.position.set(enemy.position);
            bulletEnemy.velocity.set(enemy.velocity.multiply(3));
            this.bulletEnemies.add(bulletEnemy);
            count=0;
        }else{
            count++;
        }
    }
}
