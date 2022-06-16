import greenfoot.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Projectile extends Actor
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
    protected GreenfootSound shootSound;
    protected int damage;
    protected int pierce;
    //The bullet targets the actor that is in the parameter. 
    public Projectile()
    {

        //Makes sure the bullet searches for a new target. 
        target = true;
        image = new GreenfootImage("cactus.png");
        image.scale(20,20);
        //Plays a shoot sound when object is created. 

    }

    public void act()
    {
        

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
        List neighbors = getNeighbours(200, true, Cat.class);
        World I = getWorld();

        if (!neighbors.isEmpty()) {
            numCats = I.getObjects(Cat.class).size();

            if(numCats > 0)
            {
                cats = (ArrayList)getObjectsInRange(200, Cat.class);
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