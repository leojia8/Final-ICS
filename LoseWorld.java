import greenfoot.*;

/**
 * A class representing a end screen for the game, to be shown if the player loses.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoseWorld extends World
{
    private GreenfootImage image;
    private TextButton begin = new TextButton("Restart", 100, Color.BLACK, Color.WHITE);
    private TextButton score = new TextButton("Show Score", 100, Color.BLACK, Color.WHITE);
   
    private GreenfootSound sound;
    /**
     * Creates a new world, then sets its background to the appropriate image.
     */
    public LoseWorld()
    {
        super(1200, 800, 1);

        image = new GreenfootImage("black.jpg");
        sound = new GreenfootSound("losesound.mp3");
        sound.play();
        setBackground(image);
        
        addObject(new Defeat(), 600, 100);
        addObject(new LoseGif(), 600, 500);
        addObject(begin, 600, 700);
        addObject(score, 600, 800);
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
        else if (Greenfoot.mouseClicked(score)){
            addObject (new ScoreBoard(720, 480), 400, 320);
        } 
    }

}
