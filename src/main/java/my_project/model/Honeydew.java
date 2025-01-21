package my_project.model;
import KAGO_framework.view.DrawTool;
import my_project.Config;

public class Honeydew extends Fruit {

    //Attribute
    private double speed;

    public Honeydew(double x, double y){
        this.x = x;
        this.y = y;
        speed = 250;
        radius = 30;
        //radiusX = 40;
        radiusY = 40;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(255,255,0,255);
        drawTool.drawFilledEllipse(x,y,radius,radiusY);
        drawTool.setCurrentColor(209,134,0,255);
        drawTool.drawEllipse(x,y,radius,radiusY);
    }

    @Override

    public void jumpBack() {
        y = 0;
        x = Math.random()*(Config.WINDOW_WIDTH);
    }
}
