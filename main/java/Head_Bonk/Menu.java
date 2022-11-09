package Head_Bonk;

import Head_Bonk.GameClasses.Levels;
import Head_Bonk.GameClasses.Map;
import Head_Bonk.Sprites.Player;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

public class Menu {
    public static Font font = new Font(Font.MONOSPACED, Font.BOLD, 75);
    public static BufferedImage menuBackground = ImageLoader.loadImage("/other images/menu background.png");
    public static BufferedImage nameBackground = ImageLoader.loadImage("/other images/name background.png");
    public static BufferedImage startBackground = ImageLoader.loadImage("/other images/start background.png");
    public static BufferedImage quitBackground = ImageLoader.loadImage("/other images/quit background.png");
    public static ArrayList<Object> levelData;
    public static int currentLevel;

    public static void playerInMenu(Player player){
        player.x = (int) (Math.random() * (Game.WIDTH - player.width));
        player.y = 736 - player.height;
        Game.tileCoordinates = new ArrayList<>();
        for (int i = 0; i < 40; i++){
            Game.tileCoordinates.add(new ArrayList<>(Arrays.asList(32 * i, 736)));
        }

        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 3; j++) {
                Game.tileCoordinates.add(new ArrayList<>(Arrays.asList(367 + (32 * i),178 + (32 * j) )));
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 3; j++) {
                Game.tileCoordinates.add(new ArrayList<>(Arrays.asList(256 + (32 * i),512 + (32 * j) )));
                Game.tileCoordinates.add(new ArrayList<>(Arrays.asList(768 + (32 * i),512 + (32 * j) )));
            }
        }

        for (int i = 0; i< 3; i++){
            Game.tileCoordinates.add(new ArrayList<>(Arrays.asList((32 * i), 640)));
            Game.tileCoordinates.add(new ArrayList<>(Arrays.asList(96 + (32 * i), 544)));
            Game.tileCoordinates.add(new ArrayList<>(Arrays.asList(1184 + (32 * i), 640)));
            Game.tileCoordinates.add(new ArrayList<>(Arrays.asList(1088 + (32 * i), 544)));
            Game.tileCoordinates.add(new ArrayList<>(Arrays.asList(544 + (32 * i), 640)));
            Game.tileCoordinates.add(new ArrayList<>(Arrays.asList(640 + (32 * i), 544)));
            Game.tileCoordinates.add(new ArrayList<>(Arrays.asList(544 + (32 * i), 448)));
            Game.tileCoordinates.add(new ArrayList<>(Arrays.asList((32 * i), 448)));
            Game.tileCoordinates.add(new ArrayList<>(Arrays.asList(160 + (32 * i), 384)));
            Game.tileCoordinates.add(new ArrayList<>(Arrays.asList(352 + (32 * i), 384)));
        }

        Game.currentMap = null;
        Game.currentMapBgObjects = new ArrayList<>();
        Game.currentMapInteractableBgObjects = new ArrayList<>();
        Game.doorCoordinates = new int[]{0, 0};
    }

    public static void update(Player player, Map map){
        if (Game.enterPressed){
            Game.inMenu = false;
            Game.inLevelMenu = true;
            Game.spacePressed = false;
            Game.enterPressed = false;
            }
        if (Game.escapePressed){
            Game.running = false;
        }
        Game.updateCount++;
        if (Game.updateCount % 5 == 0) {
            player.currentImg++;
            map.currentImg++;
            Game.updateCount = 0;
            if (!player.dustBeforeShowed) player.currentDustBeforeImg++;
            if (!player.dustAfterShowed) player.currentDustAfterImg++;
        }
        player.move();
        player.collisionCheck();
    }

    public static void startLevel(int level){
        currentLevel = level;
        Levels.setLevelObjects(currentLevel);
        levelData = Levels.getLevelData(currentLevel);
        if (levelData == null){
            return;
        }
        Game.inLevelMenu = false;
        Game.inGame = true;
        Game.spacePressed = false;
        Game.playMap((ArrayList<ArrayList<Integer>>) levelData.get(0), (ArrayList<ArrayList<Integer>>)levelData.get(1), (ArrayList<ArrayList<Integer>>)levelData.get(2), (ArrayList<ArrayList<Integer>>) levelData.get(3), (int[])levelData.get(4), (int[]) levelData.get(5));
    }

    public static void draw(Graphics g, Player player){
        g.drawImage(menuBackground, 0, 0, null);
        g.setColor(new Color(20, 20, 20));
        g.setFont(font);
        FontMetrics fontMetrics = g.getFontMetrics(font);
        int x = (Game.WIDTH - fontMetrics.stringWidth("Run faster")) / 2;
        int y = ((Game.HEIGHT - fontMetrics.getHeight()) / 4) + fontMetrics.getAscent();
        g.drawImage(nameBackground, x - 48, y - (fontMetrics.getHeight() / 2) - 16, null);
        g.drawString("Run faster", x, y);

        x = (Game.WIDTH - fontMetrics.stringWidth("Start")) / 4;
        y = ((Game.HEIGHT - fontMetrics.getHeight()) * 3/4) + fontMetrics.getAscent();
        g.drawImage(startBackground, x - 8, y - (fontMetrics.getHeight() / 2) - 16, null);
        g.drawString("Start", x + 8, y);

        x = (Game.WIDTH - fontMetrics.stringWidth("Quit")) * 3/4;
        y = ((Game.HEIGHT - fontMetrics.getHeight()) * 3/4) + fontMetrics.getAscent();
        g.drawImage(quitBackground, x - 58, y - (fontMetrics.getHeight() / 2) - 16, null);
        g.drawString("Quit", x - 19, y);

        for (ArrayList<Integer> tile: Game.tileCoordinates){
            g.drawRect(tile.get(0), tile.get(1), 32, 32);
        }

        player.draw(g);
    }
}
