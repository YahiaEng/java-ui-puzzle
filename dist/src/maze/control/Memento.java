//Memento DP
//The memento calss that gets saved as an arraylist inside the caretaker


package maze.control;

import java.io.Serializable;

/**
 *
 * @author Yahia
 */
public class Memento implements Serializable{
    
    private int score;
    
    public Memento(int score){
        
        this.score = score;
    }

    public int getScore() {
        return score;
    }
    
    
    
}
