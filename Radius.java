
import greenfoot.*;
/**
 * A translucent grey circle that is centered on and follows the user. Represents the range in which the user can build towers.
 * 
 * @author Thomas Yang, Angus Feng, Leo Jia
 * @version June 2022
 */
public class Radius extends Actor 
{
    private GreenfootImage image;
    private boolean foundHost;
    private Player player;
    
    /**
     * Initializes and resizes the image, then sets the transparancy to 50.
     */
    public Radius()
    {
        image = new GreenfootImage("radius.png");
        image.scale(200,200);
        setImage(image);
        image.setTransparency(50);
    }

    /**
     * Makes sure that the Radius is following the user, else follows user. If the radius is clicked on and the user has enough resources, build a tower.
     */
    public void act()
    {

        if (Greenfoot.mouseClicked(this) && GameWorld.getWood()>=5 && GameWorld.getMetal() >=2 && GameWorld.getStone() >=4 && GameWorld.getWater() == true && GameWorld.getFactory() == false){
            getWorld().addObject(new WaterTower(), Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
            
            
        }
        else if (Greenfoot.mouseClicked(this) && GameWorld.getWood()>=5 && GameWorld.getMetal() >=2 && GameWorld.getStone() >=4 && GameWorld.getWater() == false && GameWorld.getFactory() == true){
            getWorld().addObject(new FactoryTower(), Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
            
        
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
