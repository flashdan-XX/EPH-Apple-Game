package my_project.model;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.event.KeyEvent;

public class Player extends InteractiveGraphicalObject {


    //Attribute
    public double speed;
    private int points;

    //Tastennummern zur Steuerung
    private int keyToGoLeft;
    private int keyToGoRight;
    private int direction;
    private double color;
    public double width;
    public double widthD;
    public Player(double x, double y, int keyToGoLeft, int keyToGoRight, double color, double width) {
        this.x = x;
        this.y = y;
        speed = 150;
        this.width = width;
        height = 40;
        this.color = color;
        this.keyToGoLeft    = keyToGoLeft;
                //KeyEvent.VK_A;
        this.keyToGoRight   = keyToGoRight;
                //KeyEvent.VK_D;
        this.direction      = -1; //-1 keine Bewegung, 0 nach rechts, 2 nach links
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor((int) color,152,3,255);
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,width,height);
    }

    @Override
    public void update(double dt) {
        if(direction == 0){
            x = x + speed*dt;
            if (x <  0) {
                x = 0;
            }
        }
        if(direction == 2){
            x = x - speed*dt;
            if(x >= Config.WINDOW_WIDTH + width){
                x = Config.WINDOW_WIDTH + width;
            }

        }
    }

    @Override
    public void keyPressed(int key) {
        if(key == keyToGoLeft){
            direction = 2;
        }
        if(key == keyToGoRight){
            direction = 0;
        }
    }

    @Override
    public void keyReleased(int key) {
        if(key == keyToGoLeft){
            direction = -1;
        }
        if(key == keyToGoRight){
            direction = -1;
        }
    }
}
