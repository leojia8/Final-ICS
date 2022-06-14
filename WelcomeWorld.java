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
    private TextButton begin = new TextButton("Begin!", 100, Color.BLACK, Color.WHITE);
    public WelcomeWorld()
    {
        super(1200,800,1);
        image = new GreenfootImage("Title Screen.jpg");
        image.scale(1200,800);
        setBackground(image);
        addObject(begin, 1280/2, 720);
        
        
        
    }

    
    public void act()
    {
        //starts the simulation when the start button is clicked
        if (Greenfoot.mouseClicked(begin)){
            StoryWorld storyworld = new StoryWorld();
            Greenfoot.setWorld(storyworld);
        } 
    }
    
}
