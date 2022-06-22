
import greenfoot.*;
/**
 * Write a description of class BuildRadius here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Radius extends Actor 
{
    private GreenfootImage image;
    private boolean foundHost;
    private Player player;
    /**
     * Constructor for objects of class BuildRadius
     */
    public Radius()
    {
        image = new GreenfootImage("radius.png");
        image.scale(200,200);
        setImage(image);
        image.setTransparency(50);
    }

    public void act()
    {

        if (Greenfoot.mouseClicked(this) && GameWorld.getWood()>=5 && GameWorld.getMetal() >=2 && GameWorld.getStone() >=4){
            getWorld().addObject(new WaterTower(), Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
            
            
        }

        if(!foundHost)
        {
            player = (Player)getOneIntersectingObject(Player.class);
            foundHost = true;
        }
        else
        {
            setLocation(player.getX(), player.getY());
        }

    }

}
