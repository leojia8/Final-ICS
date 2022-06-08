import greenfoot.*;

/**
 * Write a description of class WhiteOut here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WhiteOut extends Actor
{
    private int counter;
    private GreenfootImage image;
    /**
     * Constructor for objects of class WhiteOut
     */
    public WhiteOut()
    {
        
        image = new GreenfootImage("white.png");
        image.scale(2000,2000);
        
        counter = 0;
        
        
        image.setTransparency(counter);
    }
    
    
    public void act()
    {
        image.setTransparency(counter);
        counter+= 5;
        if(counter >= 200)
        {
            getWorld().removeObject(this);
        }
    }
    
    
    
    

}
