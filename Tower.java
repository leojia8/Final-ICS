import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Tower extends Actor
{
    protected int stunTimer = 180;
    protected boolean stun;
    protected int type;
    protected int damage;
    protected boolean upgraded;
    /**
     * Act - do whatever the Tower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Tower(){
        getImage().scale(60,60);
        damage = 1;
        
    }

    public void act()
    {
        // Add your action code here.

    }
    protected void upgrade()
    {
        if(GameWorld.getCatFood() > 0)
        {
            upgraded = true;
            GameWorld.takeCatFood();
            if(type == 0)
            {
                addDamage();
            }
            else if(type == 1)
            {
                
            }
            else if(type == 2)
            {

            }
        }

    }

    protected void addDamage()
    {
        damage = damage  * 3;
    }

    protected void stun()
    {
        stun = true;
        stunTimer = 60;
    }

}
