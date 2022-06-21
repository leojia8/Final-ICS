import greenfoot.*;
public class LoseGif extends Actor
{
    private GifImage gifImage;
    public LoseGif()
    {
        
        gifImage = new GifImage("lose.gif");
        gifImage.resizeImages((int)(450), (int)(450));
        
        
    }
    
    
    public void act()
    {
        setImage( gifImage.getCurrentImage() );
    }
    

    
}
