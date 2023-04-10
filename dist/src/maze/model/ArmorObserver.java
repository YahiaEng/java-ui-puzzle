//Part of the "Observer" DP
//One of the observer calsses


package maze.model;

import static java.lang.Math.abs;

/**
 *
 * @author Yahia
 */
public class ArmorObserver extends Observer{
    
    
    public ArmorObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        
        if(this.subject.getArmor() != 0){//If the player still has armor
            
            if( (int) (this.subject.getArmor() + (this.subject.getState() * 0.7)) < 0){
                
                this.subject.setArmor(0);
                
                int healthDamage = abs( (int)(this.subject.getArmor() + (this.subject.getState() * 0.7)) );
                
                if(this.subject.getHealth() - healthDamage < 0)
                    this.subject.setHealth(0);
                
                else                   
                  this.subject.setHealth(this.subject.getHealth() - healthDamage);
            }
            
            else
              this.subject.setArmor((int) (this.subject.getArmor() + (this.subject.getState() * 0.7)));
            
        }
        
    }
    
}
