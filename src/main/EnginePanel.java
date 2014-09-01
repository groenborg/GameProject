/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Grønborg
 */
public class EnginePanel extends JPanel implements Runnable, KeyListener {

    // screen values 
    public static int G_WIDTH = 480;
    public static int G_HEIGHT = 320;
    public static int G_SCALE = 2;

    // Engine values
    private Thread t;
    private BufferedImage dbImage;
    private Graphics2D dbg;

    // game values
    private static int MAX_FRAME_SKIP = 5;
    private int UPS = 1000 / 60;
    private boolean running = true;

    int dx = 0;
    int dy = 0;

    public EnginePanel(JFrame frame) {
        this.setPreferredSize(new Dimension(G_WIDTH * G_SCALE, G_HEIGHT * G_SCALE));
        this.setFocusable(true);
        this.requestFocus();
        this.setVisible(true);
    }

    private void init() {
        dbImage = new BufferedImage(G_WIDTH * G_SCALE, G_HEIGHT * G_SCALE, BufferedImage.TYPE_INT_RGB);
        dbg = (Graphics2D) dbImage.getGraphics();
    }

    @Override
    public void addNotify() {
        super.addNotify();
        if (t == null) {
            t = new Thread(this);
            addKeyListener(this);
            t.start();
        }
    }

    @Override
    public void run() {

        init();

        long beforeTime, afterTime, timeDiff, sleepTime;
        long overSleepTime = 0L;
        int noDelays = 0;
        long excess = 0L;

        while (running) {

            beforeTime = System.currentTimeMillis();

            update();
            render(dbg);
            draw();

            afterTime = System.currentTimeMillis();
            timeDiff = beforeTime - afterTime;
            sleepTime = (UPS - timeDiff) - overSleepTime;
            System.out.println(sleepTime);
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime / 1000000L);
                } catch (Exception e) {
                    overSleepTime = (System.currentTimeMillis() - afterTime) - sleepTime;
                    e.printStackTrace();
                }
            }else{
                overSleepTime = 0L;
            }
        }
    }

    public void update() {

    }

    public void render(Graphics2D graphics) {
        dbg.setColor(Color.blue);
        dbg.fillRect(0, 0, 480 * 2, 320 * 2);
        dbg.setColor(Color.red);
        dbg.fillRect(dx, dy, 100, 100);

    }

    public void draw() {
        Graphics g2 = getGraphics();
        g2.drawImage(dbImage, 0, 0, G_WIDTH * G_SCALE, G_HEIGHT * G_SCALE, null);
        g2.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            // dx = dx + 43;
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            dy = dy - 10;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            dy = dy + 10;

        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            dx = dx - 10;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            dx = dx + 10;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
