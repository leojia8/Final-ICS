
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
    private boolean teleported;
    private boolean teleported2;
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
        teleported = false;
        teleported2 = false;
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
        System.out.println(HP);
        moveAlongPathCat(1);
        hpBar.update(HP);
        setImage( gifImage.getCurrentImage() );
        if(HP <= 9000 && teleported == false)
        {
            counter2 = 40;
            rotation = 90;
            setLocation(160, 120);
            teleported = true;
        }
        else if(HP <= 7000 && teleported2 == false)
        {
            counter2 = 40;
            rotation = 90;
            setLocation(400, 760);
            teleported2 = true;
        }
        if(HP % 200 == 0)
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
            

            getWorld().addObject(new NormalCat(), 160, 120);

            getWorld().addObject(new NormalCat(), 240, 440);

            getWorld().addObject(new NormalCat(), 400, 760);
            HP--;
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

      private void moveAlongPathCat(int speed){
        if(rotation == 90)
        {
            setLocation(getX() + speed, getY());
            if(counter2 <= 0)
            {
                Square s = (Square)getOneObjectAtOffset(80, 0, Square.class);
                if (s == null)
                {
                    noPath = true;

                }
                counter2 = 80;
            }
        }
        else if(rotation == 0)
        {
            setLocation(getX(), getY() - speed);
            if(counter2 <= 0)
            {
                Square s = (Square)getOneObjectAtOffset(0, -80, Square.class);
                if(s == null)
                {
                    noPath = true;

                }
                counter2 = 80;
            }
        }
        else if(rotation == 180)
        {
            setLocation(getX(), getY() + speed);
            if(counter2 <= 0)
            {
                Square s = (Square)getOneObjectAtOffset(0, 80, Square.class);
                if(s == null)
                {
                    noPath = true;

                }
                counter2 = 80;
            }
        }
        else if(rotation == 270)
        {
            setLocation(getX() - speed, getY());
            if(counter2 <= 0)
            {
                Square s = (Square)getOneObjectAtOffset(-80, 0, Square.class);

                if(s == null)
                {
                    noPath = true;

                }
                counter2 = 80;
            }
        }
        counter2--;

        if(noPath)
        {

            Square s = (Square)getOneObjectAtOffset(-80, 0, Square.class);
            Square s2 = (Square)getOneObjectAtOffset(0, 80, Square.class);
            Square s3 = (Square)getOneObjectAtOffset(0, -80, Square.class);
            Square s4 = (Square)getOneObjectAtOffset(80, 0, Square.class);

            if(s != null && rotation != 90 && noPath == true)
            {

                rotation = 270;
                noPath = false;
            }

            if(s3 != null && rotation != 180 && noPath == true)
            {
                rotation = 0;
                noPath = false;
            }
            if(s2 != null && rotation != 0 && noPath == true)
            {
                rotation = 180;
                noPath = false;

            }

            if(s4 != null && rotation != 270 && noPath == true)
            {
                rotation = 90;
                noPath = false;
            }

            if(noPath)
            {
                this.setLocation(2000, 2000);
                Greenfoot.setWorld(new LoseWorld());
                getWorld().addObject(new Red(), 400, 400);
            }

        }
    }
}
