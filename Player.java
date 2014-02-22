import processing.core.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
// to compile javac -classpath core.jar:. Space.java  && javac -classpath core.jar:. Player.java && java -classpath core.jar:. Space

public class Player{
    int x;

    int player_x_dir = 5;

    private PApplet shape;

    public Player(int x, PApplet shape){
        this.x = x;
        this.shape = shape;
    }

    public void moveRight(){
        if(this.x <= 749){
            this.x += player_x_dir;
        }
        else{
            this.x = this.x;
        }
    }

    public void moveLeft(){
        if(this.x >= 0){
            this.x -= player_x_dir;
        }
        else{
            this.x = this.x;
        }
    }

    public void display(){
        this.shape.rect(x,550,50,50);
    }




}