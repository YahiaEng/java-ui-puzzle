package maze.view;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import maze.model.Keeper;
import maze.model.Map;
import maze.model.NPC;
import maze.model.Player;

/**
 *
 * @author Yahia
 */
public class CustomJpanel extends JPanel{
         
    
    private Map map = Map.Map(); 
    private Player player = Player.Player();
    private NPC k = new Keeper();
    private boolean bulletIsMoving;
    
    public void setMap(Map map) {
        this.map = map;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setK(NPC k) {
        this.k = k;
    }

    
    public void setBulletIsMoving(boolean bulletIsMoving) {
        this.bulletIsMoving = bulletIsMoving;
    }
     
    
 
    @Override
    public void paintComponent(Graphics g) {
    
        super.paintComponent(g);
        
//-------------Prints the background depending on the level-------------
//-----------------------------------------------------------------------
       if(map.getCurrentLevel() == 0){ 
            
          for(int y = 0; y < 50; y++){//Draws the ground grass
            
              for(int x = 0; x < 60; x++){
                 g.drawImage(map.getGrass(), x*32, y*32, null);
              }
           }
        }
       
       else if( map.getCurrentLevel() == 1){
           
           for(int y = 0; y < 50; y++){//Draws the ground grass
            
              for(int x = 0; x < 60; x++){
                 g.drawImage(map.getGrass(), x*32, y*32, null);
              }
           }
           
          ImageIcon img = new ImageIcon("src\\images\\flora\\abandoned_house.png");         
          g.drawImage(img.getImage(), 43 * 32, 10 * 32, null);//Draws the house
       }
        
       else if(map.getCurrentLevel() == 2){ 
            
          for(int y = 0; y < 50; y++){//Draws the ground grass
            
              for(int x = 0; x < 60; x++){
                 g.drawImage(map.getFloor4(), x*32, y*32, null);
              }
           }
         
        }
       
       else if(map.getCurrentLevel() == 3 ){ 
            
          ImageIcon img = new ImageIcon("src\\images\\flora\\grass_2.png");  
            
          for(int y = 0; y < 50; y++){//Draws the ground grass
            
              for(int x = 0; x < 60 + 1; x++){
                               
                 g.drawImage(img.getImage(), x * 48, y * 48, null);//Draws the house
              }
           }
         
        }
       
       else if(map.getCurrentLevel() == 4 || map.getCurrentLevel() == 5){//Prints the "AncientTemple" only on levlel 4/End message
           
           
          ImageIcon img = new ImageIcon("src\\images\\flora\\grass_2.png");  
            
          for(int y = 0; y < 50; y++){//Draws the ground grass
            
              for(int x = 0; x < 60 + 1; x++){
                               
                 g.drawImage(img.getImage(), x * 48, y * 48, null);//Draws the house
              }
           }
           
            g.drawImage(map.getAncientTemple(), 23*32, 10*32, null);
        }
       
 //----------------------Prints the map tiles--------------------------------
 //--------------------------------------------------------------------------
 
        for(int y = 0; y < map.getLength() /*map.getSize()*/; y++){
            for(int x = 0; x < map.getWidth() /*map.getSize()*/; x++){
                
                
                if(map.getMap(x, y) == 'g'){//For image of type "grass"                   
                    //g.drawImage(map.getGrass(), x*32, y*32, null);                  
                }
                
                
                if(map.getMap(x, y) == 'w'){//for image of type "wall"
                                   
                    //g.drawImage(map.getWall(), x*32, y*32, null);                   
                }
                
               
                 if(map.getMap(x, y) == 'f'){//for image of type "finish"
                    g.drawImage(map.getFinish(), x*32, y*32, null);                   
                }
                 
                 
                 if(map.getMap(x, y) == 't'){//for image of type "tree"
                    g.drawImage(map.getTree(), x*32, y*32, null);                   
                }
                 
                 
                 if(map.getMap(x, y) == 'b'){//for image of type "bomb"                                   
                     g.drawImage(map.getBomb(), x*32, y*32, null);  
                }
                 
                 
                 if(map.getMap(x, y) == 'd'){//for image of type "dynamite"
                    g.drawImage(map.getDynamite(), x*32, y*32, null);                   
                }
                 
                  if(map.getMap(x, y) == 'x'){//for image of type "SkullBomb"
                    g.drawImage(map.getSkullBomb(), x*32, y*32, null);                   
                }
                  
                 if(map.getMap(x, y) == 'a'){//for image of type "armor"
                    g.drawImage(map.getArmor(), x*32, y*32, null);                   
                } 
                 
                 if(map.getMap(x, y) == 'm'){//for image of type "ammo"
                    g.drawImage(map.getAmmo(), x*32, y*32, null);                   
                } 
                 
                  if(map.getMap(x, y) == 'h'){//for image of type "health"
                    g.drawImage(map.getHealth(), x*32, y*32, null);                   
                } 
                  
                  if(map.getMap(x, y) == 'j'){//for image of type "Gem"
                    g.drawImage(map.getGem(), x*32, y*32, null);                   
                } 
                 
                 if(map.getMap(x, y) == 'n'){//for image of type "npc/keeper"
                    g.drawImage(k.getNpcIcon(), x*32, y*32, null);                   
                } 
                 
                  if(map.getMap(x, y) == 's'){//for image of type "npc/keeper"
                      
                    ImageIcon img = new ImageIcon("src\\images\\save_station.gif");
                    g.drawImage(img.getImage(), x*32, y*32, null);                   
                } 
                 
                 if(map.getMap(x, y) == '1'){//for image of type "tree1"
                    g.drawImage(map.getTree1(), x*32, y*32, null);                   
                }
                 
                 if(map.getMap(x, y) == '2'){//for image of type "tree2"
                    g.drawImage(map.getTree2(), x*32, y*32, null);                   
                }
                 
                 if(map.getMap(x, y) == '3'){//for image of type "tree3"
                    g.drawImage(map.getTree3(), x*32, y*32, null);                   
                }
                 
                 if(map.getMap(x, y) == '4'){//for image of type "tree4"
                    g.drawImage(map.getTree4(), x*32, y*32, null);                   
                }
                 
                 if(map.getMap(x, y) == '5'){//for image of type "tree5"
                    g.drawImage(map.getTree5(), x*32, y*32, null);                   
                }
                 
                 if(map.getMap(x, y) == '6'){//for image of type "tree6"
                    g.drawImage(map.getTree6(), x*32, y*32, null);                   
                }
                  
                  if(map.getMap(x, y) == '7'){//for image of type "tree7"
                    g.drawImage(map.getTree7(), x*32, y*32, null);                   
                }
                  
                  if(map.getMap(x, y) == '8'){//for image of type "tree8"
                    g.drawImage(map.getTree8(), x*32, y*32, null);                   
                }
                   
                  if(map.getMap(x, y) == '9'){//for image of type "tree9"
                    g.drawImage(map.getTree9(), x*32, y*32, null);                   
                }
                  
                  if(map.getMap(x, y) == '!'){//for image of type "tree1"
                    g.drawImage(map.getFloor1(), x*32, y*32, null);                   
                }
                  
                 if(map.getMap(x, y) == '@'){//for image of type "tree1"
                    g.drawImage(map.getFloor2(), x*32, y*32, null);                   
                }  
                 
                if(map.getMap(x, y) == '#'){//for image of type "tree1"
                    g.drawImage(map.getFloor3(), x*32, y*32, null);                   
                } 
                
                if(map.getMap(x, y) == '$'){//for image of type "tree1"
                    g.drawImage(map.getFloor4(), x*32, y*32, null);                   
                }
                  
            }
        }
          
        
        g.drawImage(player.getPlayer(), player.getTileX() * 32, player.getTileY() * 32, null);
        
        if(bulletIsMoving){
          
            g.drawImage(player.getBullet(), player.getBulletX() * 32, player.getBulletY() * 32, null);
        }
        
        
    
    }
    
      
    
}
