import greenfoot.*;

/**
 * Write a description of class Water here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
