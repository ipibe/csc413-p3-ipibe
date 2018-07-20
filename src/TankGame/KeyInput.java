package TankGame;

import java.awt.event.*;
import java.awt.event.KeyListener;
import java.util.Observable;


/**
 * Created by Hector on 7/18/18.
 */
public class KeyInput extends KeyAdapter {

    Control control;

    public KeyInput(Control control){
        this.control = control;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0; i< control.object.size();i++){
            GameObject tempObject = control.object.get(i);


            if (tempObject.getId() == ID.Player1){
                if(key == KeyEvent.VK_W) control.setUp(true);
                if(key == KeyEvent.VK_S) control.setDown(true);
                if(key == KeyEvent.VK_A) control.setLeft(true);
                if(key == KeyEvent.VK_D) control.setRight(true);
            }
            if (tempObject.getId() == ID.Player2){
                if(key == KeyEvent.VK_UP) control.setUp(true);
                if(key == KeyEvent.VK_DOWN) control.setDown(true);
                if(key == KeyEvent.VK_LEFT) control.setLeft(true);
                if(key == KeyEvent.VK_RIGHT) control.setRight(true);
            }
        }


    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0; i< control.object.size();i++){
            GameObject tempObject = control.object.get(i);

            if (tempObject.getId() == ID.Player1){
                if(key == KeyEvent.VK_W) control.setUp(false);
                if(key == KeyEvent.VK_S) control.setDown(false);
                if(key == KeyEvent.VK_A) control.setLeft(false);
                if(key == KeyEvent.VK_D) control.setRight(false);
            }
            if (tempObject.getId() == ID.Player2){
                if(key == KeyEvent.VK_UP) control.setUp(false);
                if(key == KeyEvent.VK_DOWN) control.setDown(false);
                if(key == KeyEvent.VK_LEFT) control.setLeft(false);
                if(key == KeyEvent.VK_RIGHT) control.setRight(false);
            }
        }



    }


}
