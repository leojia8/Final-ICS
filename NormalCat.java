import greenfoot.*;

/**
 * Subclass of cat - basic fodder, with no special traits.
 * 
 * @author Thomas Yang, Leo Jia, Angus Feng
 * @version June 2022
 */
public class NormalCat extends Cat 
{
    // instance variables - replace the example below with your own
    private static GifImage master = new GifImage("flippednormalgif.gif");
    private GifImage gifImage;
   
    
    /**
     * Sets Hp and type variables, initializes an HP bar, and sets the GIF image.
     */
    public NormalCat()
    {
        noPath = false;
        HP = 25;
        hpBar = new StatBar(HP, HP, this, 30, 5, 60, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
        counter = 20;
        rotation = 90;
        gifImage = new GifImage(master);
        gifImage.resizeImages(100, 87);
        type = 4;
    }

    /**
     * Updates the HP bar to track damage done and moves the normal cat along the path at a set speed.
     * 
     * <p> Uses the superclass act method to check if the cat needs to be removed from the world.
     */
    public void act()
    {
        
        setImage( gifImage.getCurrentImage() );
        hpBar.update(HP);
        moveAlongPath(2);
        super.act();
    }
}
