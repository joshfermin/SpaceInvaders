
import processing.core.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

public class Space extends PApplet{
public static void main(String[] args) {
    PApplet.main(new String[] { "Space" });
    }

    public Player player;
    public Missile missile;
    public Alien[] alien;

    private boolean firepressed = false; 

    public void setup() {
        size(800, 600);
        this.player = new Player(400,this);
        this.missile = new Missile(this.player.x + 22, 525, this);
        this.alien = new Alien[20];

        int numAliens = this.alien.length;
        for(int i=0; i<numAliens; i++){
            this.alien[i] = new Alien(i*50,20,5,this);
        }
    }

    public void draw(){
        background(0);
        if(this.keyPressed){
            if(this.key == 'a'){
                this.player.moveLeft();
                System.out.println("a");
            }
            if(this.key == 'd'){
                this.player.moveRight();
                System.out.println("d");
            }
            if(this.key == 'w'){
                System.out.println("w");
                this.missile.x = this.player.x + 22;
                this.missile.y = 525;     
            }    
        }
        
        this.missile.display();
        this.missile.velocity();

        for(int i=0; i<this.alien.length; i++){
            this.alien[i].hit(this.missile.x,this.missile.y);
            this.alien[i].move();
            this.alien[i].display();
            this.player.display();
        }

        this.text("Space Invaders!",25,25);
    }
}


// import processing.core.*;
// import java.util.List;
// import java.util.ArrayList;
// import java.awt.event.KeyEvent;
// import java.awt.event.KeyListener;
// import java.awt.*;

// public class Space extends PApplet{
// public static void main(String[] args) {
//     PApplet.main(new String[] { "Space" });
//     }

//     public Player player;
//     public Missile[] missile;
//     public boolean leftpressed = false;
//     public boolean rightpressed = false;
//     public boolean firepressed = false;

//     public int numMissile = 5;
//     public int i;

//     int player_x = 400;
//     int player_y = 500;

//     int player_x_dir = 10;

//     public void setup() {
//         size(800, 600);
//         this.player = new Player(400,this);
//         this.missile = new Missile[5];
//         for(int i=0; i<numMissile; i++){
//             this.missile[i] = new Missile(this.player.x + 22, 525, this);
//         }
//     }

//     public void draw(){
//         background(0);
//         this.player.display();
//         if(this.keyPressed){
//             if(this.key == 'a'){
//                 this.player.moveLeft();
//                 System.out.println("a");
//             }
//             if(this.key == 'd'){
//                 this.player.moveRight();
//                 System.out.println("d");
//             }
//             if(this.key == 'w'){
//                 System.out.println("w");
//                 firepressed = true;
//             }  
//         }

//         if(firepressed = true){
//             this.missile[i].display();
//             this.missile[i].velocity();
//             firepressed = false;
//         }


//         this.text("Space Invaders!",25,25);
//     }
// }


