
package maze.model;

import java.awt.Image;
import javax.swing.Timer;

/**
 *
 * @author Yahia
 */
public abstract class NPC {
    
    protected String dialogue;
    protected Image npcIcon;
    protected Timer timer;
    protected int currentEvent;
    protected int currentDialogue;
    
    public abstract String executeDialogue(int dialogueNumber);
    
    public abstract void executeScriptedEvent(int eventNumber);
    
    
     public String getDialogue() {
        return dialogue;
    }

    public Image getNpcIcon() {
        return npcIcon;
    }

    public Timer getTimer() {
        return timer;
    }

    public int getCurrentEvent() {
        return currentEvent;
    }

    public int getCurrentDialogue() {
        return currentDialogue;
    }
     
     

    
}
