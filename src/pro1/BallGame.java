package pro1;

import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame {
	
	Image ball2=Toolkit.getDefaultToolkit().getImage("images/ball2.png");
	Image desk=Toolkit.getDefaultToolkit().getImage("images/desk.png");
	
	double x=70;
	double y=70;
	boolean right=true;
	//�����ڵķ���
	public void paint(Graphics g){
		System.out.println("���ڱ�����һ�Σ�");
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
		BallGame game=new BallGame();
		game.launchFrame();
	}
}
