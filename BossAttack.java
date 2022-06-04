import greenfoot.*;


/**
 * Write a description of class BossAttack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossAttack extends Actor
{

    private int num;
    private int counter;
    private GreenfootImage image;

    /**
     * Constructor for objects of class BossAttack
     */
    public BossAttack()
    {

        image = new GreenfootImage("stun.png");
        counter = 0;
        num = 0;
        image.scale(120,120);
        setImage(image);
    }

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
