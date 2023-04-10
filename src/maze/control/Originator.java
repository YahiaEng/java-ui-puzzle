//Memento DP
//Temporarily holds the values of the memento and returns a new "Memento" onbject with those parameters to the "CareTaker"

package maze.control;

import java.io.Serializable;

/**
 *
 * @author Yahia
 */
public class Originator implements Serializable{
    
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public Memento saveStateToMemento(){
      return new Memento(score);
   }
    
    public void getStateFromMemento(Memento memento){//Extracts the values/fields from the input Memento
      score = memento.getScore();
   }
    
}
