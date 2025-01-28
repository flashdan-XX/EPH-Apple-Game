package my_project.model;
import KAGO_framework.view.DrawTool;
import my_project.Config;

public class PowerApple extends Apple {
    public double speedBuff;
    private double width;
    private double height;
    public PowerApple(double x, double y) {
        super(x, y);
        speedBuff = Math.random()* 190;
        radius = 30;
        width = 6;
        height = 10;
    }

    @Override
    public void draw(DrawTool drawTool) {
            super.draw(drawTool);
            drawTool.drawFilledRectangle(x - 3,y - (radius+height), width,height);
    }

    public void jumpBack() {
        y = 0;
        x = Math.random()*(Config.WINDOW_WIDTH);
    }
}
