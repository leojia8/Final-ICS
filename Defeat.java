import greenfoot.*;
public class Defeat extends Actor
{
    private GifImage gifImage;
    public Defeat()
    {
        
        gifImage = new GifImage("defeat.gif");
        gifImage.resizeImages((int)(1400 * 0.7), (int)(400 * 0.7));
        
        
    }
    
    
    public void act()
    {
        setImage( gifImage.getCurrentImage() );
    }
    

    
}
