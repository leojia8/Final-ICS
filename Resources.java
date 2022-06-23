import greenfoot.*;

/**
 * A class representing resources that are spawned randomly across the world that the player collects to build towers. Has 3 different types/subclasses:
 * Metal(ore), Stone(rock) and Wood(tree).
 * 
 * @author Thomas Yang, Angus Feng, Leo Jia
 * @version June 2022
 */
public abstract class Resources extends Actor
{
    protected int resourcesLeft;
    protected int resourceType;
    protected GreenfootImage image;
    protected GreenfootImage transImage;
    protected boolean foundLocation;
    protected int timer;
    
    protected StatBar hpBar;
    
    /**
     * Sets necessary variables to ensure the resource does not spawn on the path, the player, other resources or the tower select buttons.
     */
    public Resources()
    {
        foundLocation = false;
        timer = 0;
    }

    /**
     * Method used by all resource subclasses to ensure the resource does not spawn on other entities. If after 100 acts the resource still has not
     * found a spot, it will be removed from the world. Also, if the ore/rock/tree cannot be harvested any further (the player has harvested all 
     * possible ressources from it), it will be removed from the world.
     */
    public void act()
    {
        if(foundLocation == false)
        {
            timer++;
            //The rock will detect if it is touching the lane or any other resource or the player. 
            Square square = (Square)getOneIntersectingObject(Square.class);
            Player player = (Player)getOneIntersectingObject(Player.class);
            Resources r = (Resources)getOneIntersectingObject(Resources.class);
            Grey g = (Grey)getOneIntersectingObject(Grey.class);
            TowerButton b = (TowerButton)getOneIntersectingObject(TowerButton.class);
            if(square != null)
            {
                setLocation(Greenfoot.getRandomNumber(1100), Greenfoot.getRandomNumber(700));

            }
            else if(player != null)
            {
                setLocation(Greenfoot.getRandomNumber(1100), Greenfoot.getRandomNumber(700));
            }
            else if(r != null)
            {
                setLocation(Greenfoot.getRandomNumber(1100), Greenfoot.getRandomNumber(700));
            }
            else if(b != null)
            {
                setLocation(Greenfoot.getRandomNumber(1100), Greenfoot.getRandomNumber(700));
            }
            else if(g != null)
            {
                setLocation(Greenfoot.getRandomNumber(1100), Greenfoot.getRandomNumber(700));
            }
            else
            {
                foundLocation = true;
                setImage(image);
                getWorld().addObject(hpBar, getX(), getY() + 20);
            }
            if(timer >= 100)
            {
                getWorld().removeObject(this);
            }
        }
        else
        {
            if(resourcesLeft <= 0)
            {
                getWorld().removeObject(this);
            }
        }

    }

    public void addedToWorld(World w){
        
    }
    
    /**
     * Used by player to collect resources - decreases the amount of resources that can be collected from the ore/rock/tree, and updates it's hp bar.
     */
    public void takeResources()
    {

        resourcesLeft--;
        
        hpBar.update((int)resourcesLeft);
    }

    /**
     * Returns the type of resource.
     */
    public int getType()
    {
        return resourceType;
    }

}
