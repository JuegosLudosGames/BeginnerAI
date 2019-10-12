package me.trio;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class EndPoint implements GameObject{

	private Vector2D coords;
	public EndPoint(Vector2D tempVector) {
        coords = tempVector;
	}
	
	@Override
	public void start() {
        earlyUpdate();
	}

	@Override
	public void earlyUpdate() {
		update();
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		lateUpdate();
	}

	@Override
	public void lateUpdate() {
		// TODO Auto-generated method stub
		onEnable();
	}

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		setEnable(true);
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
		// TODO Auto-generated method stub
        graphic.setColor(Color.blue);
        graphic.drawOval(coords.x, coords.y, 20, 20);
	}

}
