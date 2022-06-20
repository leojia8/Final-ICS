import greenfoot.*;


/**
 * A red circle that grows bigger every act, and faster over time, until it reaches a certain size, at which point it is removed from the world. 
 * Acts as a visual indicator of a stun attack, by BossCat. 
 * 
 * @author Thomas Yang
 * @version June 2022
 */
public class BossAttack extends Actor
{

    private int num;
    private int counter;
    private GreenfootImage image;

    /**
     * Sets it's image to the red stun circle, and initializes some variables
     */
    public BossAttack()
    {

        image = new GreenfootImage("stun.png");
        counter = 0;
        num = 0;
        image.scale(120,120);
        setImage(image);
    }

    /**
     * Causes the BossAttack circle to grow bigger by increasing amounts over time, then remove itself after 120 acts
     */
    public void act()
    {
        num+= 20;
        if(num % 10 == 0)
        {
            image.scale(120 + num, 120 + num);
            setImage(image);
        }
        counter++;
        if(counter >= 120)
        {
            getWorld().removeObject(this);
        }
    }
}
