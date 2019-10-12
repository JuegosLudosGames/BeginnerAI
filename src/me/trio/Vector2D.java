package me.trio;

public class Vector2D {

	public Vector2D(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public float x;
	public float y;
        
        public Vector2D cloneVector(){
            return new Vector2D(x, y);
        }
}
