import frames.EllioFrame;
import frames.GameFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Hemant Saini on 29-05-2017.
 */
public class Ellio {

    public static void main(String[] args) {

        startGame();

    }

    public static void startGame() {

        GameFrame gameFrame = new GameFrame();


        while (true) {
            gameFrame.getContentPane().repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
