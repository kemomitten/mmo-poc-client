package dev.ollyfallows.mmo.client;

import java.util.ArrayList;

import dev.ollyfallows.mmo.client.graphics.Sprite;
import dev.ollyfallows.mmo.client.map.Map;
import dev.ollyfallows.mmo.client.map.entities.Entity;

public class PhysicsEngine {

	private Map map = new Map();
	
	public PhysicsEngine() {
		
	}
	
	public void update(long delta) {
		for (Entity e : map.getEntities()) {
			e.update(delta);
		}
		// Detect collisions
		
	}
	
	public Map getMap() {
		return map;
	}
	
	public ArrayList<Sprite> getSprites(){
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.addAll(map.getBlocks());
		sprites.addAll(map.getEntities());
		return sprites;
	}
}
