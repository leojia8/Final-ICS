import greenfoot.*;

/**
 * Gif image of the word victory, to be shown in the win world if the player wins. 
 * 
 * @author Thomas Yang
 * @version June 2022
 */
public class Victory extends Actor
{
    private GifImage gifImage;
    
    /**
     * Initializes and resizes the image.
     */
    public Victory()
    {
        
        gifImage = new GifImage("victory.gif");
        gifImage.resizeImages((int)(1400 * 0.7), (int)(400 * 0.7));
        
        
    }
    
    /**
     * Sets the next image every act.
     */
    public void act()
    {
        setImage( gifImage.getCurrentImage() );
    }
    

    
}
