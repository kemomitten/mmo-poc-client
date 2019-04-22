package dev.ollyfallows.mmo.client.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import dev.ollyfallows.mmo.client.map.entities.PC;

public class KeyboardHandler implements KeyListener{
	
	private PC pc;
	
	public KeyboardHandler(PC pc) {
		this.pc = pc;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_W:
			pc.setDY(-1);
			break;
		case KeyEvent.VK_A:
			pc.setDX(-1);
			break;
		case KeyEvent.VK_S:
			pc.setDY(1);
			break;
		case KeyEvent.VK_D:
			pc.setDX(1);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_W:
			pc.setDY(0);
			break;
		case KeyEvent.VK_A:
			pc.setDX(0);
			break;
		case KeyEvent.VK_S:
			pc.setDY(0);
			break;
		case KeyEvent.VK_D:
			pc.setDX(0);
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
