import processing.core.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

public class Missile{
    int x;
    int y = 525;
    int y_vel = 10;

    private PApplet shape;

    public Missile(int x, int y, PApplet shape){
        this.x = x;
        this.y = y;
        this.shape = shape;
    }

    public void display(){
        this.shape.rect(this.x,this.y,5,15);
        this.y -= y_vel;
    }

    public void velocity(){
        this.y -= y_vel;
    }

}