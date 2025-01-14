package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

public class Honeydew extends GraphicalObject {

    //Attribute
    private double speed;

    public Honeydew(double x, double y){
        this.x = x;
        this.y = y;
        speed = 250;
        radius = 50;
        //radiusX = 40;
        //radiusY = 30;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(255,255,0,255);
        drawTool.drawFilledCircle(x,y,/*radiusX,radiusY*/radius);
        drawTool.setCurrentColor(209,134,0,255);
        drawTool.drawCircle(x,y,/*radiusX,radiusY*/radius);
    }

    @Override
    public void update(double dt) {
        y = y + 100*dt;
        if(y >= 1000){
            jumpBack();
        }

        //TODO 01 Ein Apfel soll von oben herab fallen. Sobald er unten den Bildschirmrand berührt wird die Methode jumpBack() aufgerufen (siehe TODO 02).
    }
    public void jumpBack() {
        y = 0;
        x = Math.random()*(Config.WINDOW_WIDTH);
    }

    //TODO 02 Lege eine Methode jumpBack() an, die bei Aufruf das Apple-Objekt oben am oberen Bildschirmrand an einer zufälligen x-Position positioniert.
}
