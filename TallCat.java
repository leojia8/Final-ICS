import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TallCat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TallCat extends Cat
{
    private static GifImage master = new GifImage("tallCatAdjusted.gif");
    private GifImage gifImage;
    private static final int HP = 100;
    
    public TallCat()
    {
        
        hpBar = new StatBar(HP, HP, this, 45, 5, 60, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
        
        
        gifImage = new GifImage(master);
        gifImage.resizeImages(141, 264);
    }
    
    /**
     * Act - do whatever the TallCat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        super.act();
        setImage( gifImage.getCurrentImage() );
        move();
    }
}
