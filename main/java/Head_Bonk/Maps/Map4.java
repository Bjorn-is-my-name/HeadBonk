package Head_Bonk.Maps;

import Head_Bonk.Game;

import java.util.ArrayList;
import java.util.Arrays;

public class Map4 {
    public ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> bgObjects = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> interactableBgObjects = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> tileCoordinates = new ArrayList<>();
    public int[] spawnLocation = new int[2];
    public int[] doorCoordinates = new int[2];
    public int currentRow;
    public int currentTile;
    public double fastestTime;
    public Map4(){
        map.add(new ArrayList<>(Arrays.asList(45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 50, 48, 48, 49, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(45, 45, 45, 45, 50, 48, 48, 48, 48, 48, 48, 48, 48, 48, 49, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(45, 45, 50, 48, 49, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 19, 19, 19, 19, 20, 0, 0, 0, 0, 0, 0, 0, 18, 19, 20, 0)));
        map.add(new ArrayList<>(Arrays.asList(45, 45, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(45, 45, 46, 0, 0, 0, 0, 18, 19, 20, 0, 0, 18, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(45, 45, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 19, 20, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(45, 45, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(45, 45, 46, 0, 0, 0, 0, 0, 41, 43, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(45, 45, 46, 0, 0, 0, 0, 0, 44, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 19, 19, 19, 19)));
        map.add(new ArrayList<>(Arrays.asList(45, 45, 55, 42, 42, 42, 42, 42, 57, 55, 42, 43, 0, 0, 0, 18, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 49, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 18, 20, 0, 0, 0, 0, 0, 1, 2, 2, 2, 3, 0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 0, 0, 7, 8, 8)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 8, 8, 12, 15, 2, 2, 2, 2, 17, 10, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 18, 19, 20, 0, 0, 0, 0, 18, 19, 20, 0, 0, 0, 0, 7, 8, 8, 8, 8, 8, 8, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 19, 19)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 18, 20, 0, 0, 0, 0, 0, 0, 0, 18, 20, 0, 0, 0, 0, 18, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(2, 2, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2)));
        map.add(new ArrayList<>(Arrays.asList(5, 5, 5, 15, 3, 0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 1, 17, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5)));
        map.add(new ArrayList<>(Arrays.asList(5, 5, 5, 5, 15, 2, 2, 2, 2, 17, 5, 5, 5, 5, 5, 5, 5, 5, 5, 15, 2, 2, 2, 2, 2, 2, 2, 2, 17, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5)));
        map.add(new ArrayList<>(Arrays.asList(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5)));
    }

    public void generateObjects(){
        bgObjects.add(new ArrayList<>(Arrays.asList(101, 5, 7)));
        doorCoordinates[0] = 5 * Game.TILE_SIZE;
        doorCoordinates[1] = 7 * Game.TILE_SIZE;

        currentRow = 0;
        for (ArrayList<Integer> row: map){
            currentTile = 0;
            for (int tile: row){
                if (tile == 100){
                    spawnLocation[0] = Game.TILE_SIZE * currentTile;
                    spawnLocation[1] = Game.TILE_SIZE * currentRow;
                }
                else if (tile != 0){
                    tileCoordinates.add(new ArrayList<>(Arrays.asList(32 * currentTile, 32 * currentRow)));
                    if (tile > 0 && tile < 10 || tile > 17 && tile < 21) {
                        if (currentRow > 0) {
                            double randomNumber = Math.random();
                            double randomCoinNumber = Math.random();
                            if (randomNumber < 0.5 && map.get(currentRow - 1).get(currentTile) == 0)
                                bgObjects.add(new ArrayList<>(Arrays.asList(102, currentTile, currentRow - 1)));
                            if (randomNumber < 0.35 && map.get(currentRow - 1).get(currentTile) == 0)
                                bgObjects.add(new ArrayList<>(Arrays.asList(103, currentTile, currentRow - 1)));
                            if (randomNumber < 0.1 && map.get(currentRow - 1).get(currentTile) == 0)
                                bgObjects.add(new ArrayList<>(Arrays.asList(104, currentTile, currentRow - 1)));
                            if (randomNumber < 0.005 && map.get(currentRow - 1).get(currentTile) == 0)
                                bgObjects.add(new ArrayList<>(Arrays.asList(105, currentTile, currentRow - 1)));
                            if (randomCoinNumber < 0.1 && map.get(currentRow - 1).get(currentTile) == 0)
                                interactableBgObjects.add(new ArrayList<>(Arrays.asList(106, currentTile, currentRow -  1, 0)));
                        }
                    }
                }
                currentTile++;
            }
            currentRow++;
        }
    }

    public void clearObjects(){
        bgObjects.clear();
        interactableBgObjects.clear();
    }
}
