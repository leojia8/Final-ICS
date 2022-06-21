import greenfoot.*;

/**
 * A class representing a end screen for the game, to be shown if the player wins. 
 * 
 * @author Thomas Yang
 * @version June 2022
 */

public class WinWorld extends World
{
    private GreenfootImage image;
    private TextButton begin = new TextButton("Restart", 100, Color.BLACK, Color.WHITE);
    /**
     * Creates a new world, sets and resizes the background and adds a button that allows the user to replay the game.
     */
    public WinWorld()
    {
        super(1200, 800, 1);
        image = new GreenfootImage("victory.jpg");
        image.scale(1200,800);
        setBackground(image);
        addObject(new Victory(), 600, 100);
        addObject(begin, 1280/2, 720);
    }
    
    
    /**
     * Restarts the simulation by setting the world back to the welcome world if the "restart" button is clicked. 
     */
    public void act()
    {
        //starts the simulation when the start button is clicked
        if (Greenfoot.mouseClicked(begin)){
            WelcomeWorld welcomeworld = new WelcomeWorld();
            Greenfoot.setWorld(welcomeworld);
        } 
    }
    
  
}
