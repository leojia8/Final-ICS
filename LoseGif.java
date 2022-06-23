import greenfoot.*;

/**
 * Gif image of a cat drawing on some schematics, to be shown in the lose world if the player loses.
 * 
 * @author Thomas Yang
 * @version June 2022
 */
public class LoseGif extends Actor
{
    private GifImage gifImage;
    
    /**
     * Initializes and resizes the image.
     */
    public LoseGif()
    {
        
        gifImage = new GifImage("lose.gif");
        gifImage.resizeImages((int)(450), (int)(450));
        
        
    }
    
    /**
     * Sets the next image every act.
     */
    public void act()
    {
        setImage( gifImage.getCurrentImage() );
    }
    

    
}
