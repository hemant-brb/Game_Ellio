package frames;

import panels.GamePanel;

import java.awt.*;

/**
 * Created by Hemant Saini on 30-05-2017.
 */
public class GameFrame extends EllioFrame {
    public GameFrame() {
        setContentPane(new GamePanel());
        pack();
        setVisible(true);

    }
}
