package dev.ollyfallows.mmo.client.input;

import java.awt.Image;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class GraphicsHandler {
	
	private static HashMap<String, Image> images = new HashMap<String, Image>();
	public static final GraphicsHandler instance = new GraphicsHandler();
	
	public Image getImage(String name) {
		if (images.containsKey(name)) {
			return (Image)images.get(name);
		}
		try {
			Image img = ImageIO.read(getClass().getClassLoader().getResource("dev/ollyfallows/mmo/client/assets/images/"+name+".png"));
			images.put(name, img);
			return img;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
