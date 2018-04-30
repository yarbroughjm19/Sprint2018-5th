import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	private double x,y,vX,vY;
	int age;
		
	public Bullet(double c, double d){
			age = 0;
			x = MainClass.WIDTH/2;
			y = MainClass.HEIGHT-50;
			this.vY = c;
			this.vX = d;
			update(0);
			update(0);
		}
	
	public void draw(Graphics g){
			g.setColor(Color.red);
			g.fillOval((int)x+5, (int) y-9, 10, 10);
		}
	
	public void update(double dY){
			x = vX;
			y += -(vY+dY)/50;
			age++;
		}
	public double getAge(){
		return age;
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
}
