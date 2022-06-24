import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The abstract superclass for towers, which the player places to defend themselves from the cat hordes. Has functionality to upgrade towers using 
 * "cat food", as well as a method to track and set the duration of the stun effect created by the Boss Cat.
 * 
 * <p> As our towers (factory tower, which makes cat food, and water tower/paragon, which attacks cats) are very different, they don't have a lot of
 * shared functionality.
 * 
 * @author Thomas Yang, Angus Feng , Leo Jia
 * @version June 2022
 */
public abstract class Tower extends Actor
{
    protected int stunTimer = 180;
    protected boolean stun;
    protected int type;
    protected int damage;
    protected boolean upgraded;
    /**
     * Scales the image, and sets damage for the attacking towers.
     */
    public Tower(){
        getImage().scale(60,60);
        damage = 1;
        
    }

    public void act()
    {
        // Add your action code here.

    }
    
    /**
     * Functionality to upgrade towers - If a water tower has been upgraded, increase the damage by a set amount.
     */
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

    /**
     * Applies the damage multiplier to upgraded towers.
     */
    protected void addDamage()
    {
        damage = damage  * 3;
    }

    /**
     * Stuns towers, which makes them stop working for a set period of time.
     */
    protected void stun()
    {
        stun = true;
        stunTimer = 60;
    }

}
