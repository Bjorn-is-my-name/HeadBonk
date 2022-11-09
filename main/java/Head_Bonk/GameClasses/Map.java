package Head_Bonk.GameClasses;

import Head_Bonk.Game;
import Head_Bonk.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Map {
    public BufferedImage background = ImageLoader.loadImage("/other images/background.png");
    public BufferedImage outerGrass = ImageLoader.loadImage("/tiles/outergrass.png");
    public ArrayList<BufferedImage> outerGrassImages = new ArrayList<>();
    public BufferedImage innerGrass = ImageLoader.loadImage("/tiles/innergrass.png");
    public ArrayList<BufferedImage> innerGrassImages = new ArrayList<>();
    public BufferedImage smallGrass = ImageLoader.loadImage("/tiles/smallgrass.png");
    public ArrayList<BufferedImage> smallGrassImages = new ArrayList<>();
    public BufferedImage outerGravel = ImageLoader.loadImage("/tiles/outergravel.png");
    public ArrayList<BufferedImage> outerGravelImages = new ArrayList<>();
    public BufferedImage innerGravel = ImageLoader.loadImage("/tiles/innergravel.png");
    public ArrayList<BufferedImage> innerGravelImages = new ArrayList<>();
    public BufferedImage smallGravel = ImageLoader.loadImage("/tiles/smallgravel.png");
    public ArrayList<BufferedImage> smallGravelImages = new ArrayList<>();
    public BufferedImage outerStone = ImageLoader.loadImage("/tiles/outerstone.png");
    public ArrayList<BufferedImage> outerStoneImages = new ArrayList<>();
    public BufferedImage innerStone = ImageLoader.loadImage("/tiles/innerstone.png");
    public ArrayList<BufferedImage> innerStoneImages = new ArrayList<>();

    public BufferedImage door = ImageLoader.loadImage("/background items/door.png");
    public BufferedImage grass = ImageLoader.loadImage("/background items/grass.png");
    public BufferedImage dryGrass = ImageLoader.loadImage("/background items/dry grass.png");
    public BufferedImage flowers = ImageLoader.loadImage("/background items/flowers.png");
    public BufferedImage bigFlowers = ImageLoader.loadImage("/background items/big flowers.png");
    public BufferedImage arrowLeft = ImageLoader.loadImage("/background items/arrow left.png");
    public BufferedImage arrowRight = ImageLoader.loadImage("/background items/arrow right.png");

    public BufferedImage coinStrip = ImageLoader.loadImage("/background items/coin strip.png");
    public ArrayList<BufferedImage> coinImages = new ArrayList<>();
    public BufferedImage coinPickupStrip = ImageLoader.loadImage("/background items/coin pickup strip.png");
    public ArrayList<BufferedImage> coinPickupImages = new ArrayList<>();

    public int currentRow;
    public int currentTile;
    public int currentImg;

    public Map(){
        splitImagesSheet(outerGrass, outerGrassImages, Game.TILE_SIZE, Game.TILE_SIZE, 9);
        splitImagesSheet(innerGrass, innerGrassImages, Game.TILE_SIZE, Game.TILE_SIZE, 8);
        splitImagesSheet(smallGrass, smallGrassImages, Game.TILE_SIZE, Game.TILE_SIZE, 3);
        splitImagesSheet(outerGravel, outerGravelImages, Game.TILE_SIZE, Game.TILE_SIZE, 9);
        splitImagesSheet(innerGravel, innerGravelImages, Game.TILE_SIZE, Game.TILE_SIZE, 8);
        splitImagesSheet(smallGravel, smallGravelImages, Game.TILE_SIZE, Game.TILE_SIZE, 3);
        splitImagesSheet(outerStone, outerStoneImages, Game.TILE_SIZE, Game.TILE_SIZE, 9);
        splitImagesSheet(innerStone, innerStoneImages, Game.TILE_SIZE, Game.TILE_SIZE, 8);
        splitImagesSheet(coinStrip, coinImages, 16, 16, 6);
        splitImagesSheet(coinPickupStrip, coinPickupImages, 16, 32, 6);
        currentImg = 0;
    }

    public void splitImagesSheet(BufferedImage sheet, ArrayList<BufferedImage> list, int width, int height, int length){
        for (int i = 0; i < length; i++){
            list.add(sheet.getSubimage(i * width, 0, width, height));
        }
    }

    public void draw(Graphics g, ArrayList<ArrayList<Integer>> map){
        g.drawImage(background, 0, 0, null);
        currentRow = 0;
        for (ArrayList<Integer> row: map){
            currentTile = 0;
            for (int tile: row){
                for (int i = 0; i < 9; i++){
                    if (tile == i + 1){
                        g.drawImage(outerGrassImages.get(i), Game.TILE_SIZE * currentTile, Game.TILE_SIZE * currentRow, null);
                    }
                }
                for (int i = 0; i < 8; i++){
                    if (tile == i + 10){
                        g.drawImage(innerGrassImages.get(i), Game.TILE_SIZE * currentTile, Game.TILE_SIZE * currentRow, null);
                    }
                }
                for (int i = 0; i < 3; i++){
                    if (tile == i + 18){
                        g.drawImage(smallGrassImages.get(i), Game.TILE_SIZE * currentTile, Game.TILE_SIZE * currentRow, null);
                    }
                }
                for (int i = 0; i < 9; i++){
                    if (tile == i + 21){
                        g.drawImage(outerGravelImages.get(i), Game.TILE_SIZE * currentTile, Game.TILE_SIZE * currentRow, null);
                    }
                }
                for (int i = 0; i < 8; i++){
                    if (tile == i + 30){
                        g.drawImage(innerGravelImages.get(i), Game.TILE_SIZE * currentTile, Game.TILE_SIZE * currentRow, null);
                    }
                }
                for (int i = 0; i < 3; i++){
                    if (tile == i + 38){
                        g.drawImage(smallGravelImages.get(i), Game.TILE_SIZE * currentTile, Game.TILE_SIZE * currentRow, null);
                    }
                }
                for (int i = 0; i < 9; i++){
                    if (tile == i + 41){
                        g.drawImage(outerStoneImages.get(i), Game.TILE_SIZE * currentTile, Game.TILE_SIZE * currentRow, null);
                    }
                }
                for (int i = 0; i < 8; i++){
                    if (tile == i + 50){
                        g.drawImage(innerStoneImages.get(i), Game.TILE_SIZE * currentTile, Game.TILE_SIZE * currentRow, null);
                    }
                }
                currentTile++;
            }
            currentRow++;
        }
    }

    public void drawBgObjects(Graphics g, ArrayList<ArrayList<Integer>> objects){
        for (ArrayList<Integer> object: objects) {
            if (object.get(0) == 101) {g.drawImage(door, (object.get(1) * Game.TILE_SIZE), (object.get(2) * Game.TILE_SIZE), null);}
            else if (object.get(0) == 102) {g.drawImage(grass, (object.get(1) * Game.TILE_SIZE), ((object.get(2) * Game.TILE_SIZE) + (Game.TILE_SIZE / 2)), null);}
            else if (object.get(0) == 103) {g.drawImage(dryGrass, (object.get(1) * Game.TILE_SIZE), ((object.get(2) * Game.TILE_SIZE) + (Game.TILE_SIZE / 2)), null);}
            else if (object.get(0) == 104) {g.drawImage(flowers, (object.get(1) * Game.TILE_SIZE), ((object.get(2) * Game.TILE_SIZE) + (Game.TILE_SIZE / 2)), null);}
            else if (object.get(0) == 105) {g.drawImage(bigFlowers, (object.get(1) * Game.TILE_SIZE), ((object.get(2) * Game.TILE_SIZE) + (Game.TILE_SIZE / 2)), null);}
            else if (object.get(0) == 106) {g.drawImage(arrowLeft, (object.get(1) * Game.TILE_SIZE), (object.get(2) * Game.TILE_SIZE), null);}
            else if (object.get(0) == 107) {g.drawImage(arrowRight, (object.get(1) * Game.TILE_SIZE), (object.get(2) * Game.TILE_SIZE), null);}
        }
    }

    public void drawInteractableBgObjects(Graphics g, ArrayList<ArrayList<Integer>> objects){
        for (ArrayList<Integer> object: objects) {
            if (object.get(0) == 106) {
                g.drawImage(coinImages.get(currentImg % 6), (object.get(1) * Game.TILE_SIZE) + 8, (object.get(2) * Game.TILE_SIZE), null);
            }
            if (object.get(0) == 107 && object.get(3) < 6) {
                g.drawImage(coinPickupImages.get(object.get(3) % 6), (object.get(1) * Game.TILE_SIZE) + 8, (object.get(2) * Game.TILE_SIZE) - 16, null);
                if (Game.updateCount % 5 == 0) object.set(3, object.get(3) + 1);

            }
        }
    }
}
