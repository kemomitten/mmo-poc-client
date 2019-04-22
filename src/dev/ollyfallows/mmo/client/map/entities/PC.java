package dev.ollyfallows.mmo.client.map.entities;

import java.awt.Image;

import dev.ollyfallows.mmo.client.input.GraphicsHandler;

public class PC extends Entity{

	public PC(double x, double y, double w, double h) {
		super(x, y, w, h, null);
		Image img = GraphicsHandler.instance.getImage("player");
		setImg(img);
	}

}
