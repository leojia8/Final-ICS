import greenfoot.*;

/**
 * Projectile shot by towers
 * 
 * @author Thomas Yang
 * @version June 2022
 */
public class Water extends Projectile  
{

    /**
     * Constructor for objects of class Water
     */
    public Water(int damage)
    {
        super();
        shootSound = new GreenfootSound("shooting.mp3");
        shootSound.setVolume(50);
        shootSound.play();
        this.damage = damage;
    }

    
}
