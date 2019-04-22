package dev.ollyfallows.mmo.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import dev.ollyfallows.mmo.client.map.Map;

public class Game implements ActionListener{
	
	private int width,height,fps;
	private GraphicsEngine ge;
	private Window win;
	private Timer ticker;
	private boolean processing = false;
	private long lastTime = System.currentTimeMillis();
	
	private Map map = new Map();
	
	public Game(int width, int height, int fps) {
		this.width = width;
		this.height = height;
		this.fps = fps;
		ge = new GraphicsEngine(width, height);
		
		win = new Window(ge);
		
		ticker = new Timer(1000/fps, this);
		ticker.start();
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ticker)) {
			if(processing) return;
			processing = true;
			
			long delta = System.currentTimeMillis()-lastTime;
			delta /= 1000;
			lastTime = System.currentTimeMillis();
			
			updatePreLoop(delta);
			updateLoop(delta);
			win.repaint();
			updatePostLoop(delta);
			
			processing = false;
		}
	}	
	
	public void updatePreLoop(long delta) {
		
	}
	public void updateLoop(long delta) {
		
	}
	public void updatePostLoop(long delta) {
		
	}
}
