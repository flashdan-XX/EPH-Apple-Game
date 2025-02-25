package my_project.model;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;
import java.awt.event.KeyEvent;
public class Player2 extends Player {
    //Attribute

    private int points;

    //Tastennummern zur Steuerung
    private int direction;

    public Player2(double x, double y){
        super(x,y);
        speed = 150;
        width = 80;
        height = 40;

        this.keyToGoLeft    = KeyEvent.VK_LEFT;
        this.keyToGoRight   = KeyEvent.VK_RIGHT;
        this.direction      = -1; //-1 keine Bewegung, 0 nach rechts, 2 nach links
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(157,252,3,255);
        super.draw(drawTool);
        //System.out.println("X: "+x);
    }

    @Override
    public void update(double dt) {
        super.update(dt);
    }

    @Override
    public void keyPressed(int key) {
        super.keyPressed(key);
    }

    @Override
    public void keyReleased(int key) {
        super.keyReleased(key);
    }

}
