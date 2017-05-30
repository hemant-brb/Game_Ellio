package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

/**
 * Created by Hemant Saini on 30-05-2017.
 */
public class MenuPanel extends EllioPanel implements KeyListener {


    private static final int PLAYER_Y = 312;
    private static final int PLAYER_X = 100;
    private static final int GRASS_X = 0;
    private static final int GRASS_Y = 405;


    private BufferedImage block = GamePanel.loadImage("block.png");
    private BufferedImage player_run1 = GamePanel.loadImage("run_anim1.png");
    private BufferedImage player_jump = GamePanel.loadImage("jump.png");
    private BufferedImage player_duck = GamePanel.loadImage("duck.png");
    private BufferedImage grassImage = GamePanel.loadImage("grass.png");
    private JLabel jLabel = new JLabel();
    public JButton jButtonPlay = new JButton();
    public JButton jButtonExit = new JButton();


    public MenuPanel() {

//        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
//
//        jLabel.setFont(new Font("Arial",Font.ROMAN_BASELINE,80));
//        jLabel.setText("<html><font color='white'>Ellio</font></html>");
//        jLabel.setBounds(100, 20, 300, 60);


        jButtonPlay.setPreferredSize(new Dimension(100, 50));
        jButtonPlay.setText("Play");
        jButtonExit.setPreferredSize(new Dimension(100, 50));
        jButtonExit.setText("Exit");

        add(jButtonPlay);
        add(jButtonExit);
        add(jLabel);

        setOpaque(true);
        setBackground(Color.darkGray);
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(player_run1, PLAYER_X, PLAYER_Y, null);
        g.drawImage(player_jump, PLAYER_X + 200, PLAYER_Y - 120, null);
        g.drawImage(player_duck, PLAYER_X + 400, PLAYER_Y, null);
        g.drawImage(grassImage, GRASS_X, GRASS_Y, null);
        g.drawImage(block, PLAYER_X + 230, PLAYER_Y, null);
        g.drawImage(block, PLAYER_X + 430, PLAYER_Y - 50, null);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
