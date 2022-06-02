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
    protected boolean foundLocation;
    public Resources()
    {
        foundLocation = false;

    }

    public void act()
    {
        if(foundLocation == false)
        {
            //The rock will detect if it is touching the lane or any other resource or the player. 
            //Square square = (Square)getOneIntersectingObject(Square.class);
            Player player = (Player)getOneIntersectingObject(Player.class);
            Resources r = (Resources)getOneIntersectingObject(Resources.class);
            //if(square != null)
            //{
            //    setLocation(Greenfoot.getRandomNumber(1100), Greenfoot.getRandomNumber(700));
            //}
            //else if(player != null)
            //{
            //    setLocation(Greenfoot.getRandomNumber(1100), Greenfoot.getRandomNumber(700));
            //}
            //else if(r != null)
            //{
            //    setLocation(Greenfoot.getRandomNumber(1100), Greenfoot.getRandomNumber(700));
            //}
            //else
            //{
            //    foundLocation = true;
            //    setImage(image);
            //}
        }
        else
        {
            if(resourcesLeft <= 0)
            {
                getWorld().removeObject(this);
            }
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
