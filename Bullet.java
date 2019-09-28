import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends Circle {

	private double rotation;
	private static final int RADIUS=10;

	public Bullet(Point center, double rotation) {
		super(center, RADIUS); // define RADIUS in Bullet class
		this.rotation = rotation;
	}


	@Override
	public void paint(Graphics brush, Color color) {//giving the bullet its shaoe and color
		// TODO Auto-generated method stub
		brush.setColor(color);
		brush.fillOval((int)center.x, (int)center.y, radius, radius);
	}


	@Override
	public void move() {
		center.x += 4 * Math.cos(Math.toRadians(rotation));
		center.y += 4 * Math.sin(Math.toRadians(rotation));
	}
	public boolean outofBounds() {//in case the bullet goes off screen
		return ( center.x < 0 || center.x > Asteroids.SCREEN_WIDTH ||  center.y < 0 || center.y > Asteroids.SCREEN_HEIGHT);
	}
	public Point getCenter() {
		return center;
	}
}
