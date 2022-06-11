package com.example.LineDraw;

//Parts of this class are from a YouTube Tutorial

public abstract class MovementAbs {
    boolean left;
	boolean up;
	boolean right;
	boolean down;
    
    public abstract void updateDirection();
	public boolean getLeft() { return left; }
	public boolean getUp() { return up; }
	public boolean getRight() { return right; }
	public boolean getDown() { return down; } 
}