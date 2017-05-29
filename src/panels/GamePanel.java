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
public class GamePanel extends EllioPanel implements KeyListener, MouseListener {

    private static final int PLAYER_Y = 312;
    private static final int PLAYER_X = 100;
    private static final int PLAYER_DEFAULT_VELOCITY_Y = 0;
    private static final int PLAYER_VELOCITY_Y = -20;
    private static final int PLAYER_DEFAULT_ACC_Y = 0;
    private static final int PLAYER_ACC_Y = 1;
    private static final int BLOCK_VELOCITY_X = -3;
    private static final int WINDOW_X = 0;
    private static final int WINDOW_Y = 0;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 450;
    private static final int GRASS_X = 0;
    private static final int GRASS_Y = 405;
    private static final int WINDOW_X_OFFSET = -100;
    private static final int WINDOW_Y_OFFSET = 900;


    private int cloud1X = 400;
    private int cloud1Y = 150;
    private int cloud2X = 900;
    private int cloud2Y = 70;
    private int block1X = 420;
    private int block2X = 740;
    private int block3X = 1060;
    private int block1Y = 355;
    private int block2Y = 290;
    private int block3Y = 230;
    private int blockY[] = {355, 290, 230};
    private int playerY = PLAYER_Y;
    private int playerVelocityY = 0;
    private int playerAccY = 0;
    private boolean block1Visible = true;
    private boolean block2Visible = true;
    private boolean block3Visible = true;
    private boolean isPaused = false;
    private boolean isPlayerDuck = false;

    private int counter = 0;
    private Rectangle playerRectangle;
    private Rectangle block1Rectangle;
    private Rectangle block2Rectangle;
    private Rectangle block3Rectangle;
    private Random generator = new Random();


    private BufferedImage player_run1 = GamePanel.loadImage("run_anim1.png");
    private BufferedImage player_run2 = GamePanel.loadImage("run_anim2.png");
    private BufferedImage player_run3 = GamePanel.loadImage("run_anim3.png");
    private BufferedImage player_run4 = GamePanel.loadImage("run_anim4.png");
    private BufferedImage player_run5 = GamePanel.loadImage("run_anim5.png");
    private BufferedImage player_jump = GamePanel.loadImage("jump.png");
    private BufferedImage player_duck = GamePanel.loadImage("duck.png");
    private BufferedImage block = GamePanel.loadImage("block.png");
    private BufferedImage playerImage = GamePanel.loadImage("run_anim1.png");
    private BufferedImage grassImage = GamePanel.loadImage("grass.png");
    private BufferedImage cloud1Image = GamePanel.loadImage("cloud1.png");
    private BufferedImage cloud2Image = GamePanel.loadImage("cloud2.png");
    private BufferedImage playerImages[] = {player_run1, player_run2, player_run3, player_run4,
            player_run5, player_run4, player_run3, player_run2};


    public GamePanel() {
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
        g.fillRect(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        g.drawImage(cloud1Image, cloud1X, cloud1Y, null);
        g.drawImage(cloud2Image, cloud2X, cloud2Y, null);
        g.drawImage(playerImage, PLAYER_X, playerY, null);
        g.drawImage(grassImage, GRASS_X, GRASS_Y, null);
        if (block1Visible)
            g.drawImage(block, block1X, block1Y, null);
        if (block2Visible)
            g.drawImage(block, block2X, block2Y, null);
        if (block3Visible)
            g.drawImage(block, block3X, block3Y, null);
    }

    private void hideObjects() {
        if (playerRectangle.intersects(block1Rectangle)) {
            block1Visible = false;
        }
        if (playerRectangle.intersects(block2Rectangle)) {
            block2Visible = false;
        }
        if (playerRectangle.intersects(block3Rectangle)) {
            block3Visible = false;
        }

    }

    private void animateHurdles() {

        if (block1X <= WINDOW_X_OFFSET) {
            block1Visible = true;
            block1X = WINDOW_Y_OFFSET;
            block1Y = blockY[generator.nextInt(3)];
        }
        if (block2X <= WINDOW_X_OFFSET) {
            block2Visible = true;
            block2X = WINDOW_Y_OFFSET;
            block2Y = blockY[generator.nextInt(3)];
        }
        if (block3X <= WINDOW_X_OFFSET) {
            block3Visible = true;
            block3X = WINDOW_Y_OFFSET;
            block3Y = blockY[generator.nextInt(3)];
        }

        block1X += BLOCK_VELOCITY_X;
        block2X += BLOCK_VELOCITY_X;
        block3X += BLOCK_VELOCITY_X;//TODO increase the Block velocity

        block1Rectangle = new Rectangle(block1X, block1Y, 20, 50);
        block2Rectangle = new Rectangle(block2X, block2Y, 20, 50);
        block3Rectangle = new Rectangle(block3X, block3Y, 20, 50);

    }

    private void animateCloud() {
        if (cloud1X <= WINDOW_X_OFFSET) {
            cloud1Y = generator.nextInt(190) + 10;
            cloud1X = WINDOW_Y_OFFSET;
        }

        if (cloud2X <= WINDOW_X_OFFSET) {
            cloud2Y = generator.nextInt(190) + 10;
            cloud2X = WINDOW_Y_OFFSET;
        }

        cloud1X -= 2;
        cloud2X -= 2;
//        cloud1Rectangle = new Rectangle(cloud1X, cloud1Y, 128, 71);
    }


    private void animatePlayer() {
        playerVelocityY += playerAccY;
        if (!isPlayerDuck)// we don't want to change the Y Coordinates if the Player is in Duck Position
            playerY += playerVelocityY;
        if (playerVelocityY == 20) {
            isPlayerDuck = false;
        }
        if (playerY > PLAYER_Y) {
            playerY = PLAYER_Y;
            playerVelocityY = PLAYER_DEFAULT_VELOCITY_Y;
            playerAccY = PLAYER_DEFAULT_ACC_Y;
        }
        if (playerY == PLAYER_Y) {
            counter++;
            counter = counter % 8;
            playerImage = playerImages[counter];
        }
        if (playerY < PLAYER_Y) {
            this.playerImage = player_jump;
        }
        if (isPlayerDuck) {
            this.playerImage = player_duck;
        }
        playerRectangle = new Rectangle(PLAYER_X, playerY, 72, 90);
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (this.playerY == PLAYER_Y) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_NUMPAD8:
                    this.playerVelocityY = PLAYER_VELOCITY_Y;
                    this.playerAccY = PLAYER_ACC_Y;//TODO : decrease the Jump Height of Player
                    break;
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_NUMPAD2:
                    this.playerVelocityY = PLAYER_VELOCITY_Y;
                    this.playerAccY = PLAYER_ACC_Y;
                    this.isPlayerDuck = true;
                    break;

            }

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
