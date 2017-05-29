package panels;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by Hemant Saini on 29-05-2017.
 */
public class MainAnimationPanel extends EllioPanel implements KeyListener, MouseListener {

    private static final int PLAYER_Y = 312;

    private int cloud1X = 400;
    private int cloud1Y = 150;
    private int cloud2X = 900;
    private int cloud2Y = 70;
    private int playerY = PLAYER_Y;
    private int playerVelocityY = 0;
    private int playerAccY = 0;
    private boolean cloud1Visible = true;
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

    private int counter = 0;
    private Rectangle playerRectangle;
    private Rectangle cloud1Rectangle;
    private Random generator = new Random();


    public MainAnimationPanel() {
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(this);
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        animatePlayer();
        animateCloud();
        animateHurdles();
        hideObjects();
        g.setColor(Color.blue);
        g.fillRect(0, 0, 800, 450);
        if (this.cloud1Visible) {
            g.drawImage(cloud1Image, cloud1X, cloud1Y, null);
        }
        g.drawImage(cloud2Image, cloud2X, cloud2Y, null);
        g.drawImage(playerImage, 100, playerY, null);
        g.drawImage(grassImage, 0, 450 - 45, null);
    }

    private void hideObjects() {
        if (playerRectangle.intersects(cloud1Rectangle)) {
            cloud1Visible = false;
        }
    }

    private void animateHurdles() {

    }

    private void animateCloud() {
        if (playerY >= PLAYER_Y) {
            playerY = PLAYER_Y;
            playerVelocityY = 0;
            playerAccY = 0;
        }

        if (cloud1X <= -100) {
            cloud1Y = generator.nextInt(190) + 10;
            cloud1X = 900;
            cloud1Visible = true;
        }

        if (cloud2X <= -100) {
            cloud2Y = generator.nextInt(190) + 10;
            cloud2X = 900;
        }

        cloud1X -= 2;
        cloud2X -= 2;
        cloud1Rectangle = new Rectangle(cloud1X, cloud1Y, 128, 71);

    }


    private void animatePlayer() {
        if (playerY == PLAYER_Y) {
            counter++;
            counter = counter % 8;
            playerImage = playerImages[counter];
        }
        playerVelocityY += playerAccY;
        playerY += playerVelocityY;
        if (playerY >= PLAYER_Y) {
            playerY = PLAYER_Y;
            playerVelocityY = 0;
            playerAccY = 0;
        }
        playerRectangle = new Rectangle(100, playerY, 72, 90);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("KeyTyped");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("KeyPressed");
        if (this.playerY == PLAYER_Y) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_NUMPAD8:
                    this.playerVelocityY = -20;
                    this.playerAccY = 1;
                    break;
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_NUMPAD2:
                    break;

            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("KeyReleased");
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
