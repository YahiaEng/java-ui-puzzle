//Part of the "Decorator" DP
//Updates the image of the player when they pick up an "armor gift"


package maze.control;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Yahia
 */
public class ArmorDecorator extends CharacterDecorator{
    
    public ArmorDecorator(Character decoratedCharacter) {
        super(decoratedCharacter);
    }
    
   @Override
    public Image loadCharcter() {
        
        /*ImageIcon img = new ImageIcon("C:\\Users\\Yahia\\Documents\\NetBeansProjects\\Labyrinthian\\src\\images\\icons8_Grass_48px.png");      
        return img.getImage();*/
        
        Image original = decoratedCharacter.loadCharcter();
        ImageIcon updatedImage = new ImageIcon("src\\images\\player\\super_form.gif");       
        return updatedImage.getImage();
    }
    
}
