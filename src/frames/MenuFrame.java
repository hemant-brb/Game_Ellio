package frames;

import panels.EllioPanel;
import panels.GamePanel;
import panels.MenuPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Hemant Saini on 30-05-2017.
 */
public class MenuFrame extends EllioFrame {

    private MenuPanel menuPanel = new MenuPanel();

    public MenuFrame() {


        menuPanel = new MenuPanel();
        menuPanel.jButtonPlay.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new GameFrame();
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
        });

        menuPanel.jButtonExit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

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
        });

        setContentPane(menuPanel);
        pack();
        setVisible(true);


    }
}