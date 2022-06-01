/**
 * Write a description of class Resources here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


import greenfoot.*;

public abstract class Resources extends Actor
{
    protected int resourcesLeft;
    protected int resourceType;
    protected GreenfootImage image;
    public Resources()
    {
        
        
    }

    public void act()
    {
        
        if(resourcesLeft <= 0)
        {
            getWorld().removeObject(this);
        }
    }
    
    public void takeResources()
    {
        
        Player player = (Player)getOneIntersectingObject(Player.class);
        if(player != null)
        {
            resourcesLeft = resourcesLeft;
            if(resourceType == 0)
            {
                player.addWood();
            }
            else if(resourceType == 1)
            {
                player.addStone();
            }
            else if(resourceType == 2)
            {
                player.addMetal();
            }
        }
    }
    
    public int getType()
    {
        return resourceType;
    }
    
    
}
