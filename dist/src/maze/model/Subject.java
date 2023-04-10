//Part of the "Observer" DP
//The subject class to watch all the obervers


package maze.model;

/**
 *
 * @author Yahia
 */

import java.util.ArrayList;

public class Subject {
    
    private ArrayList<Observer> observers = new ArrayList<>();    
    private int state;
    private int health;
    private int Armor;
    private float score = 0;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
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

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
    
    
    public void attach(Observer observer){
        observers.add(observer);
    }
    
    
    public void notifyAllObservers(){
        
        for(Observer observer : observers){
            
            observer.update();
        }
    }
   
    
}
