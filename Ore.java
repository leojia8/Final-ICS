import greenfoot.*;

/**
 * Write a description of class Ore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ore extends Resources
{
    

    /**
     * Constructor for objects of class Ore
     */
    public Ore()
    {
        super();
        resourceType = 2;
        resourcesLeft = 10;
        image = new GreenfootImage("ore.png");
        image.scale(100,64);
        setImage(image);
                
        
    }

    
}
