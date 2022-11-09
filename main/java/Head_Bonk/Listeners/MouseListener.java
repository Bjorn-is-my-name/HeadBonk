package Head_Bonk.Listeners;

import Head_Bonk.Game;
import Head_Bonk.GameClasses.Timer;
import Head_Bonk.Menu;

import java.awt.event.MouseEvent;

public class MouseListener implements java.awt.event.MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (Game.inGame && !Game.inMenu && !Game.inLevelMenu && e.getButton() == 1) Game.leftClicked = true;
        if (Game.inMenu && !Game.inGame && !Game.inLevelMenu && e.getButton() == 1){
            int x = e.getX();
            int y = e.getY();
            if (x >= 256 && x <= 512 && y >= 512 && y <= 608) Game.enterPressed = true;
            if (x >= 768 && x <= 1024 && y >= 512 && y <= 608) Game.running = false;
        }
        if (Game.inLevelMenu && !Game.inGame && !Game.inMenu && e.getButton() == 1){
            int cx = e.getX();
            int cy = e.getY();
            int level;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 10; j++) {
                    level = j + (i * 10) + 1;
                    if (cx >= 25 + (j * 126) && cx <= 121 + (j * 126) && cy >= 135 + (i * 134) && cy <= 231 + (i * 134)){
                        Menu.startLevel(level);
                    }
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
