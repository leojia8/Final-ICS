import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gun extends Tower
{
    /**
     * Act - do whatever the Gun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //private static GifImage master = new GifImage("WaterTower.gif");
    //private GifImage gifImage;
    private GreenfootImage image = new GreenfootImage("water.png"); ;
    private int radius = 100;
    private int fireRate = 0;
    public Gun(){

        //gifImage = new GifImage(master);
        //gifImage.resizeImages(100, 100);
        setImage(image);       
        image.scale(100,100);
        image.rotate(270);
    }

    public void act()
    {
         
        if(stun)
        {
            stunTimer--;
            if(stunTimer <= 0)
            {
                stun = false;
            }
        }
        else
        {

            //if (checked() != true){
            enemyDetector();
            //}
        }
    }

    public void enemyDetector(){
        fireRate++;
        List<Cat> enemies = getObjectsInRange(radius, Cat.class);
        for (Cat fat: enemies){
            if (fireRate >9){
                fireRate = 0;
                Bullet bullet = new Bullet();
                getWorld().addObject(bullet, getX(), getY());
                bullet.turnTowards(fat.getX(),fat.getY());
                turnTowards(fat.getX(), fat.getY());
            }
            
        }

    }
    /**
     * public void addedToWorld(World w){
    if (checked() != true){
    getWorld().removeObject(this);
    }
    else{
    setImage(image);       
    image.scale(100,100);
    }

    }
    private boolean checked(){
    Square square = (Square)getOneIntersectingObject(Square.class);
    Player player = (Player)getOneIntersectingObject(Player.class);
    Resources r = (Resources)getOneIntersectingObject(Resources.class);
    if (square != null || player != null || r != null){
    return false;
    }
    return true;
    }
     */

}
