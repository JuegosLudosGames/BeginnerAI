package me.trio;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import me.trio.ai.Intelligence;
import me.trio.ai.Trainer;

/**
 * Main class that houses the main method and base methods
 * 
 * @author Kyle
 *
 */
public class Main extends BasicGame {

	private static final String NAME = "AiProject";
	private static final int SCREENHEIGHT = 600;
	private static final int SCREENWIDTH = 1000;
	private static final int FRAMERATE = 60;
	private static final Color Color = null;

	private static ArrayList<GameObject> obj;

	/**
	 * Constructor for Class that pushes into BasicGame Constructor
	 * 
	 * @param name the name of the game
	 */
	public Main(String name) {
		super(name);
	}

	/**
	 * Actions that occur when rendering
	 * 
	 * @param container
	 *            the container which holds the game
	 * @param g the current graphic context
	 */
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {

		// render process

		g.setBackground(Color.black);

		for (GameObject o : obj) {
			o.onRender(g);
		}

		// late update
		for (GameObject o : obj) {
			o.lateUpdate();
		}

	}

	/**
	 * Actions that occur when started
	 * 
	 * @param container
	 *            the game container
	 */
	@Override
	public void init(GameContainer container) throws SlickException {

		obj = new ArrayList<>();

		// define GameObjects here
		Wall w = new Wall(new Vector2D(100f, 400f), (new Vector2D(880f, 400f)));
                Wall top = new Wall(new Vector2D(0f, 0f), (new Vector2D(1000f, 0f)));
                Wall bottom = new Wall(new Vector2D(0f, 599f), (new Vector2D(999f, 599f)));
                Wall left = new Wall(new Vector2D(0f, 0f), (new Vector2D(0f, 999f)));
                Wall right = new Wall(new Vector2D(999f, 0f), (new Vector2D(999f, 599f)));
		SpawnPoint s = new SpawnPoint(new Vector2D(490f, 550f));
		EndPoint ept = new EndPoint(new Vector2D(490f, 99f));

		Dot d = null;
		Dot d2 = null;
		d = new Dot((Vector2D) s.returnCoods().cloneVector());
		for (int a = 0; a < 299; a++) {
			d2 = new Dot((Vector2D) s.returnCoods().cloneVector());
			obj.add(d2);
		}

		//EndPoint ept = new EndPoint(new Vector2D(490f, 99f));

		// do obj.add(<object data here>)
		obj.add(w);
                obj.add(top);
                obj.add(bottom);
                obj.add(left);
                obj.add(right);
		obj.add(s);
		obj.add(d);
		obj.add(ept);

		// end of definitions

		// enables all objects and calls method
		for (GameObject o : obj) {
			o.setEnable(true);
			o.onEnable();
		}

		// starts all objects
		for (GameObject o : obj) {
			o.start();
		}

		// temp code
		// generates 100 random creatures
		Intelligence.entities = new Intelligence[25];
		Random rnd = new Random();
		for (int x = 0; x < Intelligence.entities.length; x++) {
			Intelligence.entities[x] = Trainer.generateRandomCreature();
			Intelligence.entities[x].fitness = rnd.nextInt(200);
		}

		Trainer.sortByFitness();

		for (Intelligence i : Intelligence.entities) {
			System.out.println(i.fitness);
		}
		
	}

	/**
	 * Actions that occur when started
	 * 
	 * @param container
	 *            the game container
	 * @param delta the time delta of the frame
	 */
	@Override
	public void update(GameContainer container, int delta) throws SlickException {

		// early updates
		for (GameObject o : obj) {
			o.earlyUpdate();
		}

		// physics update

		// reg updates
		for (GameObject o : obj) {
			o.update();
		}

	}

	public static void main(String[] args) {

		try {

			AppGameContainer gc = new AppGameContainer(new Main(NAME));
			gc.setDisplayMode(SCREENWIDTH, SCREENHEIGHT, false);
			gc.setTargetFrameRate(FRAMERATE);
			gc.start();

		} catch (SlickException e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}//end of main
        
        /**
         * removeGameObject
         * removes the GameObject from the array list
         * @param toRemove what the undesirable GameObject is
         */
        public void removeGameObject(GameObject toRemove){
            for(int a = 0; a < obj.size(); a++){
                if(obj.get(a) == toRemove){
                    obj.remove(a);
                    return;
                }
            }
        }

}//end of class
