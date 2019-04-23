package dev.ollyfallows.mmo.client.graphics;

import java.awt.Graphics2D;
import java.awt.Image;

import dev.kemomitten.mmo.client.NetworkEngine;

public class Sprite {
	
	protected String id = "asdf";
	private boolean xChanged=false,yChanged=false,wChanged=false,hChanged=false;
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
	public String getId() {return id;}
	
	public void setX(double x) {
		if (this.x != x) {
			xChanged = true;
		}
		this.x = x;
	}
	public void setY(double y) {
		if (this.y != y) {
			yChanged = true;
		}
		this.y = y;
	}
	public void setW(double w) {
		if (this.w != w) {
			wChanged = true;
		}
		this.w = w;
	}
	public void setH(double h) {
		if (this.h != h) {
			hChanged = true;
		}
		this.h = h;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	
	public void draw(Graphics2D g2, int width, int height) {
		if (x+w <= 0)
			if (y+h <= 0)
				if (x > width)
					if (y > height)
						return;
		g2.drawImage(img, (int)x, (int)y, (int)w, (int)h, null);
	}
	
	public void resetChanged() {
		xChanged = false;
		yChanged = false;
		wChanged = false;
		hChanged = false;
	}
	public void sendChanges() {
		if (xChanged) {
			NetworkEngine.sendMsg("{'event':'update','id':'"+id+"','type':'graphics.Sprite','prop':'x','x':'"+x+"'}");
		}
		if (yChanged) {
			NetworkEngine.sendMsg("{'event':'update','id':'"+id+"','type':'graphics.Sprite','prop':'y','y':'"+y+"'}");
		}
		if (wChanged) {
			NetworkEngine.sendMsg("{'event':'update','id':'"+id+"','type':'graphics.Sprite','prop':'w','w':'"+w+"'}");
		}
		if (hChanged) {
			NetworkEngine.sendMsg("{'event':'update','id':'"+id+"','type':'graphics.Sprite','prop':'h','h':'"+h+"'}");
		}
	}
	
	public void set(String var, String val) {
		if(var.equals("x")) {
			x = Double.parseDouble(val);
		}
		if(var.equals("y")) {
			y = Double.parseDouble(val);
		}
		if(var.equals("w")) {
			w = Double.parseDouble(val);
		}
		if(var.equals("h")) {
			h = Double.parseDouble(val);
		}
	}
}
