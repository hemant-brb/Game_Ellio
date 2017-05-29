import frames.EllioFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Hemant Saini on 29-05-2017.
 */
public class Ellio implements KeyListener {
    public static void main(String[] args) {

        EllioFrame ellioFrame = new EllioFrame();


        while (true) {
            ellioFrame.getContentPane().repaint();
//            ellioFrame.repaint(); TODO check which one is convenient
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.print("abefe");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.print("abefe");

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.print("abefe");

    }
}
