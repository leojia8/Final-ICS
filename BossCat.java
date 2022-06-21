
import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Subclass of cat - the ultimate boss enemy, spawned during round 10.
 * 
 * <p> Has a lot of extra functionality including the ability to stun towers, the ability to spawn more cats and multiple extra visual effects
 * 
 * @author Thomas Yang
 * @version June 2022
 */
public class BossCat extends Cat
{
    private GreenfootImage image;
    private int speed;
    private boolean reverse; 

    private int counter;
    private int counter2;
    private boolean justSpawned;
    private ArrayList<Tower> towers;
    private Tower targetTower;
    private GifImage gifImage;

    /**
     * Sets Hp, type, speed, initializes an hp bar and sets the GIF image. Also has some other variables for the extra functionalities
     */
    public BossCat()
    {
        HP = 10000;
        hpBar = new StatBar(HP, HP, this, 100, 9, 100, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
        reverse = true;
        type = 1;
        
        justSpawned = true;
        speed = 1;
        gifImage = new GifImage("bosscat.gif");
        gifImage.resizeImages(110, 130);
        counter2 = 40;
    }

    /**
     * Moves the boss cat along the path, sets the GIF image and updates the hp bar - all pretty standard.
     * <p> Every time the boss cat's hp is divisible by 100, do a stun attack in the form of a big expanding red circle that stuns towers.
     * <p> Every time the boss cat's hp is divisible by 150, make a "whiteout" effect and spawn a few normal cats.
     * <p> When the boss first spawns, add a Boss Ring, which is a small circle that fades in and out for visual effect.
     * <p> Once the boss dies, add an explosion and go to win world. Otherwise, if the boss does not die it uses the superclass act method to 
     * remove itself from the world.
     */
    public void act()
    {
        moveAlongPath(1);
        hpBar.update(HP);
        setImage( gifImage.getCurrentImage() );
        if(HP % 100 == 0)
        {
            BossAttack b = new BossAttack();
            getWorld().addObject(b, getX(), getY());
            HP--;
            int numTowers;
            List neighbors = getNeighbours(600, true, Tower.class);
            World I = getWorld();

            if (!neighbors.isEmpty()) {
                numTowers = I.getObjects(Tower.class).size();

                if(numTowers > 0)
                {
                    towers = (ArrayList)getObjectsInRange(600, Tower.class);
                }
                if (towers.size() > 0)
                {
                    // set the first one as my target
                    targetTower = towers.get(0);
                    // Use method to get distance to target. This will be used
                    // to check if any other targets are closer
                    if(targetTower != null)
                    {
                        targetTower.stun();
                    }

                    // Loop through the objects in the ArrayList to find the closest target
                    for (Tower o : towers)
                    {
                        // Cast for use in generic method
                        //Actor a = (Actor) o;
                        // Measure distance from me
                        if(o != null)
                        {
                            targetTower = o;
                            o.stun();
                        }
                    }

                }
            }
        }
        if(HP % 150 == 0)
        {
            WhiteOut w = new WhiteOut();
            getWorld().addObject(w, 600, 600);

            getWorld().addObject(new NormalCat(), 160, 120);

            getWorld().addObject(new NormalCat(), 240, 440);

            getWorld().addObject(new NormalCat(), 400, 760);

        }
        if(justSpawned)
        {
            BossRing b = new BossRing();

            getWorld().addObject(b, getX(), getY());
            justSpawned = false;
        }
        
        if(HP <= 0)
        {
            Explosion e = new Explosion();
            getWorld().addObject(e, getX(), getY());

            Greenfoot.setWorld(new WinWorld());
        }
        
        super.act();

    }

}
