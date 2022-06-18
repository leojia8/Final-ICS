import greenfoot.*;
import java.util.List;

/**
 * The ultimate tower of destruction, the one who will exterminate the cats, there can be 
 * only one. Stats based on number of towers on screen. Inspired by btd6 paragons. 
 * 
 * @author Thomas Yang
 * 
 */
public class Paragon extends Tower
{
    private GreenfootImage image = new GreenfootImage("gun.png"); ;
    private int radius = 2000;
    private int fireRate = 0;
    private int missleCounter;
    private int damage;
    private int speed;
    public Paragon(int speed, int damage)
    {
        setImage(image);       
        image.scale(120,120);
        image.rotate(270);
        missleCounter = 20;
        this.damage = damage;
        this.speed = speed;
    }
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
    
    private void spawnMissles()
    {
        getWorld().addObject(new Missile(), getX(), getY());
        getWorld().addObject(new Missile(), getX(), getY());
        getWorld().addObject(new Missile(), getX(), getY());
        getWorld().addObject(new Missile(), getX(), getY());
        getWorld().addObject(new Missile(), getX(), getY());
        
    }
    
    
    public void enemyDetector(){
        fireRate++;
        List<Cat> enemies = getObjectsInRange(radius, Cat.class);
        for (Cat fat: enemies){
            if (fireRate >4){
                fireRate = 0;
                Bullet bullet = new Bullet(damage, speed);
                getWorld().addObject(bullet, getX(), getY());
                bullet.turnTowards(fat.getX(),fat.getY());
                turnTowards(fat.getX(), fat.getY());
            }

        }

    }

}
