import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Projectile
{
    private int damage;
    private int speed;
    public Bullet(int damage, int speed)
    {
        this.damage = damage;
        this.speed = speed;
    }
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
       move(speed);
    }
    
    public int getDamage()
    {
        return damage;
    }
}
