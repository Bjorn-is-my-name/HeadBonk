package Head_Bonk.GameClasses;

import java.io.*;
import java.util.ArrayList;

public class Load implements Serializable {
    public static File saveFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\Head_Bonk\\playerData.bin");
    public static boolean checkForSaveFile(){
        return saveFile.exists();
    }

    public static ArrayList<Object> readFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(saveFile));
        return (ArrayList<Object>) objectInputStream.readObject();
    }
}
