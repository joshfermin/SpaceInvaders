import processing.core.*;

// to run:
// javac -classpath core.jar:. Lecture_24.java 
// && java -classpath core.jar:. Lecture_24

public class Lecture_24 extends PApplet {
	public static void main(String[] args) {
	PApplet.main(new String[] { "Lecture_24" });
	}
	
	int ellipse_x = 400;
	int ellipse_y = 200;
	
	int bg_count = 0;
	int bg_dir = 1;
	
	int ellipse_x_dir = 1;
	int ellipse_y_dir = 1;
	
    /**
     * This is run ONE TIME ONLY.
     */
    public void setup() {
	size(800, 600);
	// other stuff.
    }
    
    public void mouseClicked(){
		System.out.println("hi there");
		ellipse_x = mouseX;
		ellipse_y = mouseY;
	}
    /**
     * The  draw()  function  runs  once  every  time  the  screen  is
     * drawn. Processing usually does this  on a repeating basis of 60
     * Hertz. That means it is called every 16 milliseconds.
     */
    public void draw() {
	background(bg_count); // set background to something
	// declare bg_count
	bg_count = bg_count + bg_dir;
	if (bg_count >= 255){
		bg_dir = -1;
	}
	else if (bg_count <= 0){
		bg_count = 0;
		bg_dir = 1;
	}
	ellipse_x = ellipse_x + ellipse_x_dir; 
	ellipse_y = ellipse_y - ellipse_y_dir;
	
	fill(0, 64, 0);
	//    x     y   w     h
	rect(400, 300, 200, 100);

	fill(212, 111, 249);

	strokeWeight(4.0f);

	//       x    y   r1   r2
	ellipse(ellipse_x, ellipse_y, 30, 30);
	
	// some draw methods associated with PApplet:
	// background(int)
	// stroke(int, int, int)
	// fill(int)
	// ellipse(x, y, radius_1, radius_2)
	// noFill()

	// text(str, x, y)
    }
}
