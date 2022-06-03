import greenfoot.*;

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Resources
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Rock
     */
    public Rock()
    {
        super();
        resourceType = 1;
        resourcesLeft = 20;
        image = new GreenfootImage("rock.png");
        image.scale(100,64);
        transImage = new GreenfootImage(100,64);
        setImage(transImage);
        //setImage(image);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
