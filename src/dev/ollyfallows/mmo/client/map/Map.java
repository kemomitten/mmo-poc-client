package dev.ollyfallows.mmo.client.map;

import java.util.ArrayList;

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
}
