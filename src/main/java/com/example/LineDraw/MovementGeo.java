package com.example.LineDraw;
import java.util.Random;

//Parts of this class are from a YouTube Tutorial
public abstract class MovementGeo extends MovementAbs{ 

    int max;
	int auto;

    public void updateDirection(boolean b) {
		Random r = new Random();
		if(auto % max == 0) {
		    max = r.nextInt(5)*5+5;
			int direction = r.nextInt(4);
			switch(direction) {
                case 0: left = true; up = false; right = false; down = false; break;
                case 1: left = false; up = true; right = false; down = false; break;
                case 2: left = false; up = false; right = true; down = false; break;
                case 3: left = false; up = false; right = false; down = true; break;
			} direction = r.nextInt(4);
			switch(direction) {
                case 0: if (!right) { left = true; }	break;
                case 1: if (!down) { up = true; } break;
                case 2: if (!left) { right = true; } break;
                case 3: if (!up) { down = true;} break;
			}
		} max++;
	}

}