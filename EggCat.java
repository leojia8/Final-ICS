import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EggCat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EggCat extends Cat
{
    private static GifImage master = new GifImage("eggAdjustedV2.gif");
    private GifImage gifImage;

    public EggCat()
    {
        HP = 60;
        hpBar = new StatBar(HP, HP, this, 60, 5, 60, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);

        
        gifImage = new GifImage(master);
        gifImage.resizeImages(113, 125);
    }

    /**
     * Act - do whatever the EggCat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
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
