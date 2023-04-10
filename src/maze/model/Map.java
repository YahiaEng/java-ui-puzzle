//Class for the graphics and the design of the map
//It uses both the "singleton" DP and the "Factory DP"
//It contains the "Factory" method that is part of the "Factory" DP

package maze.model;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Yahia
 */
public class Map implements Serializable{
    
    private final int size = 30;//the dimensions

    
    private Scanner m;
    private String Map[] = new String[30];
    private int length = 10;
    private int width = 30;
    //private int[] mapSize = new int[2];
    //private char mapMatrix[][] = new char[30][30];
    private char mapMatrix[][] = new char[length][width];
    
    private int currentLevel;
    
    private Image grass, wall, tree, finish, bomb, dynamite, skullBomb, armor, ammo, health, gem, tree1, tree2, tree3, tree4, tree5, tree6, tree7, tree8, tree9, ancientTemple,
            floor1, floor2, floor3, floor4;
    
    private static Map singleMap = null;//The only instance of this class. Part of the "Singleton" DP
    
    private Map(){//Constructor is set to private since this class uses the "Singleton" DP
        
        this.currentLevel = 0;//Level starts from level 0 "tutorail"
        
        grass = manufactureTile('g');
        wall = manufactureTile('w');
        tree = manufactureTile('t');
        finish = manufactureTile('f');
        bomb = manufactureTile('b');
        dynamite = manufactureTile('d');
        skullBomb = manufactureTile('x');
        armor = manufactureTile('a');
        ammo = manufactureTile('m');
        health = manufactureTile('h');
        gem = manufactureTile('j');
        tree1 = manufactureTile('1');
        tree2 = manufactureTile('2');
        tree3 = manufactureTile('3');
        tree4 = manufactureTile('4');
        tree5 = manufactureTile('5');
        tree6 = manufactureTile('6');
        tree7 = manufactureTile('7');
        tree8 = manufactureTile('8');
        tree9 = manufactureTile('9');
        ancientTemple = manufactureTile('c');
        floor1 = manufactureTile('!');
        floor2 = manufactureTile('@');
        floor3 = manufactureTile('#');
        floor4 = manufactureTile('$');
      
      
      loadLevel("src\\levels\\level_0.txt");
    }
    
    
    public static Map Map(){//Use this to create the only instance of this class
        
        if(singleMap == null)
            singleMap = new Map();
        
        return singleMap;
    }
    
    public Image manufactureTile(char tileType){//Part of the "Factory" DP: the factory function, used to create all the various tiles that implement the interface "TileFactory"
        
        if(tileType == 'g'){
            GroundTile g = new GroundTile();
            return g.createTile();
        }
        
       else if(tileType == 'w'){
            WallTile w = new WallTile();
            return w.createTile();
        }
        
        else if(tileType == 't'){
            TreeTile t = new TreeTile();
            return t.createTile();
        }
        
        else if(tileType == 'f'){//"FinishLineTile"
           FinishLineTile f = new FinishLineTile();
            return f.createTile();
        }
        
        else if(tileType == 'b'){//"BombTile"
            BombTile b = new BombTile();
            return b.createTile();
        }
        
        else if(tileType == 'd'){//"DynamiteTile"
            DynamiteTile d = new DynamiteTile();
            return d.createTile();
        }
        
        else if(tileType == 'x'){//"SkullBombTile"
            SkullBombTile x = new SkullBombTile();
            return x.createTile();
        }
        
        else if(tileType == 'a'){//"ArmorTile"
            ArmorTile a = new ArmorTile();
            return a.createTile();
        }
        
        else if(tileType == 'm'){//"AmmoTile"
            AmmoTile m = new AmmoTile();
            return m.createTile();
        }
        
        else if(tileType == 'h'){//"HealthTile"
            HealthTile h = new HealthTile();
            return h.createTile();
        }
        
        else if(tileType == 'j'){//"GemTile"
            GemTile j = new GemTile();
            return j.createTile();
        }
        
         else if(tileType == 'c'){//"AncientTempleTile"
            AncientTempleTile c = new AncientTempleTile();
            return c.createTile();
        }
        
        else if(tileType == '1'){//"Tree1Tile"
            Tree1Tile t1 = new Tree1Tile();
            return t1.createTile();
        }
        
        else if(tileType == '2'){//"Tree2Tile"
            Tree2Tile t2 = new Tree2Tile();
            return t2.createTile();
        }
        
        else if(tileType == '3'){//"Tree3Tile"
            Tree3Tile t3 = new Tree3Tile();
            return t3.createTile();
        }
        
        else if(tileType == '4'){//"Tree4Tile"
            Tree4Tile t4 = new Tree4Tile();
            return t4.createTile();
        }
        
        else if(tileType == '5'){//"Tree5Tile"
            Tree5Tile t5 = new Tree5Tile();
            return t5.createTile();
        }
        
        else if(tileType == '6'){//"Tree6Tile"
            Tree6Tile t6 = new Tree6Tile();
            return t6.createTile();
        }
        
        else if(tileType == '7'){//"Tree7Tile"
            Tree7Tile t7 = new Tree7Tile();
            return t7.createTile();
        }
        
        else if(tileType == '8'){//"Tree8Tile"
            Tree8Tile t8 = new Tree8Tile();
            return t8.createTile();
        }
        
        else if(tileType == '9'){//"Tree9Tile"
            Tree9Tile t9 = new Tree9Tile();
            return t9.createTile();
        }
        
         else if(tileType == '!'){//"Floor1Tile"
            Floor1Tile f1 = new Floor1Tile();
            return f1.createTile();
        }
        
         else if(tileType == '@'){//"Floor2Tile"
            Floor2Tile f2 = new Floor2Tile();
            return f2.createTile();
        }
        
         else if(tileType == '#'){//"Floor3Tile"
            Floor3Tile f3 = new Floor3Tile();
            return f3.createTile();
        }
        
         else if(tileType == '$'){//"Floor4Tile"
            Floor4Tile f4 = new Floor4Tile();
            return f4.createTile();
        }
        
        return null;//So that Java stops complaining
    }

    
    public char[][] getMapMatrix() {
        return mapMatrix;
    }

