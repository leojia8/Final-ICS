
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
        
        
    }
    
    public void act()
    {
        counter--;
        if(counter <= 0)
        {
            //add1Gold
            //add1Wood
            //add1Stone
            counter = 200;
        }
        
        
        
        
    }
    
    
    

}
