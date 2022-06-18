import greenfoot.*;

/**
 * This class creates an explosion effect
 */
public class Explosion extends Actor 
{
    private GreenfootSound explosionSound;
    private GreenfootImage image;
    private int counter;
    private int explosionSoundsIndex;
    public Explosion()
    {
        image = new GreenfootImage("explosion.png");
        //Plays an explosion sound when created. 
        //explosionSound = new GreenfootSound ("explosion.wav");
        //explosionSound.setVolume(100);
        counter = 60;
        image.scale(140,140);
        setImage(image);
        //explosionSound.play();
    }

    public void act()
    {
        
        //removes after 1 second
        counter--;
        if(counter <= 0)
        {
            getWorld().removeObject(this);
        }
    }

}
