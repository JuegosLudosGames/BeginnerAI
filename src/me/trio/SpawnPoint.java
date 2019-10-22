package me.trio;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**
 *
 * @author hanna
 */
public class SpawnPoint implements GameObject{
    
    //coordinates of the SpawnPoint
    private Vector2D coords;
    
   /**
    * SpawnPoint
    * Stores coordinates of the SpawnPoint
    * @param tempVector coordinates of the SpawnPoint
    */
    public SpawnPoint(Vector2D tempVector){
        coords = tempVector;
    }

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
        graphic.setColor(Color.blue);
        graphic.drawOval(coords.x, coords.y, 20, 20);
    }

	public Vector2D returnCoods() {
		// TODO Auto-generated method stub
		return coords;
	}
    
}//end of SpawnPoint