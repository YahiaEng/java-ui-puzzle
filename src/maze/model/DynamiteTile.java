//One of the classes that implements "ShapeCreation" Interface
//Part of the "Factory" DP


package maze.model;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Yahia
 */
public class DynamiteTile implements TileFactory{

    @Override
    public Image createTile() {
        
        ImageIcon img = new ImageIcon("src\\images\\debuffs\\posion.gif");       
        return img.getImage();
    }
    
}
