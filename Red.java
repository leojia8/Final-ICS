import greenfoot.*;

/**
 * A translucent red rectangle that fades over time that covers the entire game world, to be shown if the player takes damage.
 * 
 * @author Thomas Yang
 * @version June 2022
 */
public class Red extends Actor
{
    private int counter;
    private GreenfootImage image;
    /**
     * Setting and scaling the image, as well as initializing the counter for length and transparancy. 
     */
    public Red()
    {
        
        image = new GreenfootImage("red.jpg");
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
