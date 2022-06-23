import greenfoot.*;

/**
 * Whiteout effect that covers the world, similar to the red effect when taking damage. Becomes transparent over time.
 * 
 * @author Thomas Yang
 * @version June 2022
 */
public class WhiteOut extends Actor
{
    private int counter;
    private GreenfootImage image;
    /**
     * Initializes and scales the image, then initializes counter for length and transparency.
     */
    public WhiteOut()
    {
        
        image = new GreenfootImage("white.png");
        image.scale(2000,2000);
        
        counter = 225;
        
        
        image.setTransparency(counter);
        setImage(image);
    }
    
    /**
     * Makes the image more transparent over time, until the counter is under 0, at which point it is removed from the world.
     */
    public void act()
    {
        image.setTransparency(counter);
        setImage(image);
        counter-= 8;
        if(counter <= 0)
        {
            getWorld().removeObject(this);
        }
        
        
        
        
    }
    
    
    
    

}
