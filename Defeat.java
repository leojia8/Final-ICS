import greenfoot.*;

/**
 * Gif image of the word defeat, to be shown in the lose world if the player loses. 
 * 
 * @author Thomas Yang, Angus Feng, Leo Jia
 * @version June 2022
 */
public class Defeat extends Actor
{
    private GifImage gifImage;
    /**
     * Initializes and resizes the image.
     */
    public Defeat()
    {
        
        gifImage = new GifImage("defeat.gif");
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
