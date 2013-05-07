/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package troll.controls;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

/**
 *
 * @author RR
 */
public class KeyDispatcher implements KeyEventDispatcher {
        KeyHandler keyHandler = new KeyHandler();
        
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                keyHandler.keyPressed(e);
            } else if (e.getID() == KeyEvent.KEY_RELEASED) {
                keyHandler.keyReleased(e);
            } else if (e.getID() == KeyEvent.KEY_TYPED) {
                keyHandler.keyTyped(e);
            }
            return false;
        }
}
