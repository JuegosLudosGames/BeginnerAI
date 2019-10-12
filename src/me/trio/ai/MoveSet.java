package me.trio.ai;

import java.util.Random;

public enum MoveSet {
	UP, DOWN, LEFT, RIGHT;
	
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
