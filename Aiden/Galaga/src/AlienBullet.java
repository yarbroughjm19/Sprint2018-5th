import java.awt.Color;
import java.awt.Graphics;


public class AlienBullet {
	private double x,y,vY;
	public static final int SIZE = 10;
	int age;
	
	public AlienBullet(double aX, double aY){
		x = aX+17;
		y = aY;
		vY = 800/50;
		if(age==45){
			y = aY;
			age = 0;
		}
	}
	
	public void shoot(Graphics g) {
		y += vY;
		g.setColor(Color.GRAY);
		g.fillOval((int) x, (int)y+65, SIZE, SIZE);
	}
	public void updateBullet(double dY){
		y += (vY+dY)/50;
		age++;
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
}
