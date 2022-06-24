import greenfoot.*;


/**
 * A red circle that grows bigger every act, and faster over time, until it reaches a certain size, at which point it is removed from the world. 
 * Acts as a visual indicator of a stun attack, by BossCat. 
 * 
 * @author Thomas Yang, Angus Feng, Leo Jia
 * @version June 2022
 */
public class BossAttack extends Actor
{

    private int num;
    private int counter;
    private GreenfootImage image;
    private GreenfootSound sound;
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
        sound = new GreenfootSound("bossattack.wav");
        sound.setVolume(75);
        sound.play();
    }

    /**
     * Causes the BossAttack circle to grow bigger by increasing amounts over time, then remove itself after 120 acts
     */
    public void act()
    {
        num+= 20;
        if(num % 10 == 0)
        {
            image.scale(120 + num + 10, 120 + num + 10);
            setImage(image);
        }
        counter++;
        if(counter >= 60)
        {
            getWorld().removeObject(this);
        }
    }
}
