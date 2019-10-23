package me.trio;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Wall implements GameObject{

	public Wall(Vector2D start, Vector2D end) {
		this.start = start;
		this.end = end;
	}
	
	Vector2D start;
	Vector2D end;
	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void earlyUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lateUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnable(boolean enable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRender(Graphics graphic) {
		// TODO make line.
		graphic.setColor(Color.blue);
		graphic.drawLine(start.x,start.y,end.x,end.y);
	}

}
