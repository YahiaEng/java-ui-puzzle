//Part of the "Oberver" DP
//The "observer" abstract class


package maze.model;

/**
 *
 * @author Yahia
 */
public abstract class Observer {
    
    protected Subject subject;
    
    public abstract void update();
    
}
