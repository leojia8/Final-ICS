import greenfoot.*;

/**
 * Subclass of resource, which spawns rocks that can be collected for stone used to create towers.
 * 
 * @author Thomas Yang
 * @version June 2022
 */
public class Rock extends Resources
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Sets the resource type, the amount of resources that can be harvested, sets and scales the image, and initializes the health bar that acts
     * as a visual representation of the amount of resources left to be harvested for the user.
     */
    public Rock()
    {
        super();
        resourceType = 1;
        resourcesLeft = 7;
        image = new GreenfootImage("rock.png");
        image.scale(100,64);
        transImage = new GreenfootImage(100,64);
        setImage(transImage);
        //setImage(image);
        
        hpBar = new StatBar(resourcesLeft, resourcesLeft, this, 30, 5, 40, Color.GREEN, new Color(255, 204, 203), false, Color.WHITE, 1);
    }

}
