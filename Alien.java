import processing.core.*;

public class Alien{

	public float x;
	public float y;
	public float velocity;
	private PApplet canvas;
	protected boolean dead = false;

	public Alien(float x, float y, float velocity, PApplet canvas){
		this.x = x;
		this.y = y;
		this.velocity = velocity;
		this.canvas = canvas;
	}

	public void move(){
		this.x+=this.velocity;

		if(this.x >= 800){
			this.x = 800;
			this.velocity *= -1; //change direction
			this.y += 25; //start moving down
		}

		if(this.x <= 0){
			this.x = 0;
			this.velocity *= -1; //change direction
			this.y += 25; //start moving down
		}

	}

	public void display(){
		if(this.dead == false){
			this.canvas.rect(this.x, this.y, 20, 20);
		}
	}

	public void hit(float mx, float my){
		float distance = this.canvas.dist(this.x,this.y,mx,my);
			if(distance < 20){
				this.dead = true;
			}
	}

}