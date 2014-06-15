package jp.libroworks;

import java.awt.Graphics2D;

public class GraphicsInfo {

	public Graphics2D g;
	public double frametime;
	public long currenttime;
	public boolean[] keystate;
	
	public GraphicsInfo(){
		 this.keystate = new boolean[8];
		 
		 for(int i=0; i<8; i++){
			 this.keystate[i] = false;
		 }
	}
}
