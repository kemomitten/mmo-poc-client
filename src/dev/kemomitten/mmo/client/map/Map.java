package dev.ollyfallows.mmo.client.map;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dev.kemomitten.mmo.client.NetworkEngine;
import dev.ollyfallows.mmo.client.graphics.Sprite;
import dev.ollyfallows.mmo.client.map.entities.Entity;
import dev.ollyfallows.mmo.client.map.structure.Block;

public class Map {
	
	private ArrayList<Block> blocks = new ArrayList<Block>();
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	
	public Map() {}
	public Map(ArrayList<Block> blocks, ArrayList<Entity> entities) {
		this.blocks = blocks;
		this.entities = entities;
	}
	
	public void updateMap() {
		try {
			Pattern p = Pattern.compile("'([a-zA-Z0-9]+?)':'([a-zA-Z0-9\\.]+?)'");
			String msg = null;
			while((msg = NetworkEngine.getMsg()) != null) {
				
				System.out.println("msg: "+msg);
				
				HashMap<String, String> properties = new HashMap<String, String>();
				
				Matcher m = p.matcher(msg);
				while(m.find()) {
					properties.put(m.group(1), m.group(2));
				}
				
				System.out.println(properties.keySet());
				
				if (properties.containsKey("type") && properties.containsKey("id") && properties.containsKey("event")) {
					System.out.println("Valid");
					Class<?> type = Class.forName("dev.ollyfallows.mmo.client."+properties.get("type"));
					String id = properties.get("id");
					
					switch(properties.get("event")) {
					case "update":
						Sprite obj = getSpriteById(id);
						obj.set(properties.get("prop"), properties.get(properties.get("prop")));
						break;
					case "add":
						break;
					case "remove":
						break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void updateServer() {
		
	}
	
	public void addBlock(Block b) {
		blocks.add(b);
	}
	public void delBlock(Block b) {
		blocks.remove(b);
	}
	public void addBlocks(ArrayList<Block> b) {
		blocks.addAll(b);
	}
	public void delBlocks(ArrayList<Block> b) {
		blocks.removeAll(b);
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	public void delEntity(Entity e) {
		entities.remove(e);
	}
	public void addEntities(ArrayList<Entity> e) {
		entities.addAll(e);
	}
	public void delEntities(ArrayList<Entity> e) {
		entities.removeAll(e);
	}
	
	public ArrayList<Block> getBlocks(){
		return blocks;
	}
	public ArrayList<Entity> getEntities(){
		return entities;
	}
	
	public Entity getEntityById(String id) {
		for (Entity e : entities) {
			if (e.getId().equals(id)) {
				return e;
			}
		}
		return null;
	}
	public Block getBlockById(String id) {
		for (Block b : blocks) {
			if (b.getId().equals(id)) {
				return b;
			}
		}
		return null;
	}

	public ArrayList<Sprite> getSprites(){
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.addAll(getBlocks());
		sprites.addAll(getEntities());
		return sprites;
	}
	public Sprite getSpriteById(String id) {
		System.out.println("Searching");
		for (Sprite s : getSprites()) {
			if(s.getId().equals(id)) {
				return s;
			}
		}
		System.out.println("Not Found: "+id);
		return null;
	}
}
