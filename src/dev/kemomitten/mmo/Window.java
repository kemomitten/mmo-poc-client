package dev.kemomitten.mmo;

import javax.swing.JFrame;

public class Window extends JFrame{
	
	public Window(GraphicsEngine ge) {
		super("MMO - Client");
		setContentPane(ge);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
