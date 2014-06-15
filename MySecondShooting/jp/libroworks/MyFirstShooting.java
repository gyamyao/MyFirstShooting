package jp.libroworks;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class MyFirstShooting {
	
	/** main
	 ***********/
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		MyFirstShooting fst = new MyFirstShooting();
		fst.start();
	}

	/** value
	 ***********/
	JFrame mainwindow;		//window
	BufferStrategy strategy;//drew	
	
	
	
	/** constructor
	 ****************/
	MyFirstShooting() {	
		/**
		 * window
		 */
		this.mainwindow = new JFrame("シューティング");
		this.mainwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainwindow.setSize(800, 720);
		this.mainwindow.setLocationRelativeTo(null);
		this.mainwindow.setVisible(true);
		this.mainwindow.setResizable(false);
		/**
		 * draw
		 */
		this.mainwindow.setIgnoreRepaint(true);
		this.mainwindow.createBufferStrategy(2);
		this.strategy = this.mainwindow.getBufferStrategy();
		/**
		 * keybord
		 */
		this.mainwindow.addKeyListener(new MyKeyAsaptor());
	}	
	MyGraphicsInfo ginfo = new MyGraphicsInfo();
	long lasttime = System.currentTimeMillis();
//*************private method***********
	//**************start....**************//		
	private void render(){
		
		//time　span for one frame
		long time = System.currentTimeMillis();
		this.ginfo.frametime = (time - this.lasttime)*0.001; //SEC →　MIN
		this.lasttime = time;
		this.ginfo.currenttime = time;
		
		// get instance for Graphics2D
		Graphics2D g = (Graphics2D)this.strategy.getDrawGraphics();
		
		/**
		 * this setting for window
		 */
		g.setBackground(Color.black);
		g.clearRect(0, 0, this.mainwindow.getWidth(), this.mainwindow.getHeight());
		
		//save Graphics2D_datas into MyGraphicsInfo class before delete
		this.ginfo.g = g;
		//order to show Graphics2D
		g.dispose();
		this.strategy.show();
	}

	private void start() {
		// TODO 自動生成されたメソッド・スタブ
		Timer timer = new Timer();
		timer.schedule(new RenderTask(), 0, 16);
	}
	//**************....end**************//	
	
//*************inner class***********
	//**************start....**************//	
	/***
	 * inner class:[time controll]
	 * @author keikokage
	 *
	 */
	class RenderTask extends TimerTask {

		@Override
		public void run() {
			// TODO 自動生成されたメソッド・スタブ
			//display graphics
			MyFirstShooting.this.render();
		}		
	}
	
	/***
	 * inner class:[key controll]
	 * combine with "MY_KEY_STATE class"
	 * @author keikokage
	 *
	 */
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

		/**
		 * @param keyCode
		 * @param b
		 */
		private void setValue(int keyCode, boolean b) {
			// TODO 自動生成されたメソッド・スタブ
			boolean[] keystates = MyFirstShooting.this.ginfo.keystates;
			
			switch (keyCode) {
			case KeyEvent.VK_LEFT:
				keystates[MY_KEY_STATE.LEFT] = b;
				break;
			case KeyEvent.VK_RIGHT:
				keystates[MY_KEY_STATE.RIGT] = b;
				break;
			case KeyEvent.VK_UP:
				keystates[MY_KEY_STATE.UP] = b;
				break;
			case KeyEvent.VK_DOWN:
				keystates[MY_KEY_STATE.DOWN] = b;
				break;
			case KeyEvent.VK_Z:
				keystates[MY_KEY_STATE.Z] = b;
				break;
			case KeyEvent.VK_X:
				keystates[MY_KEY_STATE.C] = b;
				break;
			case KeyEvent.VK_C:
				keystates[MY_KEY_STATE.X] = b;
				break;
			case KeyEvent.VK_SPACE:
				keystates[MY_KEY_STATE.SPACE] = b;
				break;

			default:
				break;
			}
		}
	}
	//**************....end**************//	
}
