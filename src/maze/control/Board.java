//Main Controller Class

package maze.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.Timer;
import maze.model.ArmorObserver;
import maze.model.HealthObserver;
import maze.model.Keeper;
import maze.model.Map;
import maze.model.NPC;
import maze.model.Player;
import maze.model.Subject;
import maze.view.mazeUI;

/**
 *
 * @author Yahia
 */
public class Board /*extends JPanel implements ActionListener*/ implements ActionListener, Serializable{

    private Timer timer;   
    long start = System.currentTimeMillis();
    long end = System.currentTimeMillis();
    
    private Map m;
    private Player p;
    
    private NPC keeper = new Keeper();
    
    Subject subject = new Subject();//Observer DP
    
    Context context = new Context();//State DP
    StartState startState = new StartState();//State DP
    StopState stopState = new StopState();//State DP
    EndState endState = new EndState();//State DP
    
    Originator originator = new Originator();//Mmento DP
    CareTaker careTaker = new CareTaker();//Memento DP
    
    mazeUI mazeView = new mazeUI();

    
    public Board(mazeUI view){
                
        m = Map.Map();        
        p = Player.Player();
        
        mazeView = view;
        
        //Adds listeneres for the menue items in the view/interface
        mazeView.addLoadMenuListener(new ContinueListener());
        mazeView.addRestartMenuListener(new NewGameListener());
        
        new HealthObserver(subject);//Observer DP
        new ArmorObserver(subject);//Observer DP
        subject.setHealth(p.getHealth());//Observer DP: intializes the HEALTH values to the default value inside the "player" class
        subject.setArmor(p.getArmor());//Observer DP: intializes the ARMOR values to the default value inside the "player" class
        
        startState.doAction(context);//State DP: sets the default state to "startState"
        
        mazeView.addKeyListener(new movementListener1());
        mazeView.setFocusable(true);
        mazeView.setFocusTraversalKeysEnabled(false);
        
        timer = new Timer(25, this);//Every 25 millisecond it will run "actionPerformed"
        timer.start();
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(p.getHealth() == 0)//If the player reaches zero health, then put the game in "End State"
            endState.doAction(context);
        
        if(! (context.getState() instanceof EndState) ){
            
        if(context.getState() instanceof StartState){//Only update the game if the game is in "StartState"
            
           mazeView.getStatusDisplay().setText("");
 
           if(m.getCurrentLevel() == 2){
              
               mazeView.setKeeper(keeper);
               mazeView.getTalk1().setText(keeper.getDialogue());
           }
           end = System.currentTimeMillis();//updates the current time         
           mazeView.getTimeDisplay().setText( Long.toString( (end - start)/1000 ) );//Displays run-time
           
           mazeView.refresh();
        }
        else{
            mazeView.getStatusDisplay().setText("Paused");
        }
        
      }
        else
            mazeView.getTalk2().setText("Player Has Died! Restart or load a saved game");
        
   }
 

    //Listeners for the keyboard
    public class movementListener1 implements KeyListener{

