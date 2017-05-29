import frames.EllioFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Hemant Saini on 29-05-2017.
 */
public class Ellio  {
    public static void main(String[] args) {

        EllioFrame ellioFrame = new EllioFrame();


        while (true) {
            ellioFrame.getContentPane().repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
