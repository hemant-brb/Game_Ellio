package frames;

import panels.GamePanel;
import panels.MenuPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Hemant Saini on 29-05-2017.
 */
public class EllioFrame extends JFrame {

    private static final int WINDOW_WIDTH=800;
    private static final int WINDOW_HEIGHT=450;

    private MenuPanel menuPanel;

    public EllioFrame() {
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
