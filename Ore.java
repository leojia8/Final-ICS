import greenfoot.*;

/**
 * Subclass of resource, which spawns ores that can be collected for metal used to create towers.
 * 
 * @author Thomas Yang
 * @version June 2022
 */
public class Ore extends Resources
{
    

    /**
     * Sets the resource type, the amount of resources that can be harvested, sets and scales the image, and initializes the health bar that acts
     * as a visual representation of the amount of resources left to be harvested for the user.
     */
    public Ore()
    {
        super();
        resourceType = 2;
        resourcesLeft = 6;
        image = new GreenfootImage("ore.png");
        image.scale(100,64);
        transImage = new GreenfootImage(100,64);
        setImage(transImage);
        //setImage(image);
        
        hpBar = new StatBar(resourcesLeft, resourcesLeft, this, 30, 5, 35, Color.GREEN, new Color(255, 204, 203), false, Color.WHITE, 1);
                

    }

    
}
