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
        transImage = new GreenfootImage(100,64);
        setImage(transImage);
        //setImage(image);
        
        hpBar = new StatBar(resourcesLeft, resourcesLeft, this, 30, 5, 60, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
                

    }

    
}
