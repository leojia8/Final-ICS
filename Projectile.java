import greenfoot.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    private int xCoord;
    private int yCoord;
    private Cat targetCat;
    private ArrayList<Cat> cats;

    private int speed;
    private int counter;
    private GreenfootImage image;
    private String typeOfClass;

    private boolean target;
    private int immuneTimer;
    private boolean targetAwake;
    private GreenfootSound shootSound;

    //The bullet targets the actor that is in the parameter. 
    public Projectile()
    {

        image = new GreenfootImage("bullet.png");
        setImage(image);
        image.scale(30,30);
        image.rotate(90);
        immuneTimer = 15;

        //Makes sure the bullet searches for a new target. 
        target = true;
        targetAwake = true;

        //Plays a shoot sound when object is created. 
        shootSound = new GreenfootSound("shotgun.wav");
        shootSound.setVolume(50);
        shootSound.play();
    }

    public void act()
    {
        //To make sure the bullet does not kill the object shooting it. 
        immuneTimer--;

        //If the bullet has not found a target.
        if(target)
        {
            target = false;

            //targets class

            if(targetCat != null)
            {
                turnTowardsTarget();
            }

        }
        //makes the bullet move
        move (9);

        //If any of these objects are touching the bullet the bullet will kill them. 

        Cat c = (Cat)getOneIntersectingObject(Cat.class);
        if(target == true)
        {   

            getWorld().removeObject(this);
        }
        else if(c != null)
        {

            c.hit();
            getWorld().removeObject(this);

        }

        else
        {

            //remove if outside world. 
            if (getY() <= -10 || getY() >= 610 )
            {
                getWorld().removeObject(this);

            } 
            else if (getX() >= 810 || getX() <= -10)
            {
                getWorld().removeObject(this);

            }
        }

    }

    private void turnTowardsTarget()
    {

        //turns toward target 

        turnTowards(targetCat.getX(), targetCat.getY());
    }
    //This method makes the bullet target the object it is created to target if there are no cats in the world. This method is borrrowed from Mr. Cohen's bug simluation project. 
    private void targetClosest()
    {
        double closestTargetDistance = 0;
        double distanceToActor;
        int numCats;
        List neighbors = getNeighbours(300, true, Cat.class);
        World I = getWorld();

        if (!neighbors.isEmpty()) {
            numCats = I.getObjects(Cat.class).size();

            if(numCats > 0)
            {
                cats = (ArrayList)getObjectsInRange(300, Cat.class);
            }
            if (cats.size() > 0)
            {
                // set the first one as my target
                targetCat = cats.get(0);
                // Use method to get distance to target. This will be used
                // to check if any other targets are closer

                closestTargetDistance = GameWorld.getDistance (this, targetCat);

                // Loop through the objects in the ArrayList to find the closest target
                for (Cat o : cats)
                {
                    // Cast for use in generic method
                    //Actor a = (Actor) o;
                    // Measure distance from me
                    distanceToActor = GameWorld.getDistance(this, o);
                    // If I find a Zombie closer than my current target, I will change
                    // targets
                    if (distanceToActor < closestTargetDistance)
                    {
                        targetCat = o;
                        closestTargetDistance = distanceToActor;
                    }
                }

            }
        }

    }

}