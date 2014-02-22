import processing.core.*;
import java.util.List;
import java.util.ArrayList;

// The goal in this lecture is to give the balls the ability to move
// around the screen based on context: where is the edge of the world?
// Where are other balls?
//
// How should a ball behave when it gets near another ball?
//
// Move away? Stand still to avoid a collision? Move towards it? Take
// no action?

public class Lecture_26 extends PApplet {
    public static void main(String[] args) {
	PApplet.main(new String[] { "Lecture_26" });
    }

    int bg_count = 0;
    int bg_dir = 1;
    // At the end of class last time, I created list list of balls to
    // contain an arbitrary number (including 0) of balls.
    List<Ball> ballList = new ArrayList<Ball>();
    
    /**
     * This is run ONE TIME ONLY.
     */
    public void setup() {
	size(800, 600);
	// other stuff.
    }

    public void mouseClicked() {
	System.out.println("You clicked at: " + mouseX + ", " + mouseY);
	Ball myNewBud = new Ball(this, mouseX, mouseY);
	ballList.add(myNewBud);
    }
    
    /**
     * The  draw()  function  runs  once  every  time  the  screen  is
     * drawn. Processing usually does this  on a repeating basis of 60
     * Hertz. That means it is called every 16 milliseconds.
     */
    public void draw() {
	background(bg_count); // set background to something
	bg_count = bg_count + bg_dir;
	if (bg_count >= 255) {
	    bg_dir = -1;
	} else if (bg_count <= 0) {
	    bg_count = 0;
	    bg_dir = 1;
	}

	fill(0, 64, 0);
	//    x     y   w     h
	rect(400, 300, 200, 100);

	fill(mouseY, 200, mouseX);

	strokeWeight(4.0f);

	for (Ball b : ballList) {
		b.move();
	}
	
	/*
	for (Ball b : ballList){
		for (Ball a : ballList){
			if (b != a){
				float dist = b.dist(a);
				if (dist < 300){
					a.turnAround();
					
			}
		}
	}
}
*/

	for (Ball b : ballList) {
	    b.draw();
	}
	// some draw methods associated with PApplet:
	// background(int)
	// stroke(int, int, int)
	// fill(int)
	// ellipse(x, y, radius_1, radius_2)
	// noFill()

	// text(str, x, y)
    }

}

class Ball {
    float ballX, ballY;
    Lecture_26 main;
    
    float dx, dy;
    
    
	float dist(Ball other){
		// the current ball is called this
		// the other is named 'other'
		float delta_x = other.ballX -this.ballX;
		float delta_y = other.ballY -this.ballY;
		// pythagoras: x*x + y*y = distance*d
		float xx = delta_x * delta_x;
		float yy = delta_y * delta_y;
		float sumsum = xx + yy; // dist sqared
		float sum = (float)Math.sqrt(sumsum); // take square root of dist squared
		return sum;
	}

    Ball(Lecture_26 main, int x, int y) {
	ballX = x;
	ballY = y;
	dy = 10f; // moves 3px per draw
	dx = 5f; // moves 0.5 px per draw
	this.main = main;
    }
    
    void turnAround(){
		System.out.println("Turning around!");
		dx = -dx;
		dy = -dy;
	}
    
	void move(){
		ballY = ballY + dy;
		ballX = ballX + dx;
		if (ballY > main.height && dy > 0){
			dy = -dy; // dy = -1f *dy
		}
		if (ballY < 0 && dy <0){
			dy = -dy;
		}
			
		if (ballX > main.width && dx > 0){
			dx = -dx; 
		}
		if (ballX < 0){
			dx = -dx;
		}
		if (ballX < 0 && dx < 0)
			dx = dx;
		
	}
    void draw() {
	main.ellipse(this.ballX, ballY, 40, 40);

    }
    // float dist = b.dist(a);
   
}

