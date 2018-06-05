import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StarSpawner extends GameObject {
    private FrameCounter frameCounter;

    private Random random;
    public List<Star> stars;

    public StarSpawner(){
        this.stars = new ArrayList<>();
        this.random = new Random();
        this.frameCounter = new FrameCounter(20);
    }

    @Override
    public void run(){
        super.run();
        if (this.frameCounter.run()) {
            Star star = new Star();
            star.position.set(1024, this.random.nextInt(600));
            star.velocity.set(-(this.random.nextInt(5) + 1), 0);
            this.stars.add(star);
            this.frameCounter.reset();
        }
        this.stars.forEach(star -> star.run());
    }
}
