//Part of the "State" DP
//One of the classes that implements "state" interface
//The state which determines if the game is playing/active or not

package maze.control;

/**
 *
 * @author Yahia
 */
public class StartState implements State{

    @Override
    public void doAction(Context context) {
        context.setState(this);
    }
    
}
