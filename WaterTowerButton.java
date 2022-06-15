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
    public WaterTowerButton()
    {
        super();
        type = 0;
        
        image = new GreenfootImage("towerbutton.png");
        image.scale(100,100);
        setImage(image);
        
    }
    public void act(){
        onClick();
    }
    public void onClick()
    {
        if(Greenfoot.mouseClicked(this))
        {
            getWorld().addObject(new Gun(), 600, 600);
        }
    }
    
    
    
    
    
    
    
    
    

    
}
