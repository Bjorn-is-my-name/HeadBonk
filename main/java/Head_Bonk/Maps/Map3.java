package Head_Bonk.Maps;

import Head_Bonk.Game;

import java.util.ArrayList;
import java.util.Arrays;

public class Map3 {
    public ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> bgObjects = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> interactableBgObjects = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> tileCoordinates = new ArrayList<>();
    public int[] spawnLocation = new int[2];
    public int[] doorCoordinates = new int[2];
    public int currentRow;
    public int currentTile;
    public double fastestTime;
    public Map3(){
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 19, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 18, 19, 19, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 2)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 8, 8, 8, 8, 8, 8)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 18, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 19, 19, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 1, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 7, 8, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 19, 20, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 19, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 19, 19, 20, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 18, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 20, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 8, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 18, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0, 0, 0, 0, 0, 0, 18, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 2, 2)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 17, 5, 5, 5, 5, 5)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 100, 0, 0, 0, 0, 0, 0, 0, 1, 2, 17, 5, 5, 5, 15, 2, 2, 2, 2, 3, 0, 0, 0, 0, 0, 0, 0, 1, 17, 5, 5, 5, 5, 5, 5, 5)));
        map.add(new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 17, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 15, 2, 2, 2, 2, 2, 2, 2, 17, 5, 5, 5, 5, 5, 5, 5, 5)));
    }

    public void generateObjects(){
        bgObjects.add(new ArrayList<>(Arrays.asList(101, 37, 2)));
        doorCoordinates[0] = 37 * Game.TILE_SIZE;
        doorCoordinates[1] = 2 * Game.TILE_SIZE;

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
                    if (currentRow > 0) {
                        double randomNumber = Math.random();
                        double randomCoinNumber = Math.random();
                        if (randomNumber < 0.7 && map.get(currentRow - 1).get(currentTile) == 0)
                            bgObjects.add(new ArrayList<>(Arrays.asList(102, currentTile, currentRow - 1)));
                        if (randomNumber < 0.2 && map.get(currentRow - 1).get(currentTile) == 0)
                            bgObjects.add(new ArrayList<>(Arrays.asList(104, currentTile, currentRow - 1)));
                        if (randomNumber < 0.05 && map.get(currentRow - 1).get(currentTile) == 0)
                            bgObjects.add(new ArrayList<>(Arrays.asList(105, currentTile, currentRow - 1)));
                        if (randomCoinNumber < 0.1 && map.get(currentRow - 1).get(currentTile) == 0)
                            interactableBgObjects.add(new ArrayList<>(Arrays.asList(106, currentTile, currentRow - 1, 0)));
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
