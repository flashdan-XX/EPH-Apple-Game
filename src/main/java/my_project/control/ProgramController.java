package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import my_project.Config;
import my_project.model.*;

import java.awt.event.KeyEvent;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute


    // Referenzen
    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.

    private Apple[] allApples;
    private Pear[] allPears;
    private Player player01,player02;
    private Honeydew honeydew01;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {
        allApples = new Apple[5];
        allPears = new Pear[4];
        for(int i = 0; i < allApples.length; i++){
            double xPos = Math.random()*(Config.WINDOW_WIDTH-50) + 50;
            double yPos = Math.random()*(Config.WINDOW_HEIGHT-50) + 50;
            if(i == 4){
                allApples[i] = new PowerApple(xPos,yPos);
            }else{
                allApples[i] = new Apple(xPos,yPos);
            }
            viewController.draw(allApples[i]);
        }

        for(int i = 0; i < allPears.length; i++){
            double xPos = Math.random()*(Config.WINDOW_WIDTH-50) + 50;
            double yPos = Math.random()*(Config.WINDOW_HEIGHT-50) + 50;
            allPears[i] = new Pear(xPos,yPos);
            viewController.draw(allPears[i]);
        }



        double xPos = Math.random()*(Config.WINDOW_WIDTH-50) + 50;
        double yPos = Math.random()*(Config.WINDOW_HEIGHT-50) + 50;
        honeydew01 = new Honeydew(xPos, yPos);
        viewController.draw(honeydew01);

        player01 = new Player(50, Config.WINDOW_HEIGHT-100,KeyEvent.VK_A,KeyEvent.VK_D, 100, 80);
        viewController.draw(player01);
        viewController.register(player01);

        player02 = new Player(50, Config.WINDOW_HEIGHT-100, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, 150, 80);
        viewController.draw(player02);
        viewController.register(player02);
    }

    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){

        for(int i = 0; i < allApples.length; i++){
            if(checkAndHandleCollision(allApples[i],player01) == true){
                allApples[i].jumpBack();
                if(allApples[i] instanceof PowerApple){
                    player01.speed += ((PowerApple) allApples[i]).getSpeedBuff();
                }
            }
            if(checkAndHandleCollision(allApples[i],player02) == true){
                allApples[i].jumpBack();
                if(allApples[i] instanceof PowerApple){
                    player02.speed += ((PowerApple) allApples[i]).getSpeedBuff();
                }
            }
        }

        for(int i = 0; i < allPears.length; i++){
            if(checkAndHandleCollision(allPears[i],player01) == true){
                allPears[i].jumpBack();
            }
        }

        for(int i = 0; i < allPears.length; i++){
            if(checkAndHandleCollision(allPears[i],player02) == true){
                allPears[i].jumpBack();
            }
        }
        //TODO 08 Nachdem Sie die TODOs 01-07 erledigt haben: Setzen Sie um, dass im Falle einer Kollision (siehe TODO 06 bzw. 07) zwischen dem Spieler und dem Apfel bzw. dem Spieler und der Birne, die jumpBack()-Methode von dem Apfel bzw. der Birne aufgerufen wird.
        //Weitere TODOs folgen und werden im Unterricht formuliert. Spätestens nach TODO 08 sollte der Aufbau des Projekts durchdacht werden.

        }
        if(checkAndHandleCollision(honeydew01, player01)){
            honeydew01.jumpBack();
            player01.width = player01.width - 30;
        }
        if(checkAndHandleCollision(honeydew01, player02)){
            honeydew01.jumpBack();
            player02.width = player02.width + 30;
        }
    }
    public boolean checkAndHandleCollision(GraphicalObject g0, Player player){
        if(g0.collidesWith(player)){
            return true;
        }else{
            return false;
        }
    }

    //TODO 06 Fügen Sie eine Methode checkAndHandleCollision(Apple a) hinzu. Diese gibt true zurück, falls das Apple-Objekt mit dem Player-Objekt kollidiert. Nutzen Sie hierzu die collidesWith-Methode der Klasse GraphicalObject.

    //TODO 07 Fügen Sie eine Methode checkAndHandleCollision(Pear p) hinzu. Diese gibt true zurück, falls das Pear-Objekt mit dem Player-Objekt kollidiert. Nutzen Sie hierzu die collidesWith-Methode der Klasse GraphicalObject.
}
