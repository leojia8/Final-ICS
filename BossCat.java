
import greenfoot.*;
/**
 * Write a description of class BossCat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossCat extends Cat
{
    private GreenfootImage image;
    private int speed;
    private boolean reverse; 
    /**
     * Constructor for objects of class BossCat
     */
    public BossCat()
    {
        
        
        
    }
    
    
    public void act()
    {
        if(speed == 5)
        {
            speed--;
            setLocation(getX(), getY() + speed);
        }
        else if(speed == -5)
        {
            speed++;
            setLocation(getX(), getY() + speed);
        }
       
        
        
    
    
    
    }

    
    
    
    
    
}
