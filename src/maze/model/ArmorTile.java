//One of the classes that implements "ShapeCreation" Interface
//Part of the "Factory" DP


package maze.model;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Yahia
 */
public class ArmorTile implements TileFactory{
    
    @Override
    public Image createTile() {
        
        // ImageIcon img = new ImageIcon("C:\\Users\\Yahia\\Documents\\NetBeansProjects\\Labyrinthian\\src\\images\\super_saiyan_buff.gif"); 
        ImageIcon img = new ImageIcon("src\\images\\buffs\\armor.gif");       
        return img.getImage();
    }
    
}
