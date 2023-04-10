//Part of the "State" DP
//One of the classes that implements "state" interface
//This state happens when the game reches it's end stae: when the plpayer dies

package maze.control;

/**
 *
 * @author Yahia
 */
public class EndState implements State{
    
    @Override
    public void doAction(Context context) {
        context.setState(this);
    }
    
}
