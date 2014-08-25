/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilemap;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 *
 * @author Grønborg
 */
public class MapLoader {

    private int[][] map;
    private int numRows;
    private int numCols;

    public MapLoader() {

    }

    public static void main(String[] args) {
        MapLoader m = new MapLoader();
        m.loadMap();
    }

    public void loadMap() {
        try {
            InputStream inputstream = this.getClass().getResourceAsStream("/map/level1.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(inputstream));

            String regex = "\\s+";

            this.numRows = Integer.parseInt(br.readLine());
            this.numCols = Integer.parseInt(br.readLine());
            this.map = new int[numCols][numRows];

            for (int col = 0; col < numCols; col++) {
                String[] tokens = br.readLine().split(regex);
                for (int row = 0; row < numRows; row++) {
                    map[col][row] = Integer.parseInt(tokens[row]);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void flipMap(){
        if(this.map != null){
        
            
            
            
            
            
           Function<String, String> trible = (s)-> {
               
               System.out.println("");
               return s;
           };
           
            
        
        }
    }
    
    
    
    
}
