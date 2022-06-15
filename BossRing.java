import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class BossRing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
     * Constructor for objects of class BossRing
     */
    public BossRing()
    {
        gifImage = new GifImage(master);
        gifImage.resizeImages(160, 160);
        spawnCounter = 10;
        justSpawned = true;
    }

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

