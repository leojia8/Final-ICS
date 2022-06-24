
import greenfoot.*;
/**
 * A story menu for the simulation. Tells users the story of the game.
 * 
 * @author Leo Jia 
 * @version June 2022
 */
public class StoryWorld extends World
{
    private GreenfootImage image;
    private TextButton next = new TextButton("Next", 100, Color.BLACK, Color.WHITE);
    /**
     * Sets and scales the story image. Adds a button to allow the user to go to the instructions world
     */
    public StoryWorld() 
    {
        super(1200, 800, 1);
        
        image = new GreenfootImage("storyworldtext.png");
        image.scale(1200, 800);
        setBackground(image);
        
        addObject(next, 1110, 750);
    }
    
    /**
     * Sends the user to the instructions world when the next button is clicked.
     */
    public void act()
    {
        
        if (Greenfoot.mouseClicked(next)){
            InstructionsWorld instructionsWorld = new InstructionsWorld();
            Greenfoot.setWorld(instructionsWorld);
        } 
    }
    
    
    
}
