package dev.ollyfallows.mmo.client.map.entities;

import java.awt.Image;

import dev.kemomitten.mmo.client.NetworkEngine;
import dev.ollyfallows.mmo.client.graphics.Sprite;

public class Entity extends Sprite{
	
	private boolean dxChanged=false, dyChanged=false;
	private double dx=0,dy=0,speed=100;
	
	public Entity(double x, double y, double w, double h, Image img) {
		super(x, y, w, h, img);
	}
	
	public void update(double delta) {
		setX(getX() + dx*speed*delta);
		setY(getY() + dy*speed*delta);
	}
	
	public void setDX(double dx) {
		if (this.dx != dx) dxChanged = true;
		this.dx = dx;
	}
	public void setDY(double dy) {
		if (this.dy != dy) dyChanged = true;
		this.dy = dy;
	}
	public double getDX() {return dx;}
	public double getDY() {return dy;}
	
	@Override
	public void resetChanged() {
		super.resetChanged();
		dxChanged = false;
		dyChanged = false;
	}
	
	@Override
	public void sendChanges() {
		super.sendChanges();
		if (dxChanged) {
			NetworkEngine.sendMsg("{'event':'update','id':'"+id+"','prop':'dx','dx':'"+dx+"'}");
		}
		if (dyChanged) {
			NetworkEngine.sendMsg("{'event':'update','id':'"+id+"','prop':'dy','dy':'"+dy+"'}");
		}
	}
}
