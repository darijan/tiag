/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package troll.controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author RR
 */
public class KeyHandler implements KeyListener{

    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyBindings.Left_key)
            System.out.println("Wciśnieto lewą strzałkę");
        if(e.getKeyCode() == KeyBindings.Right_key)
            System.out.println("Wciśnieto prawą strzałkę");
    }
    
}
