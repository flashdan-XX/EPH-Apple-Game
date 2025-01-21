package my_project.model;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;
public class Fruit extends GraphicalObject {
    protected double speed;
    public void update(double dt) {
        y = y + 100*dt;
        if(y >= 1000){
            jumpBack();
        }
        //TODO 03 Eine Birne soll von oben herab fallen. Sobald sie unten den Bildschirmrand berührt wird die Methode jumpBack() aufgerufen (siehe TODO 04).
    }

    public void jumpBack() {}




}
