package me.trio;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**
 *
 * @author hanna
 */
public class SpawnPoint implements GameObject{

    static Vector2D returnCoords() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
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
        graphic.fillOval(coords.x + 12, coords.y + 5, 3, 3);
        graphic.fillOval(coords.x + 4, coords.y + 5, 3, 3);
        graphic.drawOval(coords.x + 2, coords.y + 10, 15, 1);
    }
    
    public Vector2D returnCoods(){
        return coords;
    }
    
}//end of SpawnPoint