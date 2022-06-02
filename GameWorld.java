
import greenfoot.*;
/**
 * Here we will need to implement many things including resource spawning, cat spawning, and how the lane is going to orient. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld  extends World
{
    // instance variables - replace the example below with your own
    private int x;
    private int spawnNumber;
    /**
     * Constructor for objects of class GameWorld
     */
    public GameWorld()
    {
        super(1200, 800, 1);
    }

    
    
    public void act()
    {
        spawnNumber = Greenfoot.getRandomNumber(1000);
    }
    
    
    
    //method that spawns resources 
    
    private void spawnResources()
    {
        if(spawnNumber == 500)
        {
            int type = Greenfoot.getRandomNumber(2);
            
            if(type == 0)
            {
                this.addObject(new Rock(), Greenfoot.getRandomNumber(1100), Greenfoot.getRandomNumber(700));
            }
            else if(type == 1)
            {
                this.addObject(new Tree(), Greenfoot.getRandomNumber(1100), Greenfoot.getRandomNumber(700));
            }
            else if(type == 2)
            {
                this.addObject(new Ore(), Greenfoot.getRandomNumber(1100), Greenfoot.getRandomNumber(700));
            }
        }
    }
    
}
