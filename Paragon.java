import greenfoot.*;
import java.util.List;

/**
 * The ultimate tower of destruction, the one who will exterminate the cats, there can be 
 * only one. Stats based on number of towers on screen. Inspired by btd6 paragons. 
 * 
 * @author Thomas Yang, Angus Feng, Leo Jia
 * @version June 2022
 */
public class Paragon extends Tower
{
    private GifImage gifImage;
    private GreenfootImage image = new GreenfootImage("gun.png"); ;
    private int radius = 2000;
    private int fireRate = 0;
    private int missleCounter;
    private int damage;
    private int speed;
    
    /**
     * Constructor for paragon, which sets, scales and rotates the upgraded image, as well as setting speed and damage which get passed in based
     * on the amount of nearby towers sacrificed
     * 
     * @param speed     Speed of projectiles fired by the paragon, decided by the amount of towers sacrificed
     * @param damage    Damage value of projectiles fired by the paragon, decided by the amount of towers sacrificed
     */
    public Paragon(int speed, int damage)
    {
        //setImage(image);       
        //image.scale(120,120);
        //image.rotate(270);
        missleCounter = 20;
        this.damage = damage;
        this.speed = speed;
        gifImage = new GifImage("WaterTowerUpgraded.gif");
        gifImage.resizeImages(150, 180);
        setImage( gifImage.getCurrentImage() );
    }
    
    /**
     * Can be stunned for a certain period of time, otherwise fire missiles and do the stardard enemy check found in Water Tower to find and attack
     * cats in the area.
     */
    public void act()
    {

        if(stun)
        {
            stunTimer--;
            if(stunTimer <= 0)
            {
                stun = false;
            }
        }
        else
        {
            missleCounter--;
            if(missleCounter <= 0)
            {
                spawnMissles();
                missleCounter = 100;
            }
            //if (checked() != true){
            enemyDetector();
            //}
        }

    }
    
    /**
     * Method to spawn 5 missiles on the paragon, which target the nearest cat.
     */
    private void spawnMissles()
    {
        getWorld().addObject(new Missile(), getX(), getY());
        getWorld().addObject(new Missile(), getX(), getY());
        getWorld().addObject(new Missile(), getX(), getY());
        getWorld().addObject(new Missile(), getX(), getY());
        getWorld().addObject(new Missile(), getX(), getY());
        
    }
    
    /**
     * A method that allows the paragon to detect cats through use of iterative loop - different from the enemy detector in Water Tower, as it
     * cannot be upgraded and bullet speed is more fluid (depending on the amount of towers sacrificed).
     */
    public void enemyDetector(){
        fireRate++;
        List<Cat> enemies = getObjectsInRange(radius, Cat.class);
        for (Cat fat: enemies){
            if (fireRate >4){
                setImage( gifImage.getCurrentImage() );
                fireRate = 0;
                Bullet bullet = new Bullet(damage, speed);
                getWorld().addObject(bullet, getX(), getY());
                bullet.turnTowards(fat.getX(),fat.getY());
                turnTowards(fat.getX(), fat.getY());
            }

        }

    }

}
