package dev.kemomitten.mmo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.Timer;

import dev.kemomitten.mmo.input.KeyboardHandler;
import dev.kemomitten.mmo.map.Map;
import dev.kemomitten.mmo.map.Sprite;
import dev.kemomitten.mmo.map.entities.Entity;
import dev.kemomitten.mmo.map.structure.Block;

public class Game implements ActionListener{

	private Window win;
	private GraphicsEngine ge;
	private NetworkEngine ne;
	
	private int width,height,fps;
	private Timer ticker;
	private boolean processing = false;
	private long lastTime = System.currentTimeMillis();
	
	private Map map;
	
	public static String uid = "";
	
	public Game(int width, int height, int fps) {
		this.width = width;
		this.height = height;
		this.fps = fps;
		ge = new GraphicsEngine(width, height);
		
		map = new Map();
		
		ge.setMap(map);
		
		ne = new NetworkEngine();
		
		win = new Window(ge);
		
		// Add input listeners
	    ge.setFocusable(true);
	    ge.addKeyListener(new KeyboardHandler());
	    
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
		// Get server events
		String line;
		while ((line = ne.getMsg()) != null) {
			boolean skip = false;
			String[] argv = line.split(",");
			Class type = null;
			if(argv.length >= 3) {
				try {
					type = Class.forName(argv[2]);
				}catch(ClassNotFoundException e) {
					for(String s : argv) {
						System.out.println("argv : "+s);
					}
					e.printStackTrace();
					skip = true;
				}
			}
			try {
				if(!skip) {
					switch(argv[0]) {
					case "remove":
						map.removeSprite(argv[1]);
						break;
					case "add":
						Object obj = type.newInstance();
						if(obj instanceof Sprite) {
							if(obj instanceof Block) {
								map.addBlock(argv[1], (Block)obj);
							}
							if(obj instanceof Entity) {
								map.addEntity(argv[1], (Entity)obj);
							}
						}else {
							System.err.println("Tried to instance non sprite sub-class object. Class: "+argv[2]);
						}
					case "update":
						((Sprite) type.cast(map.getSprite(argv[1]))).proccessState(Arrays.copyOfRange(argv, 3, argv.length));
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// Get user events
		
		// Send user events
		
	}
	
	public void updateLoop(double delta) {
		// Update process events
		
	}
	
	public void draw() {
		// Update the screen
		win.repaint();
	}
	
	public void updatePostLoop(double delta) {
		// Clean up
	}
}
