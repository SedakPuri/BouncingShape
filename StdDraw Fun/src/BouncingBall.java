import edu.princeton.cs.introcs.StdDraw;
import java.util.Scanner;
import java.util.Random;

public class BouncingBall {
	Random rng = new Random();
	private int x;
	private int y;
	private String shape;
	private int canvas;
	private String color;
	private boolean colorOn;
	private int width;
	private int height;
	private double xVelocity;
	private double yVelocity;
	
	public BouncingBall(String color, String shape, int canvas, double xVelocity, double yVelocity, int x, int y) {
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
		this.x = x;
		this.y = y;
		this.shape = shape;
		this.canvas = canvas;
		this.color = color;
	}
	
	public void update() {
		x += xVelocity;
		y += yVelocity;
		
		//If the rectangles hit canvas
		if (x + width/2 >= 700) {
			xVelocity *= -1;
			x = 700 - (width/2);
		} else if (x - width/2 <= 0) {
			xVelocity *= -1;
			x = width/2;
		} else if (y + height/2 >= 650) {
			yVelocity *= -1;
			y = 650 - (height/2);
		} else if (y - height/2 <= 0) {
			yVelocity *= -1;
			y = height/2;
		}
	}
	
	public void draw() {
		setColor(color);
		switch(shape.toLowerCase()) {
		case "rectangle":
			StdDraw.filledRectangle(x, y, 60, 20);
			height = 40;
			width = 120;
			break;
		case "square":
			StdDraw.filledSquare(x, y, 50);
			height = 100;
			width = 100;
			break;
		case "ellipse":
			StdDraw.filledEllipse(x, y, 50, 20);
			height = 40;
			width = 100;
			break;
		case "circle":
			StdDraw.filledCircle(x, y, 50);
			height = 100;
			width = 100;
			break;
//		case "1":
//			StdDraw.picture(x, y, "1.gif", 200, 200);
//			height = 200;
//			width = 200;
//			break;
//		case "4":
//			StdDraw.picture(x, y, "4.gif", 200, 200);
//			height = 200;
//			width = 200;
//			break;
//		case "2":
//			StdDraw.picture(x, y, "2.gif", 200, 200);
//			height = 200;
//			width = 200;
//			break;
//		case "3":
//			StdDraw.picture(x, y, "3.gif", 200, 200);
//			height = 200;
//			width = 200;
//			break;
		default:
			System.out.println("Shape Not Supported, System Exited");
			System.exit(0);
		}
	}
	
	public boolean shapeBoxClicked(double x, double y)
	{
		return (x > 0 && x < 140 && y < canvas && y > 650);
	}
	
	public boolean colorBoxClicked(double x, double y)
	{
		return (x > 560 && x < canvas && y < canvas && y > 650);
	}
	
	
	//Accessors
	public double getXVelocity() {
		return xVelocity;
	}
	
	public double getYVelocity() {
		return yVelocity;
	}

	public String getColor() {
		return color;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	

	//Mutilators
	public void setXVelocity(int x) {
		xVelocity = x;
	}
	
	public void setYVelocity(int x) {
		yVelocity = y;
	}
	
	public void setColor(String color) {
			switch(color.toLowerCase()) {
			case "green":
				StdDraw.setPenColor(StdDraw.GREEN);
				break;
			case "blue":
				StdDraw.setPenColor(StdDraw.BLUE);
				break;
			case "red":
				StdDraw.setPenColor(StdDraw.RED);
				break;
			case "orange":
				StdDraw.setPenColor(StdDraw.ORANGE);
				break;
			case "yellow":
				StdDraw.setPenColor(StdDraw.YELLOW);
				break;
			case "pink":
				StdDraw.setPenColor(StdDraw.PINK);
				break;
			case "magenta":
				StdDraw.setPenColor(StdDraw.MAGENTA);
				break;
			case "cyan":
				StdDraw.setPenColor(StdDraw.CYAN);
				break;
			case "white":
				StdDraw.setPenColor(StdDraw.WHITE);
				break;
			default:
				System.out.println("Color Not Supported, System Exited");
				System.exit(0);
		}
	}
}
