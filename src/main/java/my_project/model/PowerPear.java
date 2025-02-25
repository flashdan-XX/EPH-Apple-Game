package my_project.model;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.*;

public class PowerPear extends Pear{
    public double speedNerf;
    private double widthPA;
    private double heightPA;
    public PowerPear(double x, double y) {
        super(x, y);
        speedNerf = Math.random()* 100;
        widthPA = 6;
        heightPA = 10;
    }

    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
        drawTool.setCurrentColor(150,75,0,255);
        drawTool.drawFilledRectangle(x +(width/2 - widthPA/2),y - heightPA,widthPA,heightPA);
    }

    public void jumpBack() {
        y = 0;
        x = Math.random()*(Config.WINDOW_WIDTH);
    }

    public double getSpeedBuff() {
        return speedNerf;
    }
}
