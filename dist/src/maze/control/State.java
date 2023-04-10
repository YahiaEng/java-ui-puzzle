//Part of the "state" DP
//The intercae

package maze.control;

/**
 *
 * @author Yahia
 */
public interface State {
    
    public void doAction(Context context);//It basically sets the state of the input context to itself
}
