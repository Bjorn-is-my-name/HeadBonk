package Head_Bonk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window extends JFrame {
    Window(Game game, int WIDTH, int HEIGHT){
        Dimension dimension = new Dimension(WIDTH, HEIGHT);
        JFrame frame = new JFrame("Head Bonk");
        frame.setPreferredSize(dimension);
        frame.setMaximumSize(dimension);
        frame.setMinimumSize(dimension);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                Game.running = false;
            }
        });
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.add(game);
        frame.pack();
        frame.setVisible(true);
    }
}
