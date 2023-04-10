
package labyrinthian;

import maze.control.Board;
import maze.view.mazeUI;


/**
 *
 * @author Yahia
 */
public class Labyrinthian {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           
        mazeUI newView = new mazeUI();
        
        Board newController = new Board(newView);
        
        newView.setVisible(true);
    }
    
}
