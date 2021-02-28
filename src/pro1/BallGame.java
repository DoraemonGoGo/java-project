package pro1;

import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame {
	
	Image ball2=Toolkit.getDefaultToolkit().getImage("images/ball2.png");
	Image desk=Toolkit.getDefaultToolkit().getImage("images/desk.png");
	
	double x=70;
	double y=70;
	boolean right=true;
	//画窗口的方法
	public void paint(Graphics g){
		System.out.println("窗口被画了一次！");
		g.drawImage(desk,0,0,null);
		g.drawImage(ball2,(int)x,(int)y,null);
		
		if(right) {
			x=x+9;
		}
		else {
			x=x-9;
		}
		
		if(x>1116) {
			right=false;
		}
		if(x<50) {
			right=true;
		}
	}
	//窗口加载

	void launchFrame() {
		setSize(1210,600);
		setLocation(50,50);
		setVisible(true);
		//重画窗口
		while(true) {
			repaint();
			try {
				Thread.sleep(20);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

	//main方法是程序执行的入口
	public static void main(String[] args) {
		System.out.println("我是方涛，我最帅！");
		BallGame game=new BallGame();
		game.launchFrame();
	}
}
