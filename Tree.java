import greenfoot.*;

/**
 * Subclass of resource, which spawns trees that can be collected for wood used to create towers.
 * 
 * @author Thomas Yang, Angus Feng, Leo Jia
 * @version June 2022
 */
public class Tree extends Resources
{
    
    /**
     * Sets the resource type, the amount of resources that can be harvested, sets and scales the image, and initializes the health bar that acts
     * as a visual representation of the amount of resources left to be harvested for the user.
     */
    public Tree()
    {
        super();
        resourceType = 0;
        resourcesLeft = 4;
        image = new GreenfootImage("tree.png");
        image.scale(64,64);
        transImage = new GreenfootImage(64,64);
        setImage(transImage);
        //setImage(image);
        
        hpBar = new StatBar(resourcesLeft, resourcesLeft, this, 30, 5, 35, Color.GREEN, new Color(255, 204, 203), false, Color.WHITE, 1);
        
        
    }

    
}
