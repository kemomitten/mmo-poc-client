package dev.kemomitten.mmo.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Timer;

import dev.ollyfallows.mmo.client.graphics.Sprite;
import dev.ollyfallows.mmo.client.input.KeyboardHandler;
import dev.ollyfallows.mmo.client.map.Map;
import dev.ollyfallows.mmo.client.map.entities.Entity;
import dev.ollyfallows.mmo.client.map.entities.PC;

public class Game implements ActionListener{

	private Window win;
	private GraphicsEngine ge;
	private NetworkEngine ne = new NetworkEngine();
	private PhysicsEngine pe = new PhysicsEngine();
	
	private int width,height,fps;
	private Timer ticker;
	private boolean processing = false;
	private long lastTime = System.currentTimeMillis();
	
	private Entity pc;
	
	public Game(int width, int height, int fps) {
		this.width = width;
		this.height = height;
		this.fps = fps;
		ge = new GraphicsEngine(width, height);
		
		win = new Window(ge);
		
		// Load player
		pc = new PC(0,0,32,32);
		pe.getMap().addEntity(pc);
		
		// Add input listeners
	    ge.setFocusable(true);
	    ge.addKeyListener(new KeyboardHandler((PC)pc));
	    
	    ge.requestFocusInWindow();
		
		ticker = new Timer(1000/fps, this);
		ticker.start();
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ticker)) {
			if(processing) return;
			processing = true;
			
			double delta = System.currentTimeMillis()-lastTime;
			delta /= 1000;
			lastTime = System.currentTimeMillis();
			
			updatePreLoop(delta);
			updateLoop(delta);
			draw();
			updatePostLoop(delta);
			
			processing = false;
		}
	}	
	
	public void updatePreLoop(double delta) {
		for(Sprite s : pe.getMap().getBlocks()) {
			s.resetChanged();
		}
		for(Sprite s : pe.getMap().getEntities()) {
			s.resetChanged();
		}
		pe.getMap().updateMap();
	}
	
	public void updateLoop(double delta) {
		pe.update(delta);
	}
	
	public void draw() {
		ge.emptySprites();
		ge.addSprites(pe.getMap().getSprites());
		win.repaint();
	}
	
	public void updatePostLoop(double delta) {
		pe.getMap().updateServer();
	}
}
