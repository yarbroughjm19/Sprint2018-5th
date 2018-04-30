import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ship implements KeyListener{
	public static final int SIZE = 20;
	public boolean rightPressed, leftPressed, isDead;
	double x,y,vX,health;
	
	public Ship(){
		leftPressed = rightPressed = false;
		x = MainClass.WIDTH/2;
		y = MainClass.HEIGHT-50;
		health = 3;
	}
	
	public void draw(Graphics g){
		if(!isDead){
			g.setColor(Color.white);
			g.fillRect((int)x, (int)y, SIZE, SIZE);
			}
		if(health==3){
			g.setColor(Color.green);
			g.fillRect((int)x+30, (int)y, 10, 40);
		}
		if(health==2){
			g.setColor(Color.yellow);
			g.fillRect((int)x+30, (int)y, 10, 25);
		}
		if(health==1){
			g.setColor(Color.red);
			g.fillRect((int)x+30, (int)y, 10, 10);
		}
	}
	
	public void update(){
		if(isDead){
			return;
			}
		x += vX;
		if(leftPressed)vX-=3;
		if(rightPressed)vX+=3;
		vX *= .85;
		if(x>MainClass.WIDTH)x = 1;
		if(x<1)x = MainClass.WIDTH;
	}
	
	public boolean hit(AlienBullet z){
		double dX = SIZE/2 + this.x-z.getX();
		double dY = SIZE/2 + this.y-z.getY();
		return Math.sqrt(dX*dX+dY*dY)<SIZE;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT)leftPressed = true;
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)rightPressed = true;
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT)leftPressed = false;
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)rightPressed = false;
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public boolean isDead(){
		return isDead;
	}

	public void takeDamage() {
		if(health>0)health -= 1;
	}

	public boolean justDied() {
		if(health<=0 && !isDead){
			return isDead = true;
		}
		return false;
	}
}
