import java.awt.Color;
import java.awt.Graphics;
//Max Harper
public class Asteroid extends Polygon {
	static int counter = 0;
	private Point[] derp;
	public Asteroid(Point[] shape, Point position, double rotation) {
		super(shape, position, rotation);
		derp=shape;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics brush, Color color) {
		brush.setColor(Color.blue);
		// TODO Auto-generated method stub
		brush.setColor(Color.white);
		Point[]pArray=getPoints();
		int[]x=new int[pArray.length];//putting x points and y points in different arrays
		int[]y=new int[pArray.length];
		for(int i=0;i<pArray.length;i++) {
			x[i]=(int)pArray[i].x;
			y[i]=(int)pArray[i].y;
		}
		brush.drawPolygon(x, y,pArray.length);
		brush.setColor(color);
	}

	@Override
	public void move() {//getting asteriods to be able to move off the screen and reappear on the opposite side
		position.x += Math.cos(Math.toRadians(rotation));
		position.y += Math.sin(Math.toRadians(rotation));
		if(position.x>800) {
			position.x=0;
		}
		if(position.x<0) {
			position.x=800;
		}
		if(position.y>600) {
			position.y=0;
		}
		if(position.y<0) {
			position.y=600;
		}
	}

	// TODO Auto-generated method stub

}


