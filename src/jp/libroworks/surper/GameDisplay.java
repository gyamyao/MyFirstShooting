package jp.libroworks.surper;

import java.io.IOException;

import jp.libroworks.GraphicsInfo;

public abstract class GameDisplay {

	protected static GameDisplay current = null;
	
	//getter
	public GameDisplay getCurrentDisplay() {
		
		return GameDisplay.current;
	}
	
	//display
	public abstract void show(GraphicsInfo ginfo);
	
	//media
	public abstract void loadMedia() throws IOException;
}
