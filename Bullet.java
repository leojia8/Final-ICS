import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Projectiles shot by water towers and paragons. 
 * 
 * @author Angus Feng, Thomas Yang, Leo Jia
 * @version June 2022
 */
public class Bullet extends Projectile
{
    private int damage;
    private int speed;
    private GreenfootImage image;
    private GreenfootSound shootSound;
    
    /**
     * Takes in damage and speed parameters from the enemyDetector() methods in the tower classes. Initializes the image and sound effect.
     * 
     * @param damage    Damage of bullet, set in enemyDetector() methods.
     * @param speed     Speed of bullet, set in enemyDetector() methods.
     */
    public Bullet(int damage, int speed)
    {
        this.damage = damage;
        this.speed = speed;
        image = new GreenfootImage("waterball_sprite.png");
        setImage(image);
        shootSound = new GreenfootSound("shooting.mp3");
        shootSound.setVolume(20);
        shootSound.play();
    }
    /**
     * Moves in the direction it was shot.
     */
    public void act()
    {
       move(speed);
    }
    
    /**
     * Returns the damage value of the bullet
     */
    public int getDamage()
    {
        return damage;
    }
}
