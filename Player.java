import greenfoot.*;
import java.util.*;

/**
 * This class will be the player class who the user will control. 
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
    private int collectingCounter;
    private boolean collecting;
    private ArrayList<Resources> resources;
    // 1 = up, 2 = right, 3 = down, 4 = left
    private int orientation;
    /**
     * Constructor for objects of class Dog
     */
    public Player()
    {

        //Player starts with some beginning resources 
        numStone = 5;
        numMetal = 5;
        numWood = 5;
        collectingCounter = 20;
        orientation = 4;
        //let the player start looking down 
    }

    public void act()
    {
        // 1 = up, 2 = right, 3 = down, 4 = left
        collectingCounter--;
        if(Greenfoot.isKeyDown("down") && getY() < 780)
        {

            setLocation(getX(), getY() + 1);
            orientation = 3;
        }
        else if(Greenfoot.isKeyDown("up") && getY() > 20)
        {
            setLocation(getX(), getY() - 1);
            orientation = 1;
        }
        else if(Greenfoot.isKeyDown("left") && getX() > 20)
        {
            setLocation(getX() - 1, getY());
            orientation = 4;
        }
        else if(Greenfoot.isKeyDown("right") && getX() < 1180)
        {
            setLocation(getX() + 1, getY());
            orientation = 2;
        }

        // in act method (or method called by it) Taken from DanPost the legend
        if (collecting && (Greenfoot.mouseDragEnded(null) || Greenfoot.mouseClicked(null))) collecting = false;
        if (!collecting && Greenfoot.mousePressed(null)) collecting = true;

        if(collecting && collectingCounter <= 0)
        {
            boolean woodType = false;
            boolean stoneType = false;
            boolean metalType = false;
            resources = (ArrayList)getObjectsInRange(100, Resources.class);
            if (resources.size() > 0)
            {
                Resources r = resources.get(0);
                // Loop through the objects in the ArrayList to find the closest target
                for (Resources o : resources)
                {
                    r = o;
                    if(r != null)
                    {
                        if(r.getType() == 0 && woodType == false) 
                        {
                            woodType = true;
                            r.takeResources();
                        }
                        else if(r.getType() == 1 && stoneType == false)
                        {
                            stoneType = true;
                             r.takeResources();
                        }
                        else if(r.getType() == 2 && metalType == false)
                        {
                            metalType = true;
                             r.takeResources();
                        }
                    }

                    
                }

            }
            collectingCounter = 20;
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
