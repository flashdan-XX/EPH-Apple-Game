package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

public class Pear extends Fruit {

    //Attribute
    private double speed;

    public Pear(double x, double y){
        this.x = x;
        this.y = y;
        speed = 150;
        width = 25;
        height = 35;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(0,255,0,255);
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,width,height);
    }

    public void jumpBack() {
        y = 0;
        x = Math.random()*(Config.WINDOW_WIDTH);
    }
    //TODO 04 Lege eine Methode jumpBack() an, die bei Aufruf das Pear-Objekt oben am oberen Bildschirmrand an einer zufälligen x-Position positioniert.
}

