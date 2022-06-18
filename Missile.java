import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
import java.util.*;
import greenfoot.GreenfootImage;

/*
 * This class creates missle objects that target and follow instances of the Jeep class. 
 */
public class Missile extends SuperSmoothMover
{
    private Cat targetCat;
    private ArrayList<Cat> cats;
    private boolean retarget;
    private int speed;
    private int counter;
    private GreenfootImage image;
    private GreenfootSound launchSound;
    private int timer;
    public Missile()
    {
        //Setting image
        image = new GreenfootImage ("missle.png");
        image.scale(40,150);
        image.rotate(90);
        setImage(image);
        speed = 5;
        counter = 0;
        setRotation(Greenfoot.getRandomNumber(360));
        //Initializing sounds
        //launchSound = new GreenfootSound("launch.wav");
        //launchSound.setVolume(40);
        //launchSound.play();
        timer = 30;
    }

    /**
     * Private method, called by act(), that constantly checks for closer targets. Borrowed from
     * Mr. Cohen's bug simulation project. 
     */
    private void targetClosestCat ()
    {
        double closestTargetDistance = 0;
        double distanceToActor;
        int num; 
        List neighbors = getNeighbours(2000, true, Cat.class);
        World I = getWorld();
        if (!neighbors.isEmpty()) {
            num =  I.getObjects(Cat.class).size();

            if(num > 0)
            {
                cats = (ArrayList)getObjectsInRange(2000, Cat.class);
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
                    // If I find a Jeep closer than my current target, I will change
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

    /**
     * Private method, called by act(), that moves toward the target,
     * or explodes it if within range. Borrowed from Mr.Cohen's bug simulation project.
     */
    private void moveTowardOrDestroyJeep()
    {

        turnTowards(targetCat.getX(), targetCat.getY());
        move(6);

    }

    public void act()
    {
        timer--;
        if(timer >= 0)
        {

            move(speed);
        }
        else
        {

            //If the missile needs to retarget
            if(retarget == true)
            {
                targetClosestCat ();
                retarget = false;
            }

            //If the target does not exist in the world anymore
            if(targetCat == null)
            {
                retarget = true;
            }
            // If my current target Jeep exists, move toward it
            if (targetCat != null && targetCat.getWorld() != null)
            {
                moveTowardOrDestroyJeep();

            }
            // If I can't find anything to move towards, move in the current direction I am travelling
            else
            {
                move (speed);
                if(getWorld() != null)
                {
                    if (getY() <= -10 || getY() >= 900 ){
                        getWorld().removeObject(this);
                    } else if (getX() >= 1210|| getX() <= -10){
                        getWorld().removeObject(this);
                    }
                }

            }
            if(getWorld()!= null)
            {
                Cat j = (Cat)getOneIntersectingObject (Cat.class);
                if (j != null)
                {
                    j.hit();
                    getWorld().removeObject(this); // Remove myself

                }
            }
        }
    }
}

