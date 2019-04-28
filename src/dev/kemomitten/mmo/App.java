package dev.kemomitten.mmo;

import dev.kemomitten.mmo.map.entities.Entity;

public class App {
	
	public static int WIDTH=400,HEIGHT=300;
	
	public static void main(String[] args) {
		Game game = new Game(WIDTH, HEIGHT, 60);
	}
}
