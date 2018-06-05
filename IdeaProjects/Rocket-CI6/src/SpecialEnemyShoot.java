import java.util.ArrayList;
import java.util.List;

public class SpecialEnemyShoot {
    public List<Bullet> bulletEnemies;
    private int count = 0;
    private double bulletAngle = 0;
    public SpecialEnemyShoot(){
        this.bulletEnemies = new ArrayList<>();
    }
    public void run(Enemy enemy){
        //create bullet
        if(count == 200) {
            for(int i = 0; i<12 ; i++) {
                Bullet bullet = new Bullet();
                bulletAngle +=30;
                bullet.position.set(enemy.position);
                bullet.velocity= new Vector2D(5,0).rotate(this.bulletAngle);

                this.bulletEnemies.add(bullet);
            }
            count = 0;
            bulletAngle = 0;

        }else{
            count++;
        }
    }
}
