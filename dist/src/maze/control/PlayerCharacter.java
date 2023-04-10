//part of the "Decorator" DP
//The class that loads the default image for the main player character


package maze.control;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Yahia
 */
public class PlayerCharacter implements Character{

    @Override
    public Image loadCharcter() {
        
        ImageIcon img = new ImageIcon("src\\images\\player\\normal_form.gif");      
        return img.getImage();
    }
    
}
