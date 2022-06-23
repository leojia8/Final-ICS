
import greenfoot.*;
/**
 * Subclass of tower - creates "cat food", a secondary resource used to upgrade towers
 * 
 * @author Thomas Yang
 * @version June 2022
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
           
            counter = 600;
        }
        
        
        
        
    }
    
    
   
    

}
