//Part of the "Observer" DP
//One of the observer calsses


package maze.model;

/**
 *
 * @author Yahia
 */
public class HealthObserver extends Observer{
    
    
    public HealthObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    
    
    @Override
    public void update() {
        
      if(this.subject.getArmor() == 0){//If the player has no armor left, then add the damage/bonus from the player's health
        
        if(this.subject.getHealth() + this.subject.getState() < 0){//If the damage is greater than the current health then the health is set to zero
            this.subject.setHealth(0);
        }
        
        else if(this.subject.getHealth() + this.subject.getState() > 100){//If the player recieves a "health gift" that makes the health go over it limit of 100, then set the heakth to 100 
            this.subject.setHealth(100);
        }
        
        else{
            
             this.subject.setHealth(this.subject.getHealth() + this.subject.getState());
        }
        
     }
    
   }
    
    
}
