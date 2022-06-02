import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Cat extends Actor
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
        // Add your action code here.
    }
    
    public void addedToWorld(World w){
        w.addObject(hpBar, getX(), getY() + 20);
    }
    
    public void hit()
    {
        health--;
    }
}
