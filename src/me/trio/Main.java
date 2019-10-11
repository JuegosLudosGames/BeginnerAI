package me.trio;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 * Main class that houses the main method and base methods
 * 
 * @author Kyle
 *
 */
public class Main extends BasicGame {
	
	private static final String NAME = "AiProject";
	private static final int SCREENHEIGHT = 1000;
	private static final int SCREENWIDTH = 1000;
	private static final Color Color = null;
	
	private static ArrayList<GameObject> obj;

	/**
	 * Constructor for Class that pushes into BasicGame Constructor
	 * @param name
	 */
	public Main(String name) {
		super(name);
	}

	/**
	 * Actions that occur when rendering
	 * @param container the container which holds the game
	 * @param g 
	 */
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		
		//render process

		g.setBackground(Color.black);

		for (GameObject o : obj) {
			o.onRender(g);
		}
		
		//late update
		for (GameObject o : obj) {
			o.lateUpdate();
		}
		
	}

	/**
	 * Actions that occur when started
	 * @param container the game container
	 */
	@Override
	public void init(GameContainer container) throws SlickException {
		
		obj = new ArrayList<>();
		
		//define Gameobjects here
		Wall w = new Wall(new Vector2D(100f,100f),(new Vector2D(800f, 100f)));
		//do obj.add(<object data here>)
		obj.add(w);
		
		
		//end of definitions
		
		//enables all objects and calls method
		for(GameObject o : obj) {
			o.setEnable(true);
			o.onEnable();
		}
		
		//starts all objects
		for (GameObject o : obj) {
			o.start();
		}
		
	}
	
	/**
	 * Actions that occur when started
	 * @param container the game container
	 * @param delta 
	 */
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		
		//early updates
		for(GameObject o : obj) {
			o.earlyUpdate();
		}
		
		//physics update
		
		//reg updates
		for(GameObject o : obj) {
			o.update();
		}
		
	}

	public static void main(String[] args) {

		try {

			AppGameContainer gc = new AppGameContainer(new Main(NAME));
			gc.setDisplayMode(SCREENHEIGHT, SCREENWIDTH, false);
			gc.start();

		} catch (SlickException e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}

}
