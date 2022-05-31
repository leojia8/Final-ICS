import greenfoot.*;


/**
 * Write a description of class WelcomeWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WelcomeWorld extends World
{
    private GreenfootImage image;
    
    public WelcomeWorld()
    {
        super(1200,800,1);
        image = new GreenfootImage("StartImage");
        image.scale(1200,800);
        setBackground(image);
        
        
    }

    
    
    
}
