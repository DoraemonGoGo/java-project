package pro1;

import java.awt.*;
import javax.swing.*;

public class BallGame2 extends JFrame {
	
	Image ball2=Toolkit.getDefaultToolkit().getImage("images/ball2.png");
	Image desk=Toolkit.getDefaultToolkit().getImage("images/desk.png");
	
	double x=70;
	double y=70;
	
	double degree=3.14/3;
	
	//�����ڵķ���
	public void paint(Graphics g){
		System.out.println("���ڱ�����һ�Σ�");
		g.drawImage(desk,0,0,null);
		g.drawImage(ball2,(int)x,(int)y,null);
		
		x=x+9*Math.cos(degree);
		y=y+9*Math.sin(degree);
		
		if(y>600-85||y<60) {
			degree=-degree;
		}
		
		if(x>1210-90||x<58) {
			degree=3.14-degree;
		}
	}
	//���ڼ���

	void launchFrame() {
		setSize(1210,600);
		setLocation(50,50);
		setVisible(true);
		//�ػ�����
		while(true) {
			repaint();
			try {
				Thread.sleep(20);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

	//main�����ǳ���ִ�е����
	public static void main(String[] args) {
		System.out.println("���Ƿ��Σ�����˧��");
		BallGame2 game=new BallGame2();
		game.launchFrame();
	}
}

