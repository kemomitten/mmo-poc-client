package dev.kemomitten.mmo.map.entities;

import dev.kemomitten.mmo.map.Sprite;

public class Entity extends Sprite{
	
	public Entity() {}
	public Entity(double x, double y, double w, double h) {
		super(x, y, w, h);
	}

	public boolean proccessState(String[] argv) {
		System.out.println("hi");
		return super.proccessState(argv);
	}
}
