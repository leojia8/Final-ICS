import greenfoot.*;

/**
 * Write a description of class WaterTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaterTowerButton extends TowerButton
{
    
    /**
     * Constructor for objects of class WaterTower
     */
    private GreenfootImage[] images = new GreenfootImage[2];
    private boolean toggleWaterGun;
    private boolean toggle;
    private boolean clickTwice;
    public WaterTowerButton()
    {
        super();
        type = 0;
        images[0] = new GreenfootImage("waterGunButton.png"); 
        images[1] = new GreenfootImage("darkButton.png"); 
        
        //image = new GreenfootImage("darkButton.png");
        images[0].scale(100,100);
        images[1].scale(100,100);
        setImage(images[0]);
        //setImage(image);
        
    }
    public void act(){
        onHover();
        onClick();
    }
    public void onClick()
    {
        if(Greenfoot.mouseClicked(this))
        {
            setImage(images[1]);
            toggle = true;
        }
    }
    public void onHover()
    {
        if (Greenfoot.mouseMoved(this))
        {
            setImage(images[1]); //Dark
        }
        else if(Greenfoot.mouseMoved(null) && toggle!= true)
        {
            setImage(images[0]); //Light
        }

    }
    public boolean getToggle(){
        return toggleWaterGun;
    }
    
    
    
    
    
    
    
    
    

    
}
