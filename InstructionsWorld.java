import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An instruction menu telling the user what to do.
 * 
 * @author Leo Jia
 * @version June 2022
 */
public class InstructionsWorld extends World
{
    private GreenfootImage image;
    private TextButton next = new TextButton("Next", 100, Color.BLACK, Color.WHITE);
    /**
     * Sets and scales the instructions image. Adds a button to allow the user to go to the game world.
     * 
     */
    public InstructionsWorld()
    {    
        super(1200, 800, 1); 
        
        image = new GreenfootImage("instructionsworldv2.png");
        image.scale(1200, 800);
        setBackground(image);
        
        addObject(next, 1110, 750);
    }
    
    /**
     * Sends the user to the game world when the next button is clicked.
     */
    public void act()
    {
        
        if (Greenfoot.mouseClicked(next)){
            GameWorld gameWorld = new GameWorld();
            Greenfoot.setWorld(gameWorld);
        } 
    }
}
