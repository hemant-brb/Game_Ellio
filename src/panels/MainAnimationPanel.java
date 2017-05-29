package panels;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Hemant Saini on 29-05-2017.
 */
public class MainAnimationPanel extends EllioPanel implements KeyListener, MouseListener {

    private static final int cloud1X = 400;
    private static final int cloud1Y = 150;
    private static final int cloud2X = 900;
    private static final int cloud2Y = 70;
    private static final int playerY = 315;
    private static final boolean cloud1Visible = true;
    private static final Color skyBlueColor = new Color(208, 244, 247);

    private int playerVelocityY = 0;
    private int playerAccY = 0;
    private boolean isPaused = false;


    private BufferedImage image1 = MainAnimationPanel.loadImage("run_anim1.png");
    private BufferedImage image2 = MainAnimationPanel.loadImage("run_anim2.png");
    private BufferedImage image3 = MainAnimationPanel.loadImage("run_anim3.png");
    private BufferedImage image4 = MainAnimationPanel.loadImage("run_anim4.png");
    private BufferedImage image5 = MainAnimationPanel.loadImage("run_anim5.png");
    private BufferedImage playerImage = MainAnimationPanel.loadImage("run_anim1.png");
    private BufferedImage grassImage = MainAnimationPanel.loadImage("grass.png");
    private BufferedImage cloud1Image = MainAnimationPanel.loadImage("cloud1.png");
    private BufferedImage cloud2Image = MainAnimationPanel.loadImage("cloud2.png");
    private BufferedImage playerImages[] = {image1, image2, image3, image4, image5, image4, image3, image2};


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("printComponent Called at MainAnimationPanel");
        g.setColor(Color.blue);
        g.fillRect(0, 0, 800, 450);
        if (this.cloud1Visible) {
            g.drawImage(cloud1Image, cloud1X, cloud1Y, null);
        }
        g.drawImage(cloud2Image, cloud2X, cloud2Y, null);
        g.drawImage(playerImage, 100, playerY, null);
        g.drawImage(grassImage, 0, 450 - 45, null);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && this.playerY == 450 - 45 - 90) {
            this.playerVelocityY = -20;
            this.playerAccY = 1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getX() > 750 && e.getY() < 50) {
            this.isPaused = !this.isPaused;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
