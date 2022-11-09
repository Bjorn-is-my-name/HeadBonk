package Head_Bonk.Listeners;
import Head_Bonk.Game;
import Head_Bonk.Sprites.Player;

import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyboardListener {
    public static void addKeyboardListener(){
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(e -> {
            switch (e.getID()) {
                case KeyEvent.KEY_PRESSED -> {
                    switch (e.getKeyCode()){
                        case KeyEvent.VK_A -> Game.aPressed = true;
                        case KeyEvent.VK_D -> Game.dPressed = true;
                        case KeyEvent.VK_W -> Game.wPressed = true;
                        case KeyEvent.VK_S -> Game.sPressed = true;
                        case KeyEvent.VK_ESCAPE -> Game.escapePressed = true;
                        case KeyEvent.VK_ENTER -> Game.enterPressed = true;
                        case KeyEvent.VK_G -> Game.gPressed = !Game.gPressed;
                    }
                    if (!Player.jumping){
                        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                            Game.spacePressed = true;
                        }
                    }
                }
                case KeyEvent.KEY_RELEASED -> {
                    switch (e.getKeyCode()){
                        case KeyEvent.VK_A -> Game.aPressed = false;
                        case KeyEvent.VK_D -> Game.dPressed = false;
                        case KeyEvent.VK_W -> Game.wPressed = false;
                        case KeyEvent.VK_S -> Game.sPressed = false;
                        case KeyEvent.VK_ESCAPE -> Game.escapePressed = false;
                        case KeyEvent.VK_ENTER -> Game.enterPressed = false;
                    }
                }
            }
            return false;
        });
    }
}
