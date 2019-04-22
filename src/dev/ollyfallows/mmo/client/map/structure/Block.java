package dev.ollyfallows.mmo.client.map.structure;

import java.awt.Image;

import dev.ollyfallows.mmo.client.graphics.Sprite;

public class Block extends Sprite{
	
	private boolean collidable=true;
	
	public Block(double x, double y, double w, double h, Image img) {
		super(x, y, w, h, img);
	}
	
	public boolean isCollidable() {return collidable;}
	public void setCollidable(boolean c) {
		this.collidable = c;
	}
}
