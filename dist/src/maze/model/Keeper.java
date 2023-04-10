
package maze.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Yahia
 */
public class Keeper extends NPC implements ActionListener{

    
    public Keeper(){   
        
        this.dialogue = new String();
        
        ImageIcon img = new ImageIcon("src\\images\\npc\\keeper_default.gif");
        this.npcIcon = img.getImage();       
    }

  
    
    @Override
    public String executeDialogue(int dialogueNumber) {
        
        if(dialogueNumber == 1){
            
            ImageIcon img = new ImageIcon("src\\images\\npc\\keeper_default.gif");
            this.npcIcon = img.getImage();
            return "Welcome, welcome! Come on in, don't shy away!";
        }
        else if(dialogueNumber == 2)
            return "Execuse the state of the house, I haven't had a visitor in..well..I can't rembemer how long it was.";
        else if(dialogueNumber == 3){
            
            ImageIcon img = new ImageIcon("src\\images\\npc\\keeper_pose1.gif");
            this.npcIcon = img.getImage();
            return "Oh me? I am the keeper of this place.";
        }
        else if(dialogueNumber == 4){
            
            ImageIcon img = new ImageIcon("src\\images\\npc\\keeper_default.gif");
            this.npcIcon = img.getImage();
            return "But enough about me. You seem lost, because no one would come here of their own accord.";
        }
        else if(dialogueNumber == 5)
            return "Although, I still find it odd that you would get lost here of all places. Do you even know where you are?";
        else if(dialogueNumber == 6){
            
            ImageIcon img = new ImageIcon("src\\images\\npc\\keeper_pose2.gif");
            this.npcIcon = img.getImage();
            return "Welcome to the Labyrinthian! Well, what's left of it.";
        }
        else if(dialogueNumber == 7)
            return "This place, or more accuratley, this realm was constructed long ago by Arch Mage Shalidor.";
        
        else if(dialogueNumber == 8)
            return "It would serve as a test to aspiring new mages who wanted to join the College of Winterhold";
        
        else if(dialogueNumber == 9)
            return "But the place has long since been abandoned after it's owner's death";
        
        else if(dialogueNumber == 10){
            
            ImageIcon img = new ImageIcon("src\\images\\npc\\keeper_pose3.gif");
            this.npcIcon = img.getImage();
            return "You want to get out? Well, as you may have guessed, you can't get out the same same way you came in.";
        }
        else if(dialogueNumber == 11)
            return "Your only option is to take the test and pass Shalidor's Maze.Then a portal will appear.";
        else if(dialogueNumber == 12){
            
            ImageIcon img = new ImageIcon("src\\images\\npc\\keeper_default.gif");
            this.npcIcon = img.getImage();
            return "Though, getting to the maze itself has become somewhat of an inconvenience due to it's current state";
        }
        else if(dialogueNumber == 13)
            return "Oh look at me! I have kept you waiting long enough. Go now, and try not to die too fast....HHHHHHHH..";

        
        return null;
    }

    @Override
    public void executeScriptedEvent(int eventNumber) {
        
        if(eventNumber == 1){
            
            this.currentEvent = 1;
            
            this.currentDialogue = 2;
       
            this.dialogue = executeDialogue(1);
            
            this.timer = new Timer(8000, this);
            this.timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(this.currentEvent == 1){          
            
            if( !(currentDialogue > 13) ){
                             
               this.dialogue = executeDialogue(currentDialogue);
               this.currentDialogue++;
            }
            else{
                this.timer.stop();
                this.dialogue = "";//When the dialogue script is over, set it to empty
            }
        }
        
    }
    
    
}
