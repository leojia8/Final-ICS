
import greenfoot.*;
/**
 * Write a description of class BossCat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossCat extends Cat
{
    private GreenfootImage image;
    private int speed;
    private boolean reverse; 
    private static final int HP = 1200;
    private int counter;
    private boolean justSpawned;
    /**
     * Constructor for objects of class BossCat
     */
    public BossCat()
    {
        hpBar = new StatBar(HP, HP, this, 30, 5, 60, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
        reverse = true;
        image = new GreenfootImage("normalcat.png");
        image.scale(64,64);
        setImage(image);
        counter = 15;
        justSpawned = true;
    }

    public void act()
    {
        
        if(justSpawned)
        {
            
        }
        counter--;
        if(counter <= 0)
        {
            
            if(reverse)
            {

                speed--;
                setLocation(getX(), getY() + speed);
                if(speed == -5)
                {
                    reverse = false;
                }
            }
            else if(reverse == false)
            {
                speed++;
                setLocation(getX(), getY() + speed);
                if(speed == 5)
                {
                    reverse = true;
                }
            }
            counter = 15;
        }

    
    
    }

    
    
}
