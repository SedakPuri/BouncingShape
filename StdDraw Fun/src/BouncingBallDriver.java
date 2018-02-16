import edu.princeton.cs.introcs.StdDraw;
import java.util.Scanner;
import java.util.Random;

public class BouncingBallDriver {
	public static final int canvas = 700;
	public static void main(String[] args) {
		//Setup
		StdDraw.setCanvasSize(canvas, canvas);
		StdDraw.setXscale(0, canvas);
		StdDraw.setYscale(0, canvas);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledSquare(canvas/2, canvas/2, canvas/2); 
		
		//Button Initial Display
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledRectangle(70, 675, 70, 25);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(70, 675, "Change Shape");
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledRectangle(630, 675, 70, 25);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(630, 675, "Change Color");
		
		//Misc Class Instantiations
		StdDraw.enableDoubleBuffering();
		Scanner keyboard = new Scanner(System.in);
		Random rng = new Random();
		double xVelocity = rng.nextInt(3) + 1;
		double yVelocity = rng.nextInt(3) + 1;
		int x = rng.nextInt(550) + 100;
		int y = rng.nextInt(550) + 100;
		double tempXVelocity = 0;
		double tempYVelocity = 0;
		int tempX = 0;
		int tempY = 0;
		int clickStatus = 0;
		
		
		//Input
		System.out.println("Enter the color of the box you wish to display: ");
		String color = keyboard.next();
		System.out.println("Enter the shape you want to draw: ");
		String shape = keyboard.next();
		
		//Class Import
		BouncingBall classimport = new BouncingBall(color, shape, canvas, xVelocity, yVelocity, x, y);
		
		//Overarching Loop Entrance
		while(true) {
			StdDraw.clear();
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledSquare(canvas/2, canvas/2, canvas/2); 
				
			//Change Shape Button
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledRectangle(70, 675, 70, 25);
			StdDraw.setPenColor(StdDraw.BLACK);		
			StdDraw.text(70, 675, "Change Shape");
				
			//Change Color Button
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledRectangle(630, 675, 70, 25);			
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(630, 675, "Change Color");
				
			//Button Functionality
				    if (StdDraw.mousePressed() && classimport.shapeBoxClicked(StdDraw.mouseX(), StdDraw.mouseY())) { 
				    		shapeLoop:
						while(true) {
							clickStatus = 0;
							if (StdDraw.mousePressed() && clickStatus == 0) {
								clickStatus = 1;
							    tempX = classimport.getX();
							    tempY = classimport.getY();
							    	tempXVelocity = classimport.getXVelocity();
							    	tempYVelocity = classimport.getXVelocity();
							} else if (!StdDraw.mousePressed()){
								clickStatus = 0;
								int randomShape = rng.nextInt(4) + 1;
								switch(randomShape) {
									case 1:
										 classimport = new BouncingBall(color, "rectangle", canvas, tempXVelocity, tempYVelocity, tempX, tempY);
										 break;
									case 2:
										 classimport = new BouncingBall(color, "square", canvas, tempXVelocity, tempYVelocity, tempX, tempY);
										 break;
									case 3:
										 classimport = new BouncingBall(color, "ellipse", canvas, tempXVelocity, tempYVelocity, tempX, tempY);
										 break;
									case 4:
										 classimport = new BouncingBall(color, "circle", canvas, tempXVelocity, tempYVelocity, tempX, tempY);
										 break;
//									case 5:
//										 classimport = new BouncingBall(color, "squaregif", canvas, tempXVelocity, tempYVelocity, tempX, tempY);
//										 break;
//									case 6:
//										 classimport = new BouncingBall(color, "hollowcirclegif", canvas, tempXVelocity, tempYVelocity, tempX, tempY);
//										 break;
//									case 7:
//										 classimport = new BouncingBall(color, "trianglegif", canvas, tempXVelocity, tempYVelocity, tempX, tempY);
//										 break;
//									case 8:
//										 classimport = new BouncingBall(color, "wierdcirclegif", canvas, tempXVelocity, tempYVelocity, tempX, tempY);
//										 break;
								}
							break shapeLoop;
							}
						} 
					}
					
				  if (StdDraw.mousePressed() && classimport.colorBoxClicked(StdDraw.mouseX(), StdDraw.mouseY())) { 
					  	colorLoop:
						while(true) {
							clickStatus = 0;
							if (StdDraw.mousePressed() && clickStatus == 0) {
								clickStatus = 1;
								tempX = classimport.getX();
							    tempY = classimport.getY();
							    	tempXVelocity = classimport.getXVelocity();
							    	tempYVelocity = classimport.getXVelocity();
							} else if (!StdDraw.mousePressed()){
								clickStatus = 0;
								int randomColor = rng.nextInt(9) + 1;
								switch(randomColor) {
									case 1:
										classimport = new BouncingBall("green", shape, canvas, tempXVelocity, tempYVelocity, tempX, tempY);
										break;
									case 2:
										classimport = new BouncingBall("blue", shape, canvas, tempXVelocity, tempYVelocity, tempX, tempY);
										break;
									case 3:
										classimport = new BouncingBall("red", shape, canvas, tempXVelocity, tempYVelocity, tempX, tempY);
										break;
									case 4:
										classimport = new BouncingBall("orange", shape, canvas, tempXVelocity, tempYVelocity, tempX, tempY);
										break;
									case 5:
										classimport = new BouncingBall("yellow", shape, canvas, tempXVelocity, tempYVelocity, tempX, tempY);
										break;
									case 6:
										classimport = new BouncingBall("pink", shape, canvas, tempXVelocity, tempYVelocity, tempX, tempY);
										break;
									case 7:
										classimport = new BouncingBall("magenta", shape, canvas, tempXVelocity, tempYVelocity, tempX, tempY);
										break;
									case 8:
										classimport = new BouncingBall("cyan", shape, canvas, tempXVelocity, tempYVelocity, tempX, tempY);
										break;
									case 9:
										classimport = new BouncingBall("white", shape, canvas, tempXVelocity, tempYVelocity, tempX, tempY);
										break;
								}
							break colorLoop;
							}
						} 
					}
				
			//Updater
			classimport.update(); 
			classimport.draw();
		    StdDraw.show(); 
			StdDraw.pause(10);
		}
	}
		
}


