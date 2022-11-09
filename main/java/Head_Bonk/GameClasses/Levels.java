package Head_Bonk.GameClasses;

import Head_Bonk.Maps.Map1;
import Head_Bonk.Maps.Map2;
import Head_Bonk.Maps.Map3;
import Head_Bonk.Maps.Map4;

import java.util.ArrayList;

public class Levels {
    public static Map1 map1 = new Map1();
    public static Map2 map2 = new Map2();
    public static Map3 map3 = new Map3();
    public static Map4 map4 = new Map4();

    public static void setLevelObjects(int level){
        if (level == 1) map1.generateObjects();
        else if (level == 2) map2.generateObjects();
        else if (level == 3) map3.generateObjects();
        else if (level == 4) map4.generateObjects();
    }

    public static void clearLevelObjects(int level){
        if (level == 1) map1.clearObjects();
        else if (level == 2) map2.clearObjects();
        else if (level == 3) map3.clearObjects();
        else if (level == 4) map4.clearObjects();
    }

    public static ArrayList<Object> getLevelData(int level){
        if (level == 1) {
            ArrayList<Object> data = new ArrayList<>();
            data.add(map1.map);
            data.add(map1.bgObjects);
            data.add(map1.interactableBgObjects);
            data.add(map1.tileCoordinates);
            data.add(map1.spawnLocation);
            data.add(map1.doorCoordinates);
            return data;
        }
        else if (level == 2){
            ArrayList<Object> data = new ArrayList<>();
            data.add(map2.map);
            data.add(map2.bgObjects);
            data.add(map2.interactableBgObjects);
            data.add(map2.tileCoordinates);
            data.add(map2.spawnLocation);
            data.add(map2.doorCoordinates);
            return data;
        }
        else if (level == 3){
            ArrayList<Object> data = new ArrayList<>();
            data.add(map3.map);
            data.add(map3.bgObjects);
            data.add(map3.interactableBgObjects);
            data.add(map3.tileCoordinates);
            data.add(map3.spawnLocation);
            data.add(map3.doorCoordinates);
            return data;
        }
        else if (level == 4){
            ArrayList<Object> data = new ArrayList<>();
            data.add(map4.map);
            data.add(map4.bgObjects);
            data.add(map4.interactableBgObjects);
            data.add(map4.tileCoordinates);
            data.add(map4.spawnLocation);
            data.add(map4.doorCoordinates);
            return data;
        }
        return null;
    }

    public static Double getLevelTime(int level){
        if (level == 1) return map1.fastestTime;
        else if (level == 2) return map2.fastestTime;
        else if (level == 3) return map3.fastestTime;
        else if (level == 4) return map4.fastestTime;
        return null;
    }

    public static void setLevelTime(int level, double time){
        if (level == 1) map1.fastestTime = time;
        else if (level == 2) map2.fastestTime = time;
        else if (level == 3) map3.fastestTime = time;
        else if (level == 4) map4.fastestTime = time;
    }
}
