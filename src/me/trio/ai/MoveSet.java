package me.trio.ai;

import java.util.Random;

/**
 * 
 * Enum for possible moves
 * @author Kyle
 *
 */
public enum MoveSet {
	/**
	 * An up movement
	 */
	UP,
	/**
	 * A down movement
	 */
	DOWN, 
	/**
	 * A left movement
	 */
	LEFT, 
	/**
	 * A right movement
	 */
	RIGHT;
	
	/**
	 * generates a random move using random generator
	 * @param rnd the generator
	 * @return the generated move
	 */
	public static MoveSet getRandom(Random rnd) {
		switch (rnd.nextInt(4)) {
		case 0:
			return UP;
		case 1:
			return DOWN;
		case 2:
			return LEFT;
		case 3:
			return RIGHT;
		default:
			return UP;
		}
	}
}
