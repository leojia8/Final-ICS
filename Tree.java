import greenfoot.*;

/**
 * Write a description of class Tree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tree extends Resources
{
    
    /**
     * Constructor for objects of class Tree
     */
    public Tree()
    {
        super();
        resourceType = 0;
        resourcesLeft = 15;
        image = new GreenfootImage("tree.png");
        image.scale(64,64);
        transImage = new GreenfootImage(64,64);
        setImage(transImage);
        //setImage(image);
        
        hpBar = new StatBar(resourcesLeft, resourcesLeft, this, 30, 5, 35, Color.GREEN, new Color(255, 204, 203), false, Color.WHITE, 1);
        
        
    }

    
}
