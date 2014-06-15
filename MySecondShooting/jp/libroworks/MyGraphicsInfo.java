/**
 * 
 */
package jp.libroworks;

import java.awt.Graphics2D;

/**
 * ステージ内の必要データを保持
 * @author keikokage
 *
 */
public class MyGraphicsInfo {

	/** value
	 ***********/
	
	public boolean[]keystates;
	public double frametime;
	public long currenttime;
	public Graphics2D g;
	
	/** constructor
	 ****************/
	MyGraphicsInfo(){
		this.keystates = new boolean[8];
		//set "false" in each keystates for defalte 
		for(int i = 0; 0 < 8; i++){
			keystates[i] = false;
		}
	}
}
