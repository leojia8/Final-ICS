import greenfoot.*;
import java.util.*;

/**
 * The player class, a entity that the user can move around to play the game by collecting resources and placing towers.
 * <p> Uses WASD to move, space bar to collect resources, and has different GIF images depending on whether or not the user is collecting resources.
 * <p> Has sound effects when walking and placing towers.
 * 
 * @author Thomas Yang, Angus Feng
 * @version June 2022
 */
public class Player extends Actor  
{

    private GreenfootImage idleImage1;
    private GreenfootImage idleImage2;
    private int collectingCounter;
    private GreenfootSound stepSound;
    private boolean collecting;
    private ArrayList<Resources> resources;
    // 1 = up, 2 = right, 3 = down, 4 = left
    private int orientation;
    private Radius radius;
    private boolean addedRadius;
    private int health;
    private boolean moving;
    private GifImage idleImage;
    private GreenfootImage activeImage;
    private int immuneCounter;
    private GreenfootSound collectingSound;
    
    /**
     * Initializes and resizes the active and idle images, initializes and sets the volume of the sound effects and 
     * sets necessary variables for resource colecting/placing towers, health and the immunity counter.
     */
    public Player()
    {

        //Player starts with some beginning resources 
        activeImage = new GreenfootImage("Player.png");
        activeImage.scale(50, 62);
        idleImage = new GifImage("idle.gif");
        idleImage.resizeImages(50, 62);
        collectingCounter = 20;
        orientation = 4;
        addedRadius = false;
        collectingSound = new GreenfootSound("towerplacesound.wav");
        collectingSound.setVolume(70);
        stepSound = new GreenfootSound("stepsound.wav");
        stepSound.setVolume(83);
        
        health = 100;
        moving = false;
        immuneCounter = 120;
        //let the player start looking down 
    }

    /**
     * Checks for input to allow the player to move around using WASD and collect resources with space bar.
     */
    public void act()
    {
        //followMouse();
        // in act method (or method called by it) Taken from DanPost the legend

        if(Greenfoot.isKeyDown("SPACE"))
        {
            collecting = true;
        }
        else
        {
            collecting = false;
        }

        if(addedRadius == false)
        {
            radius = new Radius();
            getWorld().addObject(radius, getX(), getY());
            addedRadius = true;
        }
        immuneCounter--;
        if(immuneCounter <= 0)
        {
            Cat c = (Cat)getOneIntersectingObject(Cat.class);
            if(c != null)
            {
                GameWorld.removeHealth();
                getWorld().addObject(new Red(), 400, 400);
                immuneCounter = 120;
            }
        }
        // 1 = up, 2 = right, 3 = down, 4 = left
        collectingCounter--;
        if(collecting == false)
        {
            setImage( idleImage.getCurrentImage() );
        }
        else
        {
            setImage(activeImage);
        }
        if(Greenfoot.isKeyDown("S") && getY() < 780 )
        {
            stepSound.play();
            TowerButton a = (TowerButton)getOneObjectAtOffset(0, 50, TowerButton.class);
            if(a != null)
            {

            }
            else 
            {
                setLocation(getX(), getY() + 5);
                orientation = 3;
            }

        }
        else if(Greenfoot.isKeyDown("W") && getY() > 20)
        {
             stepSound.play();
            TowerButton a = (TowerButton)getOneObjectAtOffset(0, 50, TowerButton.class);
            if(a != null)
            {

            }
            else 
            {
                setLocation(getX(), getY() - 5);
                orientation = 1;
            }
        }
        else if(Greenfoot.isKeyDown("A") && getX() > 20)
        {
             stepSound.play();
            TowerButton a = (TowerButton)getOneObjectAtOffset(0, 50, TowerButton.class);
            if(a != null)
            {

            }
            else 
            {
                setLocation(getX() - 5, getY());
                orientation = 4;
            }
        }
        else if(Greenfoot.isKeyDown("D") && getX() < 1180)
        {
             stepSound.play();
            TowerButton a = (TowerButton)getOneObjectAtOffset(0, 50, TowerButton.class);
            if(a != null)
            {

            }
            else 
            {
                setLocation(getX() + 5, getY());
                orientation = 2;
            }
        }
        else if(collecting && collectingCounter <= 0)
        {
            collectingSound.play();
            boolean woodType = false;
            boolean stoneType = false;
            boolean metalType = false;
            resources = (ArrayList)getObjectsInRange(200, Resources.class);
            if (resources.size() > 0)
            {
                Resources r = resources.get(0);
                //System.out.println("Working");
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
                            GameWorld.addWood();
                        }
                        else if(r.getType() == 1 && stoneType == false)
                        {
                            stoneType = true;
                            r.takeResources();
                            GameWorld.addStone();
                        }
                        else if(r.getType() == 2 && metalType == false)
                        {
                            metalType = true;
                            r.takeResources();
                            GameWorld.addMetal();
                        }
                    }

                }
            }
            collectingCounter = 40;
        }

    }


}
