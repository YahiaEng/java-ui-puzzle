//Part of the "State" DP
//The context class


package maze.control;

/**
 *
 * @author Yahia
 */
public class Context {
    
   private State state;

   public Context(){
      state = null;
   }

   public void setState(State state){
      this.state = state;		
   }

   public State getState(){
      return state;
   }
    
}
