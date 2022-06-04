
import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class BossCat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossCat extends Cat
{
    private GreenfootImage image;
    private int speed;
    private boolean reverse; 
    private int HP = 1200;
    private int counter;
    private boolean justSpawned;
    private ArrayList<Tower> towers;
    private Tower targetTower;
    
    /**
     * Constructor for objects of class BossCat
     */
    public BossCat()
    {
        hpBar = new StatBar(HP, HP, this, 100, 9, 100, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
        reverse = true;
        image = new GreenfootImage("normalcat.png");
        image.scale(64,64);
        setImage(image);
        counter = 15;
        justSpawned = true;
        speed = 1;
    }

    public void act()
    {
        if(HP % 10 == 0)
        {
            BossAttack b = new BossAttack();
            getWorld().addObject(b, getX(), getY());
            HP--;
            int numTowers;
            List neighbors = getNeighbours(2000, true, Tower.class);
            World I = getWorld();

            if (!neighbors.isEmpty()) {
                numTowers = I.getObjects(Tower.class).size();

                if(numTowers > 0)
                {
                    towers = (ArrayList)getObjectsInRange(300, Tower.class);
                }
                if (towers.size() > 0)
                {
                    // set the first one as my target
                    targetTower = towers.get(0);
                    // Use method to get distance to target. This will be used
                    // to check if any other targets are closer
                    if(targetTower != null)
                    {
                        //targetTower.stun();
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
                            //o.stun();
                        }
                    }

                }
            }
        }
        if(justSpawned)
        {
            BossRing b = new BossRing();
            
                
            getWorld().addObject(b, getX(), getY());
            justSpawned = false;
        }
        counter--;
        if(counter <= 0)
        {

            if(reverse)
            {

                speed--;
                setLocation(getX(), getY() + speed/2);
                if(speed == -5)
                {
                    reverse = false;
                }
            }
            else if(reverse == false)
            {
                speed++;
                setLocation(getX(), getY() + speed/2);
                if(speed == 5)
                {
                    reverse = true;
                }
            }
            counter = 15;
        }

    }

}