        @Override
        public void keyTyped(KeyEvent ke) {
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyPressed(KeyEvent ke) {
                    
         if( m.getMap(p.getTileX(), p.getTileY()) != 'f'){//If the player has not yet reached the finish tile = if player has not won yet, let him continue playing
            
            int KeyCode = ke.getKeyCode();
            
            if(KeyCode == KeyEvent.VK_UP){
                
                //If the tile in the movement direction != "wall" && != "tree" then, the player can move
               if(context.getState() instanceof StartState){//State DP: If the game is in start state
                    
                if( m.getMap(p.getTileX(), p.getTileY() - 1) != 'w' && m.getMap(p.getTileX(), p.getTileY() - 1) != 't' && m.getMap(p.getTileX(), p.getTileY() - 1) != '1'
                        && m.getMap(p.getTileX(), p.getTileY() - 1) != '2' && m.getMap(p.getTileX(), p.getTileY() - 1) != '3' && m.getMap(p.getTileX(), p.getTileY() - 1) != '4'
                        && m.getMap(p.getTileX(), p.getTileY() - 1) != '5' && m.getMap(p.getTileX(), p.getTileY() - 1) != '6' && m.getMap(p.getTileX(), p.getTileY() - 1) != '7'
                        && m.getMap(p.getTileX(), p.getTileY() - 1) != '8' && m.getMap(p.getTileX(), p.getTileY() - 1) != '9' && m.getMap(p.getTileX(), p.getTileY() - 1) != '!'
                        && m.getMap(p.getTileX(), p.getTileY() - 1) != '@' && m.getMap(p.getTileX(), p.getTileY() - 1) != '#' && m.getMap(p.getTileX(), p.getTileY() - 1) != '$'){  
                    
                         p.movePlayer( 0, -1);
                }
                
                p.setBulletDirection('u');//Set bullet firection to "up"
              }
            }
            
            if(KeyCode == KeyEvent.VK_DOWN){
                
               if(context.getState() instanceof StartState){//State DP: If the game is in start state
                    
                if(m.getMap(p.getTileX(), p.getTileY() + 1) != 'w' && m.getMap(p.getTileX(), p.getTileY() + 1) != 't' && m.getMap(p.getTileX(), p.getTileY() + 1) != '1'
                        && m.getMap(p.getTileX(), p.getTileY() + 1) != '2' && m.getMap(p.getTileX(), p.getTileY() + 1) != '3' && m.getMap(p.getTileX(), p.getTileY() + 1) != '4'
                        && m.getMap(p.getTileX(), p.getTileY() + 1) != '5' && m.getMap(p.getTileX(), p.getTileY() + 1) != '6' && m.getMap(p.getTileX(), p.getTileY() + 1) != '7'
                        && m.getMap(p.getTileX(), p.getTileY() + 1) != '8' && m.getMap(p.getTileX(), p.getTileY() + 1) != '9' && m.getMap(p.getTileX(), p.getTileY() + 1) != '!'
                        && m.getMap(p.getTileX(), p.getTileY() + 1) != '@' && m.getMap(p.getTileX(), p.getTileY() + 1) != '#' && m.getMap(p.getTileX(), p.getTileY() + 1) != '$'){
                  p.movePlayer(0, 1);
                }
                
                 p.setBulletDirection('d');//Set bullet firection to "down"
                
                }
            }
            
            if(KeyCode == KeyEvent.VK_LEFT){
                
                if(context.getState() instanceof StartState){//State DP: If the game is in start state
                    
                if(m.getMap(p.getTileX() - 1, p.getTileY()) != 'w' && m.getMap(p.getTileX() - 1, p.getTileY()) != 't' && m.getMap(p.getTileX() - 1, p.getTileY()) != '1'
                        && m.getMap(p.getTileX() - 1, p.getTileY()) != '2' && m.getMap(p.getTileX() - 1, p.getTileY()) != '3' && m.getMap(p.getTileX() - 1, p.getTileY()) != '4'
                        && m.getMap(p.getTileX() - 1, p.getTileY()) != '5' && m.getMap(p.getTileX() - 1, p.getTileY()) != '6' && m.getMap(p.getTileX() - 1, p.getTileY()) != '7'
                        && m.getMap(p.getTileX() - 1, p.getTileY()) != '8' && m.getMap(p.getTileX() - 1, p.getTileY()) != '9' && m.getMap(p.getTileX() - 1, p.getTileY()) != '!'
                        && m.getMap(p.getTileX() - 1, p.getTileY()) != '@' && m.getMap(p.getTileX() - 1, p.getTileY()) != '#' && m.getMap(p.getTileX() - 1, p.getTileY()) != '$'){
                  p.movePlayer( -1, 0);
                }
                                
                 p.setBulletDirection('l');//Set bullet firection to "left"
                 
                }
            }
            
            if(KeyCode == KeyEvent.VK_RIGHT){
                
               if(context.getState() instanceof StartState){//State DP: If the game is in start state
                    
                if(m.getMap(p.getTileX() + 1, p.getTileY()) != 'w' && m.getMap(p.getTileX() + 1, p.getTileY()) != 't' && m.getMap(p.getTileX() + 1, p.getTileY()) != '1'
                        && m.getMap(p.getTileX() + 1, p.getTileY()) != '2' && m.getMap(p.getTileX() + 1, p.getTileY()) != '3' && m.getMap(p.getTileX() + 1, p.getTileY()) != '4'
                        && m.getMap(p.getTileX() + 1, p.getTileY()) != '5' && m.getMap(p.getTileX() + 1, p.getTileY()) != '6' && m.getMap(p.getTileX() + 1, p.getTileY()) != '7'
                        && m.getMap(p.getTileX() + 1, p.getTileY()) != '8' && m.getMap(p.getTileX() + 1, p.getTileY()) != '9' && m.getMap(p.getTileX() + 1, p.getTileY()) != '!'
                        && m.getMap(p.getTileX() + 1, p.getTileY()) != '@' && m.getMap(p.getTileX() + 1, p.getTileY()) != '#' && m.getMap(p.getTileX() + 1, p.getTileY()) != '$'){
                  p.movePlayer(1, 0);
                }
                
                  p.setBulletDirection('r');//Set bullet firection to "right"
                }
            }
            
            if(KeyCode == KeyEvent.VK_P){//The pause key: utilizes the "State" DP to start and pause the game
                
                if( !(context.getState() instanceof EndState) ){//The pause button will only work when the game is not in "EndState"
                    
                if(context.getState() instanceof StartState){//If the current state of the context = "StarteState" then set it to "StopSate"
                    
                    stopState.doAction(context);
                }
                else if(context.getState() instanceof StopState){//The oposite of the previous "if"
                    
                    startState.doAction(context);
                }
                
              }
                
            }
            
            if(KeyCode == KeyEvent.VK_E){//Used to interact with the NPCs
                
                if(m.getMap(p.getTileX() + 1, p.getTileY()) == 'n' || m.getMap(p.getTileX() - 1, p.getTileY()) == 'n' || m.getMap(p.getTileX(), p.getTileY() + 1) == 'n' 
                        || m.getMap(p.getTileX(), p.getTileY() - 1) == 'n' || m.getMap(p.getTileX(), p.getTileY()) == 'n'){
                    
                    if(m.getCurrentLevel() == 2){
                                               
                        mazeView.getTalk1().setBounds(32 * 26, 32 * 1, 700, 50);//Sets the location of the dialogue box  
                        
                        System.out.println("Started dialogue");
                        
                        keeper.executeScriptedEvent(1);//Starts script number "1" with the "keeper npc"                        
                        mazeView.getTalk1().setText(keeper.getDialogue());
                        
                    }
                }
                
                else if(m.getMap(p.getTileX() + 1, p.getTileY()) == 's' || m.getMap(p.getTileX() - 1, p.getTileY()) == 's' || m.getMap(p.getTileX(), p.getTileY() + 1) == 's' 
                        || m.getMap(p.getTileX(), p.getTileY() - 1) == 's' || m.getMap(p.getTileX(), p.getTileY()) == 's'){
                    
                    //Saves the game
                    try {
                        
                       FileOutputStream fileOut =  new FileOutputStream("saveGame.ser");
                       ObjectOutputStream out = new ObjectOutputStream(fileOut);
               
                       out.writeObject(careTaker);
                       
                       out.writeObject(p.getHealth());
                       out.writeObject(p.getArmor());
                       out.writeObject(p.getAmmo());
                       out.writeObject(p.getScore());
                       out.writeObject(p.getTileX());
                       out.writeObject(p.getTileY());
                       
                       out.writeObject(m.getCurrentLevel());
                       out.writeObject(m.getMapMatrix());
                       out.close();
               
                       fileOut.close();
                       System.out.printf("The file tickets.ser has been succesfully updated\n");
               
                    }catch(IOException i){
                        
                       i.printStackTrace();
                    }
                    
                }
            }
            
            if(KeyCode == KeyEvent.VK_SPACE){
                  
             if(context.getState() instanceof StartState){//State DP: If the game is in start state
                
               if(p.getAmmo() > 0){//Checks if the player still has ammo left  
                 
                p.setBulletX(p.getTileX());
                p.setBulletY(p.getTileY());
               
                mazeView.setBulletMove(true); 
                
                //long expectedtime = System.currentTimeMillis();//Timestamps the current time in milli seconds
                //int sleepTime = 350;//Waitng time in milli seconds
                
               if(p.getBulletDirection() == 'r'){//If the bullet's direction is "right"                   
                    while(m.getMap(p.getBulletX() + 1, p.getBulletY()) == 'g' ){//Keep moving the bullet until it encounters anything other thatn 'g'(ground/grass)     
                    
                    //methode 1
                    /*while(System.currentTimeMillis() < expectedtime){
                       //Empty Loop   
                    }        */
                    
                    //expectedtime += sleepTime;
                    
                    p.setBulletX(p.getBulletX() + 1);//Update the bullet position   
                    mazeView.setMap(m);
                    mazeView.setPlayer(p);                   
                    //mazeView.refresh(); 
                    
                    //---methode 2
                   /* try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                    }*/                  
                    
                   }
                
                    //if the NEXT tile in the bullet's direction is a specific bomb type or a tree or a gift or a tile2, then destroy it by replacing it with a "gorund" tile
                   if(m.getMap(p.getBulletX() + 1, p.getBulletY()) == 'b' || m.getMap(p.getBulletX() + 1, p.getBulletY()) == 't' || m.getMap(p.getBulletX() + 1, p.getBulletY()) == '4'
                           || m.getMap(p.getBulletX() + 1, p.getBulletY()) == '@' || m.getMap(p.getBulletX() + 1, p.getBulletY()) == 'a' || m.getMap(p.getBulletX() + 1, p.getBulletY()) == 'm'
                           || m.getMap(p.getBulletX() + 1, p.getBulletY()) == 'h' || m.getMap(p.getBulletX() + 1, p.getBulletY()) == 'x' || m.getMap(p.getBulletX() + 1, p.getBulletY()) == 'j'){  
                       
                      m.setMap(p.getBulletX() + 1, p.getBulletY(), 'g');
                   }
                
               }
               
               else if(p.getBulletDirection() == 'l'){//If the bullet's direction is "left"
                   
                   while(m.getMap(p.getBulletX() - 1, p.getBulletY()) == 'g'){//Keep moving the bullet until it encounters anything other thatn 'g'(ground/grass)
                       
                      p.setBulletX(p.getBulletX() - 1);//Update the bullet position                   
                      mazeView.setMap(m);
                      mazeView.setPlayer(p);                      
                   }
                   
                    //if the NEXT tile in the bullet's direction is a specific bomb type or a tree or a gift or a tile2, then destroy it by replacing it with a "gorund" tile
                   if(m.getMap(p.getBulletX() - 1, p.getBulletY()) == 'b' || m.getMap(p.getBulletX() - 1, p.getBulletY()) == 't' || m.getMap(p.getBulletX() - 1, p.getBulletY()) == '4'
                           || m.getMap(p.getBulletX() - 1, p.getBulletY()) == '@' || m.getMap(p.getBulletX() - 1, p.getBulletY()) == 'a' || m.getMap(p.getBulletX() - 1, p.getBulletY()) == 'm'
                           || m.getMap(p.getBulletX() - 1, p.getBulletY()) == 'h' || m.getMap(p.getBulletX() - 1, p.getBulletY()) == 'x' || m.getMap(p.getBulletX() - 1, p.getBulletY()) == 'j'){ 
                       
                      m.setMap(p.getBulletX() - 1, p.getBulletY(), 'g');
                   }
               }
               
               else if(p.getBulletDirection() == 'u'){//If the bullet's direction is "up"
                   
                   while(m.getMap(p.getBulletX(), p.getBulletY() - 1 ) == 'g'){//Keep moving the bullet until it encounters anything other thatn 'g'(ground/grass)
                       
                      p.setBulletY(p.getBulletY() - 1);//Update the bullet position                   
                      mazeView.setMap(m);
                      mazeView.setPlayer(p);                      
                   }
                   
                    //if the NEXT tile in the bullet's direction is a specific bomb type or a tree or a gift or tile2, then destroy it by replacing it with a "gorund" tile
                   if(m.getMap(p.getBulletX(), p.getBulletY() - 1) == 'b' || m.getMap(p.getBulletX(), p.getBulletY() - 1) == 't' || m.getMap(p.getBulletX(), p.getBulletY() - 1) == '4'
                           || m.getMap(p.getBulletX(), p.getBulletY() - 1) == '@' || m.getMap(p.getBulletX(), p.getBulletY() - 1) == 'a' || m.getMap(p.getBulletX(), p.getBulletY() - 1) == 'm'
                           || m.getMap(p.getBulletX(), p.getBulletY() - 1) == 'h' || m.getMap(p.getBulletX(), p.getBulletY() - 1) == 'x' || m.getMap(p.getBulletX(), p.getBulletY() - 1) == 'j'){         
                       
                      m.setMap(p.getBulletX(), p.getBulletY() - 1, 'g');
                   }
               }
               
               else if(p.getBulletDirection() == 'd'){//If the bullet's direction is "down"
                   
                   while(m.getMap(p.getBulletX(), p.getBulletY() + 1 ) == 'g'){//Keep moving the bullet until it encounters anything other thatn 'g'(ground/grass)
                       
                      p.setBulletY(p.getBulletY() + 1);//Update the bullet position                   
                      mazeView.setMap(m);
                      mazeView.setPlayer(p);                      
                   }
                   
                    //if the NEXT tile in the bullet's direction is a specific bomb type or a tree or a gift, then destroy it by replacing it with a "gorund" tile
                   if(m.getMap(p.getBulletX(), p.getBulletY() + 1) == 'b' || m.getMap(p.getBulletX(), p.getBulletY() + 1) == 't' || m.getMap(p.getBulletX(), p.getBulletY() + 1) == '4'
                           || m.getMap(p.getBulletX(), p.getBulletY() + 1) == '@' || m.getMap(p.getBulletX(), p.getBulletY() + 1) == 'a' || m.getMap(p.getBulletX(), p.getBulletY() + 1) == 'm'
                           || m.getMap(p.getBulletX(), p.getBulletY() + 1) == 'h' || m.getMap(p.getBulletX(), p.getBulletY() + 1) == 'x' || m.getMap(p.getBulletX(), p.getBulletY() + 1) == 'j'){    
                       
                      m.setMap(p.getBulletX(), p.getBulletY() + 1, 'g');
                   }
               }
                
                  mazeView.setBulletMove(false);
                  p.setAmmo(p.getAmmo() - 1);//Decrements the ammo count
                
                  }//end of bullet count check
               }//End of stae check 
            }
            
            mazeView.setMap(m);
            mazeView.setPlayer(p);                  
            
            if( m.getMap(p.getTileX(), p.getTileY()) == 'f'){//If the player steps on the finish line:
                
                System.out.println("Passed A Level!\n");
                
                p.setScore(p.getScore() + 400);//Adds score to the player
                
                m.setCurrentLevel(m.getCurrentLevel() + 1);//Increment the number that represents the current level
                
                if(m.getCurrentLevel() == 1){
                        
                   originator.setScore(p.getScore());//Mmento Dp: checkpoints the score
                   careTaker.add(originator.saveStateToMemento());
                    
                   mazeView.getTalk1().setBounds(32 * 2, 32 * 6, 300, 50);//Sets the location of the dialogue box
                   mazeView.talk1.setText("Some of these trees look fragile...");
                   mazeView.talk2.setText("");
                   
                   m.loadLevel("src\\levels\\level_1.txt");                  
                   p.setTileX(1);
                   p.setTileY(6);    
                }
                
                else if(m.getCurrentLevel() == 2){
                    
                    originator.setScore(p.getScore());//Mmento Dp: checkpoints the score
                    careTaker.add(originator.saveStateToMemento());
                    
                    mazeView.getTalk1().setBounds(32 * 26, 32 * 1, 700, 50);//Sets the location of the dialogue box                                       
                    mazeView.talk1.setText("");
                    mazeView.talk2.setText("");
                                  
                    m.loadLevel("src\\levels\\level_2.txt");
                    p.setTileX(1);
                    p.setTileY(1);    
                }
                
                else if(m.getCurrentLevel() == 3){     
                    
                    originator.setScore(p.getScore());//Mmento Dp: checkpoints the score
                    careTaker.add(originator.saveStateToMemento());
                    
                    mazeView.talk1.setText("");
                    mazeView.talk2.setText("");
                    
                    m.loadLevel("src\\levels\\level_3.txt");
                    p.setTileX(1);
                    p.setTileY(16);    
                }
                
                else if(m.getCurrentLevel() == 4){     
                    
                    originator.setScore(p.getScore());//Mmento Dp: checkpoints the score
                    careTaker.add(originator.saveStateToMemento());
                    
                    mazeView.getTalk1().setText("");
                    mazeView.getTalk2().setText("");
                    
                    m.loadLevel("src\\levels\\level_4.txt");
                    p.setTileX(1);
                    p.setTileY(1);    
                }
                
                else if(m.getCurrentLevel() == 5){                     
                    
                    mazeView.getTalk2().setText("");                   
                    mazeView.getTalk1().setBounds(32 * 25, 32 * 10, 300, 40);
                    mazeView.getTalk1().setText("END OF DEMO! Thanks for playing!"); 
                    
                }
                                                            
                mazeView.setMap(m);
                mazeView.setPlayer(p);
            }
            
            else if( m.getMap(p.getTileX(), p.getTileY()) == 'b'){
               
               System.out.println("Playe hit a bomb!");   
               
               if( (p.getScore() - 40) <= 0 ){//Reduces the score
                   p.setScore(0);
                   //endState.doAction(context);//Puts the game in "endState" when the player dies
               }
               
               else
                  p.setScore(p.getScore() - 40);

               m.setMap(p.getTileX(), p.getTileY(), 'g');//Remove the bomb tile by replacing it with a normal "groundTile"
                                
               subject.setState(-10);
               p.setHealth(subject.getHealth());
               p.setArmor(subject.getArmor());
               
               if(p.getArmor() == 0){//If thw armor = 0 : re-decorate the player to his orginal state
                   
                    Character mainPlayer = new PlayerCharacter();//Decorator dp: creates new PlayerCharacter and returns it's image/decoration through the "laodCharacter" function
                    p.setPlayer(mainPlayer.loadCharcter());
               }
               
           }
            
            else if( m.getMap(p.getTileX(), p.getTileY()) == 'x'){//If the player steps on "SkullBomb"
               
               System.out.println("Playe hit a Skull Bomb!");   
               
               if( (p.getScore() - 55) <= 0 ){//Reduces the score
                   p.setScore(0);
                   //endState.doAction(context);//Puts the game in "endState" when the player dies
               }
               else
                 p.setScore(p.getScore() - 55);

               m.setMap(p.getTileX(), p.getTileY(), 'g');//Remove the bomb tile by replacing it with a normal "groundTile"
                                
               subject.setState(-20);
               p.setHealth(subject.getHealth());
               p.setArmor(subject.getArmor());
               
               if(p.getArmor() == 0){//If thw armor = 0 : re-decorate the player to his orginal state
                   
                    Character mainPlayer = new PlayerCharacter();//Decorator dp: creates new PlayerCharacter and returns it's image/decoration through the "laodCharacter" function
                    p.setPlayer(mainPlayer.loadCharcter());
               }
               
           }
            
            else if( m.getMap(p.getTileX(), p.getTileY()) == 'd'){//If the player steps on "Dynamite"
                               
               System.out.println("Playe hit a dynamote debuff!"); 
               
               if( (p.getScore() - 50) <= 0 ){//Reduces the score
                   p.setScore(0);
                   //endState.doAction(context);//Puts the game in "endState" when the player dies
               }
               else
                 p.setScore(p.getScore() - 50);

               m.setMap(p.getTileX(), p.getTileY(), 'g');//Remove the bomb tile by replacing it with a normal "groundTile"
               
               subject.setState(-15);//Reduces more health than hitting a bomb
               p.setHealth(subject.getHealth());
               p.setArmor(subject.getArmor());
               
               if(p.getArmor() == 0){//If thw armor = 0 : re-decorate the player to his orginal state
                   
                    Character mainPlayer = new PlayerCharacter();//Decorator dp: creates new PlayerCharacter and returns it's image/decoration through the "laodCharacter" function
                    p.setPlayer(mainPlayer.loadCharcter());
               }
               
            }
            
            else if( m.getMap(p.getTileX(), p.getTileY()) == 'a'){//If the player steps on an "ArmorTile"
                
                p.setScore(p.getScore() + 70);
                
                m.setMap(p.getTileX(), p.getTileY(), 'g');//Remove the armor tile by replacing it with a normal "groundTile"
                
                Character armoredPlayer = new ArmorDecorator(new PlayerCharacter());//Decorator DP: create a new "armoreDecorator"
                p.setPlayer(armoredPlayer.loadCharcter());//set the image of the player to the new armored image
                
                subject.setArmor(subject.getArmor() + 10);
                p.setArmor(subject.getArmor());//Adds armor value to the existing one
            }
            
            else if( m.getMap(p.getTileX(), p.getTileY()) == 'm'){//If the player steps on an "Ammo" Tile
                
                 p.setScore(p.getScore() + 55);                 
                 m.setMap(p.getTileX(), p.getTileY(), 'g');//Remove the ammo tile by replacing it with a normal "groundTile"
                 p.setAmmo(p.getAmmo() + 6);//Adds 6 new bullets
            }
            
            else if( m.getMap(p.getTileX(), p.getTileY()) == 'h'){//If the player steps on a "Health" Tile
                
                if(p.getHealth() + 20 > 100)
                   p.setHealth(100);
                
                else
                    p.setHealth(p.getHealth() + 20);
                
                 p.setScore(p.getScore() + 20);                 
                 m.setMap(p.getTileX(), p.getTileY(), 'g');//Remove the health tile by replacing it with a normal "groundTile"
         
            }
            
             else if( m.getMap(p.getTileX(), p.getTileY()) == 'j'){//If the player steps on a "Gem" Tile
                
                p.setScore(p.getScore() + 150);                 
                m.setMap(p.getTileX(), p.getTileY(), 'g');//Remove the gem tile by replacing it with a normal "groundTile" 
            }
                    
            
         }
         
      }

        @Override
        public void keyReleased(KeyEvent ke) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
        
    }
    
    
    //Class Listeners for the buttons on the interface
    //------------------------------------------------
    class NewGameListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
 
