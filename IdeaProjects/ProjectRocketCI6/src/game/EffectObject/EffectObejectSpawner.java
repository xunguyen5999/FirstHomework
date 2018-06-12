package game.EffectObject;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class EffectObejectSpawner extends GameObject{
    private FrameCounter frameCounterShield, frameCounterShot;
    private Random random;

    public EffectObejectSpawner() {
        this.frameCounterShield = new FrameCounter(200);
        this.frameCounterShot = new FrameCounter(200);
        this.random = new Random();
    }

    public void run(){
        if(this.frameCounterShield.run()){
            Shield Shield = GameObjectManager.instance.recycle(Shield.class);
            Shield.position.set(this.random.nextInt(800)+ 50, this.random.nextInt(400)+50);
            this.frameCounterShield.reset();
        }
        if(this.frameCounterShot.run()){
            TripleShot tripleShot = GameObjectManager.instance.recycle(TripleShot.class);
            tripleShot.position.set(this.random.nextInt(800)+50, this.random.nextInt(400)+50);
            this.frameCounterShot.reset();
        }

    }

}
