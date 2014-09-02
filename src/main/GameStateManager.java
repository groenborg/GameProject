/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Grønborg
 */
public class GameStateManager {

    private EnginePanel panel;
    private int[] gameStates;
    private int currentState;

    // gamestates 
    private static final int MENU_STATE = 0;
    private static final int LEVEL1_STATE = 1;

    private EnginePanel EP;

    public GameStateManager(EnginePanel panel) {
        this.EP = panel;

    }

    public int getCurrentState() {
        return this.currentState;
    }

    
    
    
    
    
}
