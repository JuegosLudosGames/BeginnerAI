package me.trio;

import java.util.Random;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**
 *
 * @author hanna
 */
public class Dot implements GameObject{
    Vector2D coords;
    
    public Dot(Vector2D tempCoords){
        
        coords = tempCoords;
    }

    @Override
    public void start() {
    }

    @Override
    public void earlyUpdate() {
    }

    @Override
    public void update() {
    }

    @Override
    public void lateUpdate() {
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void setEnable(boolean enable) {
    }

    @Override
    public void stop() {
    }

    @Override
    public void onRender(Graphics graphic) {
        graphic.setColor(Color.red);
        graphic.fillOval(coords.x, coords.y, 15, 2);
        graphic.fillOval((coords.x + 20), coords.y, 5, 5);
        graphic.fillOval((coords.x - 10), coords.y, 5, 5);
        
        int ran = new Random().nextInt(4) + 1;
        move(ran);
    }
    
    private void move(int ran){
        
        int m = new Random().nextInt(5) + 1;
        
        switch(ran){
            case 1:{
                up(m);
                break;
            }
            case 2:{
                down(m);
                break;
            }
            case 3:{
                left(m);
                break;
            }
            case 4:{
                right(m);
                break;
            }
        }
        
    }
    
    private void up(int m){
        coords.y -= m;
    }
    
    private void down(int m){
        coords.y += m;
    }
    
    private void left(int m){
        coords.x -= m;
    }
    
    private void right(int m){
        coords.x += m;
    }
    
    /**
     * deleteDot
     */
    public void deleteDot(){
        
    }
    
}
