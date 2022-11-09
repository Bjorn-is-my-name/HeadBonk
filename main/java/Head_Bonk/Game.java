package Head_Bonk;

import Head_Bonk.GameClasses.*;
import Head_Bonk.Listeners.KeyboardListener;
import Head_Bonk.Listeners.MouseListener;
import Head_Bonk.Sprites.Player;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Game extends Canvas implements Runnable {
    // game setup variables and objects
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 768;
    public static final int TILE_SIZE = 32;
    public static boolean running = false;
    public static int updateCount = 0;

    // game states
    public static boolean inMenu = false;
    public static boolean inGame = false;
    public static boolean inLevelMenu = false;

    // key and mouse presses
    public static boolean aPressed = false;
    public static boolean dPressed = false;
    public static boolean wPressed = false;
    public static boolean sPressed = false;
    public static boolean spacePressed = false;
    public static boolean enterPressed = false;
    public static boolean escapePressed = false;
    public static boolean leftClicked = false;
    public static boolean gPressed = false;

    // game variables and objects
    public static int currentLevel;
    public static ArrayList<ArrayList<Integer>> currentMap;
    public static ArrayList<ArrayList<Integer>> currentMapBgObjects;
    public static ArrayList<ArrayList<Integer>> currentMapInteractableBgObjects;
    public static ArrayList<ArrayList<Integer>> tileCoordinates = new ArrayList<>();
    public static int[] doorCoordinates = new int[2];
    public static Map map = new Map();
    public static Player player = new Player();

    Game() {
        new Window(this, WIDTH, HEIGHT);
        KeyboardListener.addKeyboardListener();
        this.addMouseListener(new MouseListener());
        if (Load.checkForSaveFile()) {
            ArrayList<Object> data = null;
            try {
                data = Load.readFromFile();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            assert data != null;
            Player.coins = (int) data.get(0);
            for (ArrayList<Double> mapTime : (ArrayList<ArrayList<Double>>) data.get(1)) {
                Levels.setLevelTime(mapTime.get(0).intValue(), mapTime.get(1));
            }
        } else {
            Player.coins = 0;
        }

        LevelMenu.maxLevel = getMaxLevel();

        start();
    }

    public Integer getMaxLevel() {
        for (int i = 1; i <= 40; i++) {
            try {
                Class.forName("Head_Bonk.Maps.Map" + i);
            } catch (ClassNotFoundException ignored) {
                return i - 1;
            }
        }
        return null;
    }

    public void update() {
        updateCount++;
        if (updateCount % 5 == 0) {
            player.currentImg++;
            map.currentImg++;
            updateCount = 0;
            if (!player.dustBeforeShowed) player.currentDustBeforeImg++;
            if (!player.dustAfterShowed) player.currentDustAfterImg++;
        }

        if (escapePressed) {
            Timer.stop();
            inGame = false;
            inLevelMenu = true;
            spacePressed = false;
            escapePressed = false;
            leftClicked = false;
            enterPressed = false;
            Player.jumping = false;
            Player.falling = false;
            player.x = 0;
            player.y = 0;
            Game.tileCoordinates = new ArrayList<>();
            Levels.clearLevelObjects(Game.currentLevel);
        }

        player.move();
        player.collisionCheck();
        if (Timer.running) Timer.update();
    }

    public void draw() {
        BufferStrategy buffer = this.getBufferStrategy();
        if (buffer == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = buffer.getDrawGraphics();

        if (inMenu) {
            Menu.draw(g, player);
        } else if (inLevelMenu) {
            LevelMenu.draw(g);
        } else {
            map.draw(g, currentMap);
            map.drawBgObjects(g, currentMapBgObjects);
            map.drawInteractableBgObjects(g, currentMapInteractableBgObjects);
            player.draw(g);
        }
        g.dispose();
        buffer.show();
    }

    public void start() {
        inMenu = true;
        Menu.playerInMenu(player);
        Thread thread = new Thread(this);
        thread.start();
        running = true;
    }

    public static void playMap(ArrayList<ArrayList<Integer>> playingMap, ArrayList<ArrayList<Integer>> playingMapBgObjects, ArrayList<ArrayList<Integer>> playingMapInteractableBgObjects, ArrayList<ArrayList<Integer>> mapTileCoordinates, int[] spawn, int[] door) {
        currentLevel = Menu.currentLevel;
        player.x = spawn[0];
        player.y = spawn[1];
        tileCoordinates = mapTileCoordinates;
        currentMap = playingMap;
        currentMapBgObjects = playingMapBgObjects;
        currentMapInteractableBgObjects = playingMapInteractableBgObjects;
        doorCoordinates = door;
        Player.jumping = false;
        Timer.start();
    }

    public static void setMapTime(double time) {
        if (Levels.getLevelTime(Menu.currentLevel) != null) {
            if (time < Levels.getLevelTime(Menu.currentLevel) || Levels.getLevelTime(Menu.currentLevel) == 0) {
                Levels.setLevelTime(Menu.currentLevel, time);
            }
        }
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double fps = 60;
        double ns = 1000000000 / fps;
        double delta = 0;
        long timer = System.currentTimeMillis();
        AtomicInteger frames = new AtomicInteger();
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta > 1) {
                if (inMenu) {
                    Menu.update(player, map);
                } else if (inLevelMenu) {
                    LevelMenu.update(player);
                } else {
                    update();
                }
                delta--;
            }
            draw();
            frames.getAndIncrement();

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames.set(0);
            }
        }
        stop();
    }

    public void stop() {
        ArrayList<ArrayList<Double>> mapTimes = new ArrayList<>();
        mapTimes.add(new ArrayList<>(Arrays.asList((double) 1, Levels.map1.fastestTime)));
        mapTimes.add(new ArrayList<>(Arrays.asList((double) 2, Levels.map2.fastestTime)));
        mapTimes.add(new ArrayList<>(Arrays.asList((double) 3, Levels.map3.fastestTime)));
        mapTimes.add(new ArrayList<>(Arrays.asList((double) 4, Levels.map4.fastestTime)));

        ArrayList<Object> gameData = new ArrayList<>();
        gameData.add(Player.coins);
        gameData.add(mapTimes);
        try {
            Save.writeToFile(gameData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