            p.setHealth(100);
            p.setArmor(0);
            p.setAmmo(6);
            p.setScore(0);
            p.setTileX(1);
            p.setTileY(7);
            
            m.setCurrentLevel(0);
            
            subject.setHealth(p.getHealth());//Observer DP: intializes the HEALTH values to the default value inside the "player" class
            subject.setArmor(p.getArmor());//Observer DP: intializes the ARMOR values to the default value inside the "player" class
            subject.setScore(p.getScore());
            
            mazeView.getTalk1().setText("Where am I ? Some kind of forest?");
            mazeView.getTalk2().setText("I need to find a way out...");
            mazeView.getTalk1().setBounds(32 * 4, 32 * 7, 400, 40);
            mazeView.getTalk2().setBounds(32 * 15, 32 * 7, 400, 40);
            
            m.loadLevel("src\\levels\\level_0.txt");
            
            startState.doAction(context);//Puts the game back into "Start State"
        }              
        
    }
    
    
    class ContinueListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            try {
                
            FileInputStream fileIn = new FileInputStream("saveGame.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            
            careTaker = (CareTaker) in.readObject();
            
            p.setHealth((int) in.readObject());
            p.setArmor((int) in.readObject());
            p.setAmmo((int) in.readObject());
            p.setScore((int) in.readObject());
            p.setTileX((int) in.readObject());
            p.setTileY((int) in.readObject());
            
            m.setCurrentLevel((int) in.readObject());
            m.setMapMatrix((char[][]) in.readObject());
            
            in.close();
            fileIn.close();
            
        }catch(IOException i) {
            
           System.out.println("Could not Load the file: saveGame.ser\n");
           i.printStackTrace(); 
           
        }catch(ClassNotFoundException e) {
            
            System.out.println("Class not Found while attempting to load saveGame.ser!\n");
            e.printStackTrace();
        }
            
            if(m.getCurrentLevel() == 0){
                m.loadLevel("src\\levels\\level_0.txt");
            }
            
            else if(m.getCurrentLevel() == 1){
                m.loadLevel("src\\levels\\level_1.txt");
            }
            
            else if(m.getCurrentLevel() == 2){
                m.loadLevel("src\\levels\\level_2.txt");
            }
            
            else if(m.getCurrentLevel() == 3){
                m.loadLevel("src\\levels\\level_3.txt");
            }
            
            else if(m.getCurrentLevel() == 4){
                m.loadLevel("src\\levels\\level_4.txt");
            }
           
            subject.setHealth(p.getHealth());//Observer DP: intializes the HEALTH values to the default value inside the "player" class
            subject.setArmor(p.getArmor());//Observer DP: intializes the ARMOR values to the default value inside the "player" class
            subject.setScore(p.getScore());
            
            mazeView.getTalk1().setText("");
            mazeView.getTalk2().setText("");
                     
            startState.doAction(context);//Puts the game back into "Start State"
        }              
        
    }
    
    
}
