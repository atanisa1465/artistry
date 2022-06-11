package com.example.LineDraw;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Parts of this class are from a YouTube Tutorial

public class KeyMethods implements KeyListener {
    private boolean right = false;
	private boolean left = false;
	private boolean up = false;
	private boolean down = false;
	private boolean reset = false;
	private boolean canWrite = true;
	
	private int FPSChanger = 0;
	private int FPSInterval = 5;
	private int maxFPSChange = 30;
	
	boolean iaActivated = false;
	
	private int lastDirection = KeyEvent.VK_RIGHT;
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(e.getKeyChar() == 'r') {
			reset = true;
		}
		if(e.getKeyChar() == 'i') iaActivated = !iaActivated;
		if(key == KeyEvent.VK_SPACE) canWrite = !canWrite;
		if(key == KeyEvent.VK_LEFT) { left = true; lastDirection = key; } 
		else if (key == KeyEvent.VK_RIGHT) { right = true; lastDirection = key; } 
		else if (key == KeyEvent.VK_UP) { up= true; }
		else if(key == KeyEvent.VK_DOWN) { down = true; }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (e.getKeyChar() == 'r') {
			reset = false;
		}
		if(key == KeyEvent.VK_LEFT) left = false;
		else if(key == KeyEvent.VK_RIGHT) right = false;
		else if(key == KeyEvent.VK_UP) { up= false; }
		else if(key == KeyEvent.VK_DOWN) down= false;
	}

	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar() == '+' && maxFPSChange-FPSInterval >= FPSChanger) FPSChanger += FPSInterval;
		if(e.getKeyChar() == '-' && -maxFPSChange+FPSInterval <= FPSChanger) FPSChanger -= FPSInterval;
	}
	
	public int getFPSInterval() { return FPSInterval; }
	public boolean isLeft() { return left; }
	public boolean isRight() { return right; }
	public boolean isUp() { return up; }
	public boolean isDown() { return down; }
	public boolean hasToReset() { return reset;	}
	public int getLastDirection() { return lastDirection; }	
	public boolean canWrite() { return canWrite; }
	public int getFPSChanger() { return FPSChanger; }
	public boolean isIAActivated() { return iaActivated; }
	public void setRight(boolean right) { this.right = right; }
	public void setleft(boolean left) { this.left = left; }
	public void setup(boolean up) { this.up = up; }
	public void setdown(boolean down) { this.down = down; }
	public void setReset(boolean reset) { this.reset = reset; }
	public void setCanWrite(boolean canWrite) { this.canWrite = canWrite; }
	public void setFPSChanger(int fPSChanger) { FPSChanger = fPSChanger; }
	public void setFPSInterval(int fPSInterval) { FPSInterval = fPSInterval; }
	public void setMaxFPSChange(int maxFPSChange) { this.maxFPSChange = maxFPSChange; }
	public void setIA_Activated(boolean iA_Activated) { iaActivated = iA_Activated; }
	public void setLastDirection(int lastDirection) { this.lastDirection = lastDirection; }

}