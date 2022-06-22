import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Subclass of tower - attacks cats, can be upgraded into a much stronger version (paragon).
 * 
 * @author Thomas Yang, Angus Feng
 * @version June 2022
 */
public class WaterTower extends Tower
{
    private static GifImage master = new GifImage("WaterTowerUpgraded.gif");
    private GifImage gifImage;
    private GreenfootImage image = new GreenfootImage("gun.png"); ;
    private int radius = 500;
    private int fireRate = 0;
    private int num;
    private WaterTower targetGun;
    private ArrayList<WaterTower> guns;
    private int paragonCounter;
    private int dam;
    private int speed;
    private int x;
    private int y;
    private boolean addedToWorld;
    
    /**
     * Setting, scaling, resizing and rotating the GIF image, as well as initializing some necessary variables for upgrades
     */
    public WaterTower(){
        gifImage = new GifImage(master);
        gifImage.resizeImages(100, 120);
        setImage(image);       
        image.scale(100,100);
        image.rotate(270);
        type = 0;
        upgraded = false;
        paragonCounter = -1;
        addedToWorld = false;
    }

    /**
     * Checks for and attacks any cats in range. Functionality to upgrade damage, to upgrade into a paragon (which removes nearby towers), 
     * and to be stunned by Boss Cat.
     * <p> If clicked on by the user and the user has enough cat food, opens buttons which when clicked will upgrade the tower.
     */
    public void act()
    {
        if(addedToWorld == false)
        {
            x = getX();
            y = getY();
            addedToWorld = true;
        }

        if(paragonCounter >= 0)
        {
            GameWorld.upgrading();
            setLocation(getX() + (Greenfoot.getRandomNumber(6)-3), getY() + (Greenfoot.getRandomNumber(6) - 3));
            if(paragonCounter % 3 == 0)
            {
                setLocation(x, y);
            }
            paragonCounter--;
            if(paragonCounter <= 0)
            {
                getWorld().addObject(new Paragon(speed, dam), getX(), getY());
                getWorld().addObject(new WhiteOut(), getX(), getY());
                GameWorld.stopUpgrading();
                getWorld().removeObjects(getNeighbours(3000, true, WaterTower.class));
                getWorld().removeObject(this);
            }
        }
        else if(stun)
        {
            stunTimer--;
            if(stunTimer <= 0)
            {
                stun = false;
            }
        }
        else
        {
            if(Greenfoot.mouseClicked(this) && GameWorld.isUpgrading() == false )
            {
                if(GameWorld.getCatFood() >= 30)
                {
                    ParagonButton p = new ParagonButton(this, "Upgrade to Paragon / Cost: 30 Cat Food", 50, Color.BLACK, Color.WHITE);
                    getWorld().addObject(p, 600, 600);
                    CancelButton c = new CancelButton(this, "Cancel", 50, Color.BLACK, Color.WHITE);
                    getWorld().addObject(c, 1000, 400);
                    GameWorld.upgrading();
                }
                if(upgraded == false)
                {
                    if(GameWorld.getCatFood() > 0)
                    {
                        UpgradeButton b = new UpgradeButton(this, "Upgrade: x3 Damage / Cost: 1 Cat Food", 50, Color.BLACK, Color.WHITE); 

                        GameWorld.upgrading();
                        getWorld().addObject(b, 400, 400);
                        getWorld().removeObjects(getNeighbours(3000, true, CancelButton.class));
                        CancelButton c = new CancelButton(this, "Cancel", 50, Color.BLACK, Color.WHITE);
                        getWorld().addObject(c, 1000, 400);

                    }
                }
            }
            
            //if (checked() != true){
            enemyDetector();
            //}
        }
    }

    /**
     * A method to upgrade a water tower into a paragon, with damage and speed values set depending on the amount of other nearby water towers 
     * sacrificed 
     */
    public void upgradeParagon()
    {


        List neighbors = getNeighbours(2000, true, WaterTower.class);
        World I = getWorld();
        if (!neighbors.isEmpty()) {
            num =  I.getObjects(WaterTower.class).size();

        }

        if(num > 30)
        {
            dam = 7;
            speed = 10;
        }
        else if(num > 20)
        {
            dam = 4;
            speed = 8;
        }
        else if(num > 10)
        {
            dam = 3;
            speed = 6;
        }
        else 
        {
            dam = 1;
            speed = 4;
        }

        paragonCounter = 90;
    }

    /**
     * A method that allows the water towers to detect enemies through use of iterative loop.
     */
    public void enemyDetector(){
        fireRate++;
        List<Cat> enemies = getObjectsInRange(radius, Cat.class);
        for (Cat fat: enemies){
            if(upgraded)
            {
                setImage( gifImage.getCurrentImage() );
            }
            if (fireRate >13){
                fireRate = 0;
                Bullet bullet = new Bullet(damage, 4);
                getWorld().addObject(bullet, getX(), getY());
                bullet.turnTowards(fat.getX(),fat.getY());
                turnTowards(fat.getX(), fat.getY());
            }

        }

    }
    /**
     * public void addedToWorld(World w){
    if (checked() != true){
    getWorld().removeObject(this);
    }
    else{
    setImage(image);       
    image.scale(100,100);
    }

    }
    private boolean checked(){
    Square square = (Square)getOneIntersectingObject(Square.class);
    Player player = (Player)getOneIntersectingObject(Player.class);
    Resources r = (Resources)getOneIntersectingObject(Resources.class);
    if (square != null || player != null || r != null){
    return false;
    }
    return true;
    }
     */

}
