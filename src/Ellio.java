import frames.EllioFrame;

/**
 * Created by Hemant Saini on 29-05-2017.
 */
public class Ellio {
    public static void main(String[] args) {

        EllioFrame ellioFrame = new EllioFrame();

        while (true) {
            ellioFrame.getContentPane().repaint();
//            ellioFrame.repaint(); TODO check which one is convenient
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
