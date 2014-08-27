/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Grønborg
 */
public class ImageRendering {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame f = new JFrame("New Game");
        f.setContentPane(new EnginePanel(f));
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.pack();
        f.setVisible(true);
    }
    
}
