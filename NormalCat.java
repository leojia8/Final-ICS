import greenfoot.*;

/**
 * Subclass of cat - basic fodder, with no special traits.
 * 
 * @author Thomas Yang, Leo Jia, Angus Feng
 * @version June 2022
 */
public class NormalCat extends Cat 
{
    // instance variables - replace the example below with your own
    private static GifImage master = new GifImage("flippednormalgif.gif");
    private GifImage gifImage;
   
    
    /**
     * Sets Hp and type variables, initializes an HP bar, and sets the GIF image.
     */
    public NormalCat()
    {
        noPath = false;
        HP = 25;
        hpBar = new StatBar(HP, HP, this, 30, 5, 60, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);
        counter = 20;
        rotation = 90;
        gifImage = new GifImage(master);
        gifImage.resizeImages(100, 87);
        type = 4;
    }

    /**
     * Updates the HP bar to track damage done and moves the normal cat along the path at a set speed.
     * 
     * <p> Uses the superclass act method to check if the cat needs to be removed from the world.
     */
    public void act()
    {
        
        setImage( gifImage.getCurrentImage() );
        hpBar.update(HP);
        
        if(rotation == 90)
        {
            setLocation(getX() + 2, getY());
            if(counter <= 0)
            {
                Square s = (Square)getOneObjectAtOffset(80, 0, Square.class);
                if (s == null)
                {
                    noPath = true;
                    
                }
                counter = 40;
            }
        }
        else if(rotation == 0)
        {
            setLocation(getX(), getY() - 2);
            if(counter <= 0)
            {
                Square s = (Square)getOneObjectAtOffset(0, -80, Square.class);
                if(s == null)
                {
                    noPath = true;
                    
                }
                counter = 40;
            }
        }
        else if(rotation == 180)
        {
            setLocation(getX(), getY() + 2);
            if(counter <= 0)
            {
                Square s = (Square)getOneObjectAtOffset(0, 80, Square.class);
                if(s == null)
                {
                    noPath = true;
                    
                }
                counter = 40;
            }
        }
        else if(rotation == 270)
        {
            setLocation(getX() - 2, getY());
            if(counter <= 0)
            {
                Square s = (Square)getOneObjectAtOffset(-80, 0, Square.class);

                if(s == null)
                {
                    noPath = true;
                    
                }
                counter = 40;
            }
        }
        counter--;

        if(noPath)
        {
            
            Square s = (Square)getOneObjectAtOffset(-80, 0, Square.class);
            Square s2 = (Square)getOneObjectAtOffset(0, 80, Square.class);
            Square s3 = (Square)getOneObjectAtOffset(0, -80, Square.class);
            Square s4 = (Square)getOneObjectAtOffset(80, 0, Square.class);

            if(s != null && rotation != 90 && noPath == true)
            {
                
                rotation = 270;
                noPath = false;
            }
            
            
            if(s3 != null && rotation != 180 && noPath == true)
            {
                rotation = 0;
                noPath = false;
            }
            if(s2 != null && rotation != 0 && noPath == true)
            {
                rotation = 180;
                noPath = false;
                
            }
            
            if(s4 != null && rotation != 270 && noPath == true)
            {
                rotation = 90;
                noPath = false;
            }
            
            
            if(noPath)
            {
                this.setLocation(2000, 2000);
                GameWorld.removeHealth();
                getWorld().addObject(new Red(), 400, 400);
            }
            
        }
        super.act();
    }
}
