import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
/**
 * A faint yellow circle that fades in and out around the boss for visual effect
 * 
 * @author Thomas Yang, Angus Feng, Leo Jia
 * @version June 2022
 */
public class BossRing extends Actor
{

    private static GifImage master = new GifImage("ring.gif");
    private GifImage gifImage;
    private boolean justSpawned;
    private ArrayList<BossCat> cats;
    private BossCat targetCat;
    private int spawnCounter;
    /**
     * Sets the master GIF image, resizes it to fit around the boss and sets variables for the fading effect
     */
    public BossRing()
    {
        gifImage = new GifImage(master);
        gifImage.resizeImages(160, 160);
        spawnCounter = 10;
        justSpawned = true;
    }

    /**
     * If there is a Boss Cat in the world, follows the Boss Cat while fading in and out - else removes itself from the world
     */
    public void act(){
        spawnCounter--;
        if(justSpawned && spawnCounter <= 10)
        {
            targetCat = (BossCat)getOneIntersectingObject(BossCat.class);
            justSpawned = false;
        }
        else if(justSpawned == false)
        {
            if(targetCat != null && targetCat.getWorld() != null)
            {
                setLocation(targetCat.getX(), targetCat.getY());
                setImage( gifImage.getCurrentImage() );
            }
            else
            {
                getWorld().removeObject(this);
            }

        }

    }
}

