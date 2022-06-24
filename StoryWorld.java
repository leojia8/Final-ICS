
import greenfoot.*;
/**
 * A story menu for the simulation. Tells users the story of the game, as well as how to play.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StoryWorld extends World
{
    private GreenfootImage image;
    
    public StoryWorld() 
    {
        super(1200, 800, 1);
        
        image = new GreenfootImage("storyworldtext.png");
        image.scale(1200, 800);
        setBackground(image);
    }

    public void act()
    {
        
    }
    
    
    
    
    
    
    
    
}
