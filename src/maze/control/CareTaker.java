//Memento DP
//Has and array list of type "Mmento". Used to add and retrieve "mementos" from the array list


package maze.control;


import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Yahia
 */
public class CareTaker implements Serializable{
    
   private ArrayList<Memento> mementoList = new ArrayList<Memento>();

   public void add(Memento state){
      mementoList.add(state);
   }

   public Memento get(int index){
      return mementoList.get(index);
   }
    
}
