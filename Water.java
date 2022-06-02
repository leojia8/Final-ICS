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
    public Water()
    {
        super();
        shootSound = new GreenfootSound("watershootsound.wav");
        shootSound.setVolume(50);
        shootSound.play();
    }

    
}
