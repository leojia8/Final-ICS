
import greenfoot.*;
/**
 * Subclass of tower - creates "cat food", a secondary resource used to upgrade towers
 * 
 * @author Thomas Yang
 * @version June 2022
 */
public class FactoryTower extends Tower
{
    private int counter;
    private static GifImage master = new GifImage("DogFoodTower.gif");
    private GifImage gifImage;
    private int x;
    private int y;
    private boolean addedToWorld;

    /**
     * Constructor for objects of class FactoryTower
     */
    public FactoryTower()
    {
        gifImage = new GifImage(master);
        gifImage.resizeImages(100, 120);
        counter = 0;
        addedToWorld = false;
        type = 2;
    }

    public void act()
    {
        if(addedToWorld == false)
        {

            Square s = (Square)getOneIntersectingObject(Square.class);
            Tower t = (Tower)getOneIntersectingObject(Tower.class);
            if(s != null || t != null)
            {
                getWorld().removeObject(this);
            }
            else
            {
                x = getX();
                y = getY();
                addedToWorld = true;
                GameWorld.takeWood();
                GameWorld.takeMetal();
                GameWorld.takeMetal();
                GameWorld.takeMetal();
                GameWorld.takeStone();
                GameWorld.takeStone();
               
                
                
                

            }

        }
        else
        {
            setImage( gifImage.getCurrentImage() );
            counter--;
            if(counter <= 0)
            {
                GameWorld.addCatFood();

                counter = 1000;
            }
        }

    }

}
