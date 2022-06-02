
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
        //addObject(new Player(), 400, 400);
        addObject(new NormalCat(), 400, 500);
    }

    
    
    public void act()
    {
        
        spawnResources();
    }
    
    
    
    //method that spawns resources 
    
    private void spawnResources()
    {
        spawnNumber = Greenfoot.getRandomNumber(1000);
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
    
    
    //Borrowed from Mr. Cohen. Method makes the world get the distance between two objects 
    public static float getDistance (Actor a, Actor b)
    {
        double distance;
        double xLength = a.getX() - b.getX();
        double yLength = a.getY() - b.getY();
        distance = Math.sqrt(Math.pow(xLength, 2) + Math.pow(yLength, 2));
        return (float)distance;

    }
}
