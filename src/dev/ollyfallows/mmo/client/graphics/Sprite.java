package dev.ollyfallows.mmo.client.graphics;

import java.awt.Graphics2D;
import java.awt.Image;

import dev.ollyfallows.mmo.client.NetworkEngine;

public class Sprite {
	
	protected String id = "";
	private double x,y,w,h;
	protected Image img;
	
	public Sprite(double x, double y, double w, double h, Image img) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.img = img;
	}
	
	public double getX() {return x;}
	public double getY() {return y;}
	public Image getImg() {return img;}
	
	public void setX(double x) {
		this.x = x;
		NetworkEngine.sendMsg("{'event':'update','id':'"+id+"','prop':'x','x':'"+x+"'}");
	}
	public void setY(double y) {
		this.x = x;
		NetworkEngine.sendMsg("{'event':'update','id':'"+id+"','prop':'y','y':'"+y+"'}");
	}
	
	public void draw(Graphics2D g2, int width, int height) {
		if (x+w <= 0)
			if (y+h <= 0)
				if (x > width)
					if (y > height)
						return;
		g2.drawImage(img, (int)x, (int)y, (int)w, (int)h, null);
	}
}
