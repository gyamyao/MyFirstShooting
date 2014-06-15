package jp.libroworks;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FirstShooting {
	
	JFrame mainwindow;		//window
	BufferStrategy strategy;//drew
	
	MyGameDisplay display = new MyGameDisplay();

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//FirstShooting instance
		FirstShooting sft = new FirstShooting();
		sft.start();
	}

	private void start() {
		// TODO 自動生成されたメソッド・スタブ
		Timer timer = new Timer();
		timer.schedule(new RenderTask(), 0, 16);
	}

	FirstShooting() {		
		this.mainwindow = new JFrame("シューティング");
		this.mainwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainwindow.setSize(800, 720);
		this.mainwindow.setLocationRelativeTo(null);
		this.mainwindow.setVisible(true);
		this.mainwindow.setResizable(false);
		
		this.mainwindow.setIgnoreRepaint(true);
		this.mainwindow.createBufferStrategy(2);
		this.strategy = this.mainwindow.getBufferStrategy();
		
		this.mainwindow.addKeyListener(new MyKeyAsaptor());
		
		try {
			this.display.loadMedia();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			JOptionPane.showMessageDialog(this.mainwindow, "タイトル画像が見つかりません。");
		}
	}
	
	Long lasttime = System.currentTimeMillis();
	GraphicsInfo ginfo = new GraphicsInfo();
	
	public void render() {
		// TODO 自動生成されたメソッド・スタブ
		long time = System.currentTimeMillis();
		this.ginfo.frametime = (time-lasttime)*0.001;//0.001 is from sc to min
		this.lasttime = time;
		this.ginfo.currenttime = time;
		
		Graphics2D g = (Graphics2D)this.strategy.getDrawGraphics();
		g.setBackground(Color.black);
		g.clearRect(0, 0, this.mainwindow.getWidth(), this.mainwindow.getHeight());
		
		ginfo.g = g;
		
		this.display.getCurrentDisplay().show(ginfo);
		
		g.dispose();
		this.strategy.show();
	}

	
	class RenderTask extends TimerTask {

		@Override
		public void run() {
			// TODO 自動生成されたメソッド・スタブ
			FirstShooting.this.render();
		}
	}
	
	class MyKeyAsaptor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			this.setValue(e.getKeyCode(), true);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			this.setValue(e.getKeyCode(), false);
		}

		private void setValue(int keyCode, boolean b) {
			// TODO 自動生成されたメソッド・スタブ
			boolean[] keystate = FirstShooting.this.ginfo.keystate;
			switch(keyCode){
			case KeyEvent.VK_LEFT:
				keystate[KEY_STATE.LEFT] = b;
				break;
			case KeyEvent.VK_RIGHT:
				keystate[KEY_STATE.RIGHT] = b;
				break;
			case KeyEvent.VK_UP:
				keystate[KEY_STATE.UP] = b;
				break;
			case KeyEvent.VK_DOWN:
				keystate[KEY_STATE.DOWN] = b;
				break;
			case KeyEvent.VK_Z:
				keystate[KEY_STATE.Z] = b;
				break;
			case KeyEvent.VK_X:
				keystate[KEY_STATE.X] = b;
				break;
			case KeyEvent.VK_C:
				keystate[KEY_STATE.C] = b;
				break;
			case KeyEvent.VK_SPACE:
				keystate[KEY_STATE.SPACE] = b;
				break;
			}
			
		}
	}
}

	