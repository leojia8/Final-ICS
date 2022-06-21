import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Subclass of cat - slower, bulkier enemy.
 * 
 * @author Thomas Yang, Leo Jia, Angus Feng
 * @version June 2022
 */
public class EggCat extends Cat
{
    private static GifImage master = new GifImage("eggAdjustedV2.gif");
    private GifImage gifImage;

    /**
     * Sets hp and type variables, initializes an Hp bar, and sets the GIF image.
     */
    public EggCat()
    {
        HP = 60;
        hpBar = new StatBar(HP, HP, this, 60, 5, 60, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);

        
        gifImage = new GifImage(master);
        gifImage.resizeImages(113, 125);
        type = 3;
    }

    /**
     * Updates the Hp bar to track damage done and moves the cat along the path at a set speed.
     * 
     * <p> Uses the superclass act method to check if the cat needs to be removed from the world.
     */
    public void act()
    {
        // Add your action code here.
        //super.act();
        hpBar.update(HP);
        setImage( gifImage.getCurrentImage() );
        moveAlongPath(1);
        super.act();

         
    }
}
