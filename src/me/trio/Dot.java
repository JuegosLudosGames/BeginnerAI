package me.trio;

import java.util.Random;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**
 * Contains the information to make a dot game object.
 * This object moves randomly.
 * @author hanna
 */
public class Dot implements GameObject{
    Vector2D coords;
    
    /**
     * constructor that takes the coordinates of the spawn point and passes it
     * to the class
     * @param tempCoords placeholder for the coordinates
     */
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
        
        //a random number generated to randomly chose which direction the dot goes
        int ran = new Random().nextInt(4) + 1;
        
        move(ran);
    }
    
    /*
     * Moves the dot by taking the random number between 1-4 and passing it to
     * a switch statement, which then goes to the mothod that changes the coordinates of the
     * dot
     */
    private void move(int ran){
        
        //a random number is chosen between 1-5 to determine the magnitude of the movement
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
    
}
