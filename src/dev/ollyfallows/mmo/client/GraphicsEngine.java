package dev.ollyfallows.mmo.client;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import dev.ollyfallows.mmo.client.graphics.Sprite;

public class GraphicsEngine extends JPanel{
	
	private int width,height;
	
	private ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	
	public GraphicsEngine(int width, int height) {
		this.width = width;
		this.height = height;
		setPreferredSize(new Dimension(width, height));
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.clearRect(0, 0, width, height);
		for(Sprite s : sprites) {
			s.draw(g2, width, height);
		}
	}
	
	public void removeSprite(Sprite sprite) {
		sprites.remove(sprite);
		sprites.trimToSize();
	}
	public void addSprite(Sprite sprite) {
		if (sprites.contains(sprite)) return;
		sprites.add(sprite);
	}
	public void emptySprites() {
		sprites.clear();
	}
	public void addSprites(ArrayList<Sprite> s) {
		sprites.addAll(s);
	}
}
