import java.awt.Color;
import java.awt.Graphics;


public class Stars {
	private double x,y;
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	public static final int SPEED = 3;
	private Color myColor;
	
	public Stars(double y){
		this.x = Math.random()*(MainClass.WIDTH-WIDTH);
		this.y = y;
		myColor = randomColor();
	}
	
	private Color randomColor(){
		float r = (float)Math.random();
		float g = (float)Math.random();
		float b = (float)Math.random();
		return new Color(r,g,b);
//		if(Math.random()<.5)g.setColor(Color.red);
//		if(Math.random()<.4)g.setColor(Color.blue);
//		if(Math.random()<.3)g.setColor(Color.green);
//		if(Math.random()<.2)g.setColor(Color.yellow);
//		if(Math.random()<.1)g.setColor(new Color(0xE810E4));
	}
	
	public void draw(Graphics g){
		myColor = randomColor();
		g.setColor(myColor);
		g.fillRect((int) x, (int) y, HEIGHT, WIDTH);
	}
	public void update(){
		y+=SPEED;
		if(y>MainClass.HEIGHT){
			y=0;
			this.x = Math.random()*(MainClass.WIDTH-WIDTH);
		}
	}
}
