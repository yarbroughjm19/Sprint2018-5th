import java.awt.Color;
import java.awt.Graphics;


public class Aliens {
	
	private double x,y;
	public static final int WIDTH = 50;
	public static final int HEIGHT = 50;
	
	public Aliens(double y){
		this.x = Math.random()*(MainClass.WIDTH-WIDTH);
		if(y>600)y=600;
		if(y<75)y=75;
		this.y = y;
	}
	
	public void draw(Graphics g){
		g.setColor(new Color(0xFA8107));
		g.fillRect((int)x, (int)y, HEIGHT, WIDTH);
		g.setColor(new Color(0x07FABD));
		g.fillOval((int)x+30, (int)y+10, 10, 10);
		g.fillOval((int)x+10, (int)y+10, 10, 10);
	}
	
	public boolean hit(Bullet b){
		double dX = WIDTH/2 + this.x-b.getX();
		double dY = HEIGHT/2 + this.y-b.getY();
		return Math.sqrt(dX*dX+dY*dY)<WIDTH;
	}
	
	public double getY(){
		return y;
	}
	public double getX(){
		return x;
	}
}
