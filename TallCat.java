import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Subclass of cat - faster, weaker enemy.
 * 
 * @author Thomas Yang, Leo Jia, Angus Feng
 * @version June 2022
 */
public class TallCat extends Cat
{
    private static GifImage master = new GifImage("tallCatAdjusted.gif");
    private GifImage gifImage;
    
    /**
     * Sets Hp and type variables, initializes an HP bar, and sets the GIF image.
     */
    public TallCat()
    {
        HP = 20;
        hpBar = new StatBar(HP, HP, this, 45, 5, 60, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);

        gifImage = new GifImage(master);
        gifImage.resizeImages(141, 264);
        type = 2;
        counter = 10;
    }

    /**
     * Updates the Hp bar to track damage done and moves the tall cat along the path at a set speed.
     * 
     * <p> Uses the superclass act method to check if the cat needs to be removed from the world.
     */
    public void act()
    {
        // Add your action code here.
        hpBar.update(HP);
        setImage( gifImage.getCurrentImage() );
        moveAlongPath(4);
        super.act();

    }
    
    
}
