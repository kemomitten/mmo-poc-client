package dev.kemomitten.mmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import dev.kemomitten.mmo.map.Map;

public class GraphicsEngine extends JPanel{
	
	private int width,height;
	private Map map = null;
	
	public GraphicsEngine(int width, int height) {
		this.width = width;
		this.height = height;
		setPreferredSize(new Dimension(width, height));
	}
	
	public void setMap(Map map) {
		this.map = map;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		map.paint(g2);
	}
}
