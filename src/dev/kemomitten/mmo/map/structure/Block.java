package dev.kemomitten.mmo.map.structure;

import java.awt.Color;
import java.awt.Graphics2D;

import dev.kemomitten.mmo.map.Sprite;

public class Block extends Sprite{
	
	public Block() {}
	public Block(double x, double y, double w, double h) {
		super(x, y, w, h);
	}
	
	
	@Override
	public void paint(Graphics2D g2) {
		g2.setColor(Color.black);
		g2.fillRect((int)x, (int)y, (int)w, (int)h);
	}
}
