import greenfoot.*;

/**
 * A button used to place factory towers
 * 
 * @author Thomas Yang, Angus Feng
 * @version June 2022
 */
public class FactoryTowerButton extends TowerButton
{
    
    
    private GreenfootImage[] images = new GreenfootImage[2];
    private boolean toggleWaterGun;
    private boolean toggle;
    private boolean clickTwice;
    GameWorld w;
    
    /**
     * Initializes and scales regular and dark factory buttons - dark gets used when hovered over by user.
     */
    public FactoryTowerButton()
    {
        super();
        type = 0;
        images[0] = new GreenfootImage("factoryButton.png"); 
        images[1] = new GreenfootImage("darkFactory.png"); 
        
        //image = new GreenfootImage("darkButton.png");
        images[0].scale(100,100);
        images[1].scale(100,100);
        setImage(images[0]);
        //setImage(image);
        
    }
    
    /**
     * Checks whether or not the button is being hovered over or was clicked on.
     */
    public void act(){
        onHover();
        onClick();
    }
    
    /**
     * If clicked, toggle so that the world knows you are placing factories.
     */
    public void onClick()
    {
        if(Greenfoot.mouseClicked(this))
        {
            w.toggleFactory();
        }
    }
    
    /**
     * If hovered, change image to darker image as visual effect.
     */
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
    
    
    
    
    
    
    
    
    

    
}
