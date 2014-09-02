/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjects;

import java.awt.Graphics2D;

/**
 *
 * @author Grønborg
 */
public class Player implements ObjectDrawing {

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics2D graphics) {
        graphics.fillRect(10, 40, 300, 300);
    }
}
