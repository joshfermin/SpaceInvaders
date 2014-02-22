import processing.core.*;

// to run:
// javac -classpath core.jar:. Lecture_24.java 
// && java -classpath core.jar:. Lecture_24

public class Lecture_25 extends PApplet {
	public static void main(String[] args) {
	PApplet.main(new String[] { "Lecture_24" });
	}
	
	
	int bg_count = 0;
	int bg_dir = 1;
	
	
    /**
     * This is run ONE TIME ONLY.
     */
    public void setup() {
	size(800, 600);
	// other stuff.
    }
    
    public void mouseClicked(){
		System.out.println("You clicked at X:" + mouseX + "and Y:" + mouseY);
		Ball myNewBud = new Ball(this, mouseX, mouseY);
		myOnlyBall = myNewBud;
   
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
	
	fill(0, 64, 0);
	//    x     y   w     h
	rect(400, 300, 200, 100);

	fill(212, 111, 249);

	strokeWeight(4.0f);
	
	if(myOnlyBall != null){
		System.out.println("Drawing my only ball!");
		
	}

	
	// some draw methods associated with PApplet:
	// background(int)
	// stroke(int, int, int)
	// fill(int)
	// ellipse(x, y, radius_1, radius_2)
	// noFill()

	// text(str, x, y)
    }
    
    public class Ball{
		int ballX, ballY;
		
		Ball(Lecture_25 main, int x, int y){
			ballX = x;
			ballY = y;
			this.main = main;
	}
	
	void(draw){
		main.ellipse(this.ballX, ballY, 40, 40);
		
}
}
