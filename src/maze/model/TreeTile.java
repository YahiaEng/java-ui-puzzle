//One of the classes that implements "ShapeCreation" Interface
//Part of the "Factory" DP


package maze.model;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Yahia
 */
public class TreeTile implements TileFactory{

    @Override
    public Image createTile() {
        
        ImageIcon img = new ImageIcon("src\\images\\flora\\evergreen.png");       
        return img.getImage();
    }
    
}
