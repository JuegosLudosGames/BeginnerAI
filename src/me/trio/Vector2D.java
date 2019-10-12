package me.trio;

public class Vector2D {

	public Vector2D(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public float x;
	public float y;
	
	/**
	 * Returns the euler's distance between 2 Vector points
	 * @param start The start point for measurement
	 * @param end The end point for measurement
	 * @return the distance between the points
	 */
	public static float distance(Vector2D start, Vector2D end) {
		return (float)Math.sqrt( Math.pow( end.x - start.x, 2 ) + Math.pow( end.y - start.y, 2 ));
	}
}
