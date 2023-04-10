//Model Class for the player character
package maze.model;

import java.awt.Image;
import java.io.Serializable;
import javax.swing.ImageIcon;
import maze.control.Character;
import maze.control.PlayerCharacter;

/**
 *
 * @author Yahia
 */
public class Player implements Serializable{
    
    
    private int tileX;
    private int tileY;
    private Image player;
    
    private Image bullet;
    private int bulletX;//X coordinates of the bullets
    private int bulletY;//Y coordinates of the bullet
    private char bulletDirection;//determines the bullet's moving direction: 'r' = right ; 'l' = left ; 'u' = up ; 'd' = down
    private int ammo;
    
    private int health;
    private int Armor;
    private int score;
    
    private static Player singlePlayer = null;//The only instance of this class. Part of the "Singleton" DP
    
    private Player(){//Constructor is set to private since this class uses the "Singleton" DP
        
        Character mainPlayer = new PlayerCharacter();//Decorator dp: creates new PlayerCharacter and returns it's image/decoration through the "laodCharacter" function
        this.player = mainPlayer.loadCharcter();
        
        /*ImageIcon img = new ImageIcon("C:\\Users\\Yahia\\Documents\\NetBeansProjects\\Labyrinthian\\src\\images\\icons8_Minecraft_Main_Character_48px_3.png");      
        this.player = img.getImage();*/
        
       
        ImageIcon img = new ImageIcon("src\\images\\magic_icon.png");
        this.bullet = img.getImage();
        this.bulletX = 0;
        this.bulletY = 0;
        this.bulletDirection = 'r';//Default direction = right
        this.ammo = 6;//Default ammo = 6
        
        this.tileX = 1;
        this.tileY = 7;//7
        
        this.health = 100;
        this.Armor = 0;
        this.score = 0;
    }
    
    
    public static Player Player(){//Use this to create the only instance of this class
        
        if(singlePlayer == null)
            singlePlayer = new Player();
        
        return singlePlayer;
    }
    
    public Image getPlayer(){
        return this.player;
    }

    public Image getBullet() {
        return bullet;
    }

    public int getBulletX() {
        return bulletX;
    }

    public void setBulletX(int bulletX) {
        this.bulletX = bulletX;
    }

    public int getBulletY() {
        return bulletY;
    }

    public void setBulletY(int bulletY) {
        this.bulletY = bulletY;
    }

    public char getBulletDirection() {
        return bulletDirection;
    }

    public void setBulletDirection(char bulletDirection) {
        this.bulletDirection = bulletDirection;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }    

    public int getTileX() {
        return tileX;
    }

    public int getTileY() {
        return tileY;
    }

    public void setTileX(int tileX) {
        this.tileX = tileX;
    }

    public void setTileY(int tileY) {
        this.tileY = tileY;
    }       

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmor() {
        return Armor;
    }

    public void setArmor(int Armor) {
        this.Armor = Armor;
    }

    public void setPlayer(Image player) {
        this.player = player;
    }  

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
    public void movePlayer(int tx, int ty){  
        
        tileX += tx;
        tileY += ty;
    }
    
    
    
}
