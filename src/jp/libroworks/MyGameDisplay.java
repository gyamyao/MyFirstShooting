package jp.libroworks;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jp.libroworks.surper.GameDisplay;

public class MyGameDisplay extends GameDisplay {
	
	GameDisplay title, main, over, clear;
	
	private Font mfont = new Font("Sanserif" , Font.BOLD , 50);
	
	public MyGameDisplay() {
		this.title = new MyGameTitle();
		this.main = new MyGameMain();
		this.over = new MyGameOver();
		this.clear = new MyGameClear();
		GameDisplay.current = this.title;
	}

	@Override
	public void show(GraphicsInfo ginfo) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void loadMedia() throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		this.title.loadMedia();
		this.main.loadMedia();
		this.over.loadMedia();
		this.clear.loadMedia();
	}
	
	//title
	class MyGameTitle extends GameDisplay{

		private BufferedImage img_title;
		@Override
		public void show(GraphicsInfo ginfo) {
			// TODO 自動生成されたメソッド・スタブ
			ginfo.g.drawImage(this.img_title, 0, 0, null);
			ginfo.g.setColor(Color.CYAN);
			ginfo.g.setFont(MyGameDisplay.this.mfont);
			
			String str = "PUSH SPACE";
			FontMetrics fm = ginfo.g.getFontMetrics();
			int strm = fm.stringWidth(str)/2;
			ginfo.g.drawString(str, 400-strm, 600);
			
			if(ginfo.keystate[KEY_STATE.SPACE]){
				GameDisplay.current = MyGameDisplay.this.main;
			}
		}

		@Override
		public void loadMedia() throws IOException {
			// TODO 自動生成されたメソッド・スタブ
			this.img_title = ImageIO.read(new File("media/media/title.jpg"));
		}
		
	}

	//main
	class MyGameMain extends GameDisplay{

		@Override
		public void show(GraphicsInfo ginfo) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

		@Override
		public void loadMedia() {
			// TODO 自動生成されたメソッド・スタブ
			
		}}

	//game over
	class MyGameOver extends GameDisplay{

		@Override
		public void show(GraphicsInfo ginfo) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

		@Override
		public void loadMedia() {
			// TODO 自動生成されたメソッド・スタブ
			
		}
		
	}

	//stage clear
	class MyGameClear extends GameDisplay{

		@Override
		public void show(GraphicsInfo ginfo) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

		@Override
		public void loadMedia() {
			// TODO 自動生成されたメソッド・スタブ
			
		}}
}
