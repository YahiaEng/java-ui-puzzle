//Part of the "Decorator" DP
//Updates the image of the player when they pick up an "armor gift"


package maze.control;

import java.awt.Image;

/**
 *
 * @author Yahia
 */
public abstract class CharacterDecorator implements Character{

    protected Character decoratedCharacter;

    public CharacterDecorator(Character decoratedCharacter){

        this.decoratedCharacter = decoratedCharacter;
    }

    @Override
    public Image loadCharcter(){    
        
       return decoratedCharacter.loadCharcter();
    }
    
}
