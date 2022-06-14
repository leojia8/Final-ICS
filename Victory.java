import greenfoot.*;
public class Victory extends Actor
{
    private GifImage gifImage;
    public Victory()
    {
        
        gifImage = new GifImage("victory.gif");
        gifImage.resizeImages((int)(1400 * 0.7), (int)(400 * 0.7));
        
        
    }
    
    
    public void act()
    {
        setImage( gifImage.getCurrentImage() );
    }
    

    
}
