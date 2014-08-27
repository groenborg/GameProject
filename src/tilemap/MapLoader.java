package tilemap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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

    public int[][] getMap() {
        return map;
    }

    public boolean loadMap() {
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
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return map != null;
    }

    public void flipMap() {
        if (this.map != null) {
            int topPointer = 0;
            int bottomPointer = map.length - 1;
            while (topPointer < bottomPointer && topPointer != bottomPointer) {
                int[] tmpTopRow = map[topPointer];
                int[] tmpbottomRow = map[bottomPointer];
                map[topPointer] = tmpbottomRow;
                map[bottomPointer] = tmpTopRow;
                topPointer++;
                bottomPointer--;

            }
        }
    }

    
    
    // line added
}
