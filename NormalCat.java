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
    private static GifImage master = new GifImage("normalcatgif.gif");
    private GifImage gifImage;
    public NormalCat()
    {

        gifImage = new GifImage(master);
        gifImage.resizeImages(120, 100);
    }

    public void act()
    {
        setImage( gifImage.getCurrentImage() );
    }
}
