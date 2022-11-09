package Head_Bonk.GameClasses;

public class Timer {
    public static long frames;
    public static boolean running;
    public static void start() {
        frames = 0;
        running = true;
    }
    public static void update() {frames++;}
    public static long stop(){
        running = false;
        return frames;
    }
}
