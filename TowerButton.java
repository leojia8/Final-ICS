import greenfoot.*;


/**
 * Write a description of class TowerButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class TowerButton extends Actor 
{
    
    // 0 = water tower, 1 = _____, 2 = _______.
    protected int type;
    protected GreenfootImage image;
    public TowerButton()
    {
        
         
    }
    
    
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            if(type == 0)
            {
                //WaterTower w = new WaterTower();
                //getWorld().addObject(w, getX(), getY());
            }
            else if(type == 1)
            {
                
            }
            else if(type == 2)
            {
                
            }
            
        }
    }
}
