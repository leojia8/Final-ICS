import greenfoot.*;


/**
 * A health bar in the top left of the screen, displaying the amount of HP the player has left.
 * 
 * @author Thomas Yang
 * @version June 2022
 */
public class HealthActor extends Actor
{
    private StatBar hpBar;
    private int HP;
    private GreenfootImage image;
    private boolean added;
    /**
     * Sets the max hp of the player + initializes the player's health bar.
     */
    public HealthActor()
    {
        HP = 10;
        hpBar = new StatBar(HP, HP, this, 300, 20, 60, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);

        image = new GreenfootImage(1,1);
        setImage(image);

        added = false;
    }

    /**
     * Adds the bar to the world, and updates it every act.
     */
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
