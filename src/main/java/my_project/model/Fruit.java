package my_project.model;
import KAGO_framework.model.GraphicalObject;
public abstract class Fruit extends GraphicalObject {
    protected double speed;
    public void update(double dt) {
        y = y + 100*dt;
        if(y >= 1000){
            jumpBack();
        }
    }
    public abstract void jumpBack();
}
