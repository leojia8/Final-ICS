import greenfoot.*;

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    private GifImage master = new GifImage("explosion.gif");
    private GifImage gifImage;
    private int counter;
    /**
     * Constructor for objects of class Explosion
     */
    public Explosion()
    {
        counter = 280;
        gifImage = new GifImage(master);
        gifImage.resizeImages(300,300);
        gifImage.restartGif();
    }

    
    public void act()
    {
        setImage( gifImage.getCurrentImage() );
        counter--;
        if(counter <= 0)
        {
            getWorld().removeObject(this);
        }
    }
}
