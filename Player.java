import greenfoot.*;


/**
 * Write a description of class Dog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor  
{
    private int numStone;
    private int numMetal;
    private int numWood;
    private GreenfootImage idleImage1;
    private GreenfootImage idleImage2;
    
    /**
     * Constructor for objects of class Dog
     */
    public Player()
    {
        numStone = 5;
        numMetal = 5;
        numWood = 5;
        
        
    }

    public void act()
    {
        
        if(Greenfoot.isKeyDown("down") && getY() < 780)
        {
            setLocation(getX(), getY() + 1);
            
        }
        else if(Greenfoot.isKeyDown("up") && getY() > 20)
        {
            setLocation(getX(), getY() - 1);
            
        }
        else if(Greenfoot.isKeyDown("left") && getX() > 20)
        {
            setLocation(getX() - 1, getY());
        }
        else if(Greenfoot.isKeyDown("right") && getX() < 1180)
        {
            setLocation(getX() + 1, getY());
        }
        
        
        
    }
    
    
    
    public void addStone()
    {
        numStone++;
    }
    public void addMetal()
    {
        numMetal++;
    }
    public void addWood()
    {
        numWood++;
    }
}
