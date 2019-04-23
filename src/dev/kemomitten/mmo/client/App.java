package dev.kemomitten.mmo.client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
	
	public static int WIDTH=400,HEIGHT=300;
	
	public static void main(String[] args) {
		Game game = new Game(WIDTH, HEIGHT, 60);
	}
}
