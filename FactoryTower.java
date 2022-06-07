
import greenfoot.*;
/**
 * Write a description of class FactoryTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FactoryTower extends Tower
{
    private int counter;
    
    /**
     * Constructor for objects of class FactoryTower
     */
    public FactoryTower()
    {
        
        counter = 0;
        
        type = 2;
    }
    
    public void act()
    {
        counter--;
        if(counter <= 0)
        {
            GameWorld.addCatFood();
           
            counter = 200;
        }
        
        
        
        
    }
    
    
   
    

}
