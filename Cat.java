import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Cat extends SuperSmoothMover
{
    protected int health;
    protected int speed;
    protected int damage;
    protected int rotation = 90;
    protected int counter = 40;
    protected boolean noPath;
    protected StatBar hpBar;
    protected int HP;
    protected int type;
    public Cat ()
    {

    }

    /**
     * Act - do whatever the Cat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act()
    {
        //hpBar.update(HP);
        gettingHit();
        if(getWorld() != null)
        {
            if (getY() <= -10 || getY() >= 810 )
            {
                getWorld().removeObject(this);

            } 
            else if (getX() >= 1210 || getX() <= -10)
            {
                getWorld().removeObject(this);

            }
            if (HP <= 0)
            {
                getWorld().removeObject(this);
            }
        }
    }

    protected void moveAlongPath(int speed){
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
                counter = 80;
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
                counter = 80;
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
                counter = 80;
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
                counter = 80;
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
    public void addedToWorld(World w){
        w.addObject(hpBar, getX(), getY() + 20);
    }

    public void gettingHit(){
        Bullet bullet = (Bullet)getOneIntersectingObject(Bullet.class);
        if (bullet != null){
            int dam = bullet.getDamage();
            getWorld().removeObject(bullet);

            if(type == 1)
            {

                HP = HP - (dam * 3);
            }
        }
    }

    public void damage(int damage)
    {
        health = health - damage;
    }

    public void hit()
    {
        if(type != 1)
        {
            getWorld().addObject(new Explosion(), getX(), getY() - 20);
            getWorld().removeObject(this);
        }
        else 
        {
            health = health - 55;
            getWorld().addObject(new Explosion(), getX(), getY() - 21);
        }
    }

    public int getType()
    {
        return type;
    }
}