    public void setMapMatrix(char[][] mapMatrix) {
        this.mapMatrix = mapMatrix;
    }

    
     public char getMap(int x, int y){
        return mapMatrix[y][x];
    }
    
    public void setMap(int x, int y, char tile){               
        mapMatrix[y][x] = tile;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }
       
    public Image getGrass(){
        return this.grass;
    }
    
    public Image getWall(){
        return this.wall;
    }
    
    public Image getFinish(){
        return this.finish;
    }

    public Image getAncientTemple() {
        return ancientTemple;
    }
       

    public Image getTree() {
        return tree;
    }

    public Image getTree1() {
        return tree1;
    }

    public Image getTree2() {
        return tree2;
    }

    public Image getTree3() {
        return tree3;
    }

    public Image getTree4() {
        return tree4;
    }

    public Image getTree5() {
        return tree5;
    }

    public Image getTree6() {
        return tree6;
    }

    public Image getTree7() {
        return tree7;
    }

    public Image getTree8() {
        return tree8;
    }

    public Image getTree9() {
        return tree9;
    }

    public Image getFloor1() {
        return floor1;
    }

    public Image getFloor2() {
        return floor2;
    }

    public Image getFloor3() {
        return floor3;
    }

    public Image getFloor4() {
        return floor4;
    }   
        
    public Image getBomb() {
        return bomb;
    }

    public Image getDynamite() {
        return dynamite;
    }

    public Image getArmor() {
        return armor;
    }

    public Image getAmmo() {
        return ammo;
    }

    public Image getHealth() {
        return health;
    }

    public Image getSkullBomb() {
        return skullBomb;
    }

    public Image getGem() {
        return gem;
    }   
    
    public int getSize(){
        return this.size;
    }

    
    public void loadLevel(String filePath){
        
        String line = new String();
        
        int i = 0;
         try {
             
            // FileReader to read the text
            FileReader fileReader =  new FileReader(filePath);

            //BufferedReader
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            line = bufferedReader.readLine();
            this.length =  Integer.parseInt(line);
            
            line = bufferedReader.readLine();
            this.width =  Integer.parseInt(line);            
            
            mapMatrix = new char[length][width];//Re-initializes the "mapMatrix" but with the new dimensions
            
            System.out.println("lenght = " + length + " width = " + width);
            while((line = bufferedReader.readLine()) != null) {
                
                System.out.println(line);
                mapMatrix[i] = line.toCharArray();
                i++;
            }   

            //Closes the file
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
         System.out.println("Warning: unable to open file '" + filePath + "!");                
        }
        catch(IOException ex) {
            System.out.println( "Error reading file '" + filePath + "'");                             
            ex.printStackTrace();
        }
        
    }
  
    
}
