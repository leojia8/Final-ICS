import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The abstract superclass for cats. Contains all necessary methods for it's subclasses (aside from BossCat, which has some extra functionality). 
 * 
 * <p> Has an empty constructor because each cat subclass sets its own health, speed, type, etc.
 * 
 * <p>All cats have:
 *  <p>- Health (and a corresponding health bar)
 *  <p>- Speed
 *  <p>- Sprites
 * 
 * @author Thomas Yang, Angus Feng
 * @version June 2022
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
    protected boolean addedHealth;
    public Cat ()
    {
        addedHealth = false;
    }

    /**
     * Checks if the cat has been hit by a projectile from a tower and removes the cat if it is off the world or has no more HP.
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
        if(addedHealth == false)
        {
            if(GameWorld.getRound() >= 7)
            {
                HP = HP * 2;
                addedHealth = true;
            }
        }
    }

    /**
     * A method that allows the cat to move along the path by using a rotation variable to see which way the cat is going.
     * 
     * <p>After a set counter, the cat will start to check if there are any more path squares in the direction it is moving. If there aren't any, 
     * it will check around itself for any available path squares to move onto. If it does not find any, that means that the cat is at 
     * the end of the world so it will remove itself and damage the player.
     * 
     * @param speed     Speed of the cat moving along the path - allows different cats to move at different speeds.
     */
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
                if(type == 1)
                {
                    Greenfoot.setWorld(new LoseWorld());
                }
                getWorld().addObject(new Red(), 400, 400);
            }

        }

        
    }
    
    /**
     * Adds an hp bar object to follow every cat added to the world
     * 
     * @param w     The world that the cat and statbar are added to.
     */
    public void addedToWorld(World w){
        w.addObject(hpBar, getX(), getY() + 20);
    }

    /**
     * Method that checks if the cat has been hit by a projectile from the towers - If it has, remove the bullet and damage the cat
     * 
     * <p> If the cat is a BossCat, it will take triple the damage
     */
    public void gettingHit(){
        Bullet bullet = (Bullet)getOneIntersectingObject(Bullet.class);
        if (bullet != null){
            int dam = bullet.getDamage();
            getWorld().removeObject(bullet);
            
            if(type == 1)
            {

                HP = HP - (dam * 3);
            }
            else
            {
                HP = HP - (dam);
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
            health = health - 70;
            getWorld().addObject(new Explosion(), getX(), getY() - 21);
        }
    }

    /**
     * Method to find the type of the cat.
     */
    public int getType()
    {
        return type;
    }
}
