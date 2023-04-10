//Part of the "State" DP
//One of the classes that implements "state" interface
//The state which determines if the game is in "pause" state

package maze.control;

/**
 *
 * @author Yahia
 */
public class StopState implements State{

    @Override
    public void doAction(Context context) {
        context.setState(this);
    }
    
}
