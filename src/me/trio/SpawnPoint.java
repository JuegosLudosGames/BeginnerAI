package me.trio;

import org.newdawn.slick.Graphics;

/**
 *
 * @author hanna
 */
public class SpawnPoint implements GameObject{

    @Override
    public void start() {
        earlyUpdate();
    }

    @Override
    public void earlyUpdate() {
        update();
    }

    @Override
    public void update() {
        lateUpdate();
    }

    @Override
    public void lateUpdate() {
        onEnable();
    }

    @Override
    public void onEnable() {
        
        setEnable(true);
    }

    @Override
    public void setEnable(boolean enable) {
        
    }

    @Override
    public void stop() {
    }

    @Override
    public void onRender(Graphics graphic) {
    }
    
}//end of SpawnPoint