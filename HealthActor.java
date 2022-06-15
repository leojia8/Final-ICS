import greenfoot.*;


/**
 * Write a description of class HealthActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthActor extends Actor
{
    private StatBar hpBar;
    private int HP;
    private GreenfootImage image;
    private boolean added;
    /**
     * Constructor for objects of class HealthActor
     */
    public HealthActor()
    {
        HP = 10;
        hpBar = new StatBar(HP, HP, this, 300, 20, 60, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);

        image = new GreenfootImage(1,1);
        setImage(image);

        added = false;
    }

    public void act()
    {
        HP = GameWorld.getHP();
        hpBar.update(HP);
        
        if(added == false)
        {
            getWorld().addObject(hpBar, getX(), getY() + 20);
            added = true;
        }
    }

    
    
}
