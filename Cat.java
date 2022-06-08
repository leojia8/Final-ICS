import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Cat extends SuperSmoothMover
{
    protected int health;
    protected int speed;
    protected int damage;

    protected StatBar hpBar;
    public Cat ()
    {

    }

    /**
     * Act - do whatever the Cat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act()
    {
         if(getWorld() != null)
            {
                if (getY() <= -10 || getY() >= 810 )
                {
                    getWorld().removeObject(this);

                } 
                else if (getX() >= 1210 || getX() <= -10)
                {
                    getWorld().removeObject(this);

                }
            }
    }

    public void addedToWorld(World w){
        w.addObject(hpBar, getX(), getY() + 20);
    }

    public void hit()
    {
        health--;
    }
}
