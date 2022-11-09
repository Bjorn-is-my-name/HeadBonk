package Head_Bonk.GameClasses;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Save implements Serializable {
    public static void writeToFile(Object gameData) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src\\main\\java\\Head_Bonk\\PlayerData.bin"));
        objectOutputStream.writeObject(gameData);
    }
}
