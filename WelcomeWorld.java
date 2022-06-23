import greenfoot.*;


/**
 * A start world for the game. has a "Begin!" button that allows the user to move forward into the story world.
 * 
 * @author Thomas Yang 
 * @version June 2022
 */
public class WelcomeWorld extends World
{
    private GreenfootImage image;
    private TextButton begin = new TextButton("Begin!", 100, Color.BLACK, Color.WHITE);
    private TextButton BossLevel = new TextButton("Go to Boss Level", 100, Color.BLACK, Color.WHITE);
    /**
     * Creates a new world, sets and resizes the background and adds a button that, when pressed, moves the user forward to the story world.
     */
    public WelcomeWorld()
    {
        super(1200,800,1);
        image = new GreenfootImage("Title Screen.jpg");
        
        image.scale(1200,800);
        setBackground(image);
        addObject(begin, 600, 580);
        addObject(BossLevel, 600, 740);
        
        
        
        
        
    }

    /**
     * Starts the simulation when the start button is clicked.
     */
    public void act()
    {
        //starts the simulation when the start button is clicked
        if (Greenfoot.mouseClicked(begin)){
            StoryWorld storyworld = new StoryWorld();
            Greenfoot.setWorld(storyworld);
        } 
          else if (Greenfoot.mouseClicked(BossLevel)){
            GameWorld gw = new GameWorld();
            gw.cheatRound();
            Greenfoot.setWorld(gw);
        } 
    }
    
}
