package dev.ollyfallows.mmo.client.map.entities;

import java.awt.Image;

import dev.ollyfallows.mmo.client.graphics.Sprite;

public class Entity extends Sprite{
	
	double dx=0,dy=0,speed=1;
	
	public Entity(double x, double y, double w, double h, Image img) {
		super(x, y, w, h, img);
	}
	
	public void update(long delta) {
		setX(getX() + dx*speed*delta);
		setY(getY() + dy*speed*delta);
	}
	
}
