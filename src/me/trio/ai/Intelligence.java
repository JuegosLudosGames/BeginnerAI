package me.trio.ai;


public class Intelligence {
	
	private static final int MAXMOVES = 5000;
	private static Intelligence[] entities;
	
	private MoveSet[] moves;
	public int fitness = 0;
	
	public Intelligence(MoveSet[] m) {
		moves = m;
	}
	
	public MoveSet[] getMoveset() {
		return moves;
	}
	
}
