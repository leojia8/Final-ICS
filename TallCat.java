import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Subclass of cat - faster, weaker enemy.
 * 
 * @author Thomas Yang, Leo Jia, Angus Feng
 * @version June 2022
 */
public class TallCat extends Cat
{
    private static GifImage master = new GifImage("tallCatAdjusted.gif");
    private GifImage gifImage;
    
    /**
     * Sets Hp and type variables, initializes an HP bar, and sets the GIF image.
     */
    public TallCat()
    {
        HP = 20;
        hpBar = new StatBar(HP, HP, this, 45, 5, 135, Color.RED, new Color(255, 204, 203), false, Color.WHITE, 1);

        gifImage = new GifImage(master);
        gifImage.resizeImages(141, 264);
        type = 2;
        counter = 10;
    }

    /**
     * Updates the Hp bar to track damage done and moves the tall cat along the path at a set speed.
     * 
     * <p> Uses the superclass act method to check if the cat needs to be removed from the world.
     */
    public void act()
    {
        // Add your action code here.
        hpBar.update(HP);
        setImage( gifImage.getCurrentImage() );
        moveAlongPathCat(4);
        super.act();

    }
    
    private void moveAlongPathCat(int speed){
        if(rotation == 90)
        {
            setLocation(getX() + speed, getY());
            if(counter <= 0)
            {
                Square s = (Square)getOneObjectAtOffset(80, 0, Square.class);
                if (s == null)
                {
                    noPath = true;

                }
                counter = 20;
            }
        }
        else if(rotation == 0)
        {
            setLocation(getX(), getY() - speed);
            if(counter <= 0)
            {
                Square s = (Square)getOneObjectAtOffset(0, -80, Square.class);
                if(s == null)
                {
                    noPath = true;

                }
                counter = 20;
            }
        }
        else if(rotation == 180)
        {
            setLocation(getX(), getY() + speed);
            if(counter <= 0)
            {
                Square s = (Square)getOneObjectAtOffset(0, 80, Square.class);
                if(s == null)
                {
                    noPath = true;

                }
                counter = 20;
            }
        }
        else if(rotation == 270)
        {
            setLocation(getX() - speed, getY());
            if(counter <= 0)
            {
                Square s = (Square)getOneObjectAtOffset(-80, 0, Square.class);

                if(s == null)
                {
                    noPath = true;

                }
                counter = 20;
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
        
        
        
       
    }
}
