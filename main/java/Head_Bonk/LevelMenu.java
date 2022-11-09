package Head_Bonk;

import Head_Bonk.GameClasses.Levels;
import Head_Bonk.Sprites.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LevelMenu {
    public static Font font = new Font(Font.MONOSPACED, Font.BOLD, 50);
    public static Font timeFont = new Font(Font.MONOSPACED, Font.BOLD, 10);
    public static BufferedImage levelMenuBackground = ImageLoader.loadImage("/other images/background.png");
    public static BufferedImage levelNumberBackground = ImageLoader.loadImage("/other images/level number background.png");
    public static int selectedLevel = 1;
    public static int maxLevel;

    public static void update(Player player){
        if (Game.escapePressed){
            Game.inLevelMenu = false;
            Game.inMenu = true;
            Game.escapePressed = false;
            Game.sPressed = false;
            Game.wPressed = false;
            Game.aPressed = false;
            Game.dPressed = false;
            Player.jumping = false;
            Player.falling = false;
            Menu.playerInMenu(player);
        }

        if (Game.enterPressed){
            Menu.startLevel(selectedLevel);
        }

        if (Game.dPressed){
            if (selectedLevel == maxLevel) selectedLevel = 1;
            else selectedLevel++;
            Game.dPressed = false;
        }
        else if (Game.aPressed){
            if (selectedLevel == 1) selectedLevel = maxLevel;
            else selectedLevel--;
            Game.aPressed = false;
        }
        else if(Game.wPressed){
            if (maxLevel > 10) {
                if (selectedLevel < 11) selectedLevel += 30;
                else selectedLevel -= 10;
            }
            Game.wPressed = false;
        }
        else if (Game.sPressed){
            if (maxLevel > 10) {
                if (selectedLevel > 30) selectedLevel -= 30;
                else selectedLevel += 10;
            }
            Game.sPressed = false;
        }
    }
    public static void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        g.drawImage(levelMenuBackground, 0, 0, null);
        g.setColor(Color.black);
        FontMetrics fontMetrics = g.getFontMetrics(font);
        int x;
        int y;
        String numAsString;
        String extraSpace;
        Double mapTime;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                try {
                    Class.forName("Head_Bonk.Maps.Map" + (i * 10 + j + 1));

                    g.setFont(font);
                    numAsString = Integer.toString(j + (i * 10));
                    mapTime = Levels.getLevelTime(j + (i * 10) + 1);
                    if (j + (i * 10) < 10){
                        extraSpace = "0";
                    }
                    else {
                        extraSpace = "";
                    }
                    g.drawImage(levelNumberBackground, 25 + (j * 126), 135 + (i * 134), null);
                    x = (73 + (j * 126) - (fontMetrics.stringWidth(extraSpace + numAsString) / 2));
                    y = (211 + (i * 134) - fontMetrics.getHeight() + (fontMetrics.getAscent() * 2/3));
                    numAsString = extraSpace + (j + (i * 10) + 1);
                    if (numAsString.equals("010")){
                        numAsString = "10";
                    }
                    g.drawString(numAsString, x, y);
                    g.setFont(timeFont);
                    if (mapTime != null){
                        String time;
                        if (mapTime == 0.0){
                            time = "Time: None";
                        }
                        else if (mapTime >= 1000){
                            time = "Time: Slow";
                        }
                        else {
                            time = "Time: " + mapTime;
                        }
                        g.drawString(time, x - 9, y + 25);
                    }
                } catch( ClassNotFoundException ignored) {}
            }
        }
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(Color.black);
        int column = selectedLevel % 10;
        if (column == 0) column = 10;
        int row = selectedLevel / 10;
        if (selectedLevel % 10 == 0) row = selectedLevel / 10 - 1;
        g2d.drawRoundRect(25 + ((column - 1) * 126), 135 + (row * 134), 96, 96, 25, 25);
    }
}
