package me.trio.ai;

import me.trio.Vector2D;

public class Intelligence {
	
	public static final int MAXMOVES = 5000;
	public static Intelligence[] entities;
	
	private MoveSet[] moves;
	public float fitness = 0;
	public Vector2D location = null;
	
	public Intelligence(MoveSet[] m) {
		moves = m;
	}
	
	public MoveSet[] getMoveset() {
		return moves;
	}
	
}
