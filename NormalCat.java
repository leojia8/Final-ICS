/**
 * Write a description of class NormalCat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import greenfoot.*;
public class NormalCat extends Cat 
{
    // instance variables - replace the example below with your own
    private static GifImage master = new GifImage("flippednormalgif.gif");
    private GifImage gifImage;
    private static final int HP = 70;
    
    public NormalCat()
    {
        
        hpBar = new StatBar(HP, HP, this, 30, 5, 60, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
        
        
        gifImage = new GifImage(master);
        gifImage.resizeImages(100, 87);
    }

    public void act()
    {
        setImage( gifImage.getCurrentImage() );
    }
}
