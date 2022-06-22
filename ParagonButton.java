import greenfoot.*;
import java.util.List;
/**
 * This class is the UpgradeButton class. A rectangle button is made when this class is called.
 * @author Jessie Liu, Thomas Yang
 * @version April 2022
 * @Credits: Alex Li and Jordan Cohen
 */
public class ParagonButton extends Actor
{
    private WaterTower target;
    private String text;
    private GreenfootImage image;

    private GreenfootImage touchingImage;

    private String mouseTouchingText;
    private String worldSwitch;
    private int textSize;
    private Color buttonColor;
    private Color touchColor;
    private int userValue;
    private double userDoubleValue;
    private boolean special;
    private boolean pressed;

    /*
     * @param String theText     the text wanted to display on this button
     * @param int textSize       the size of the text
     * @param Color buttonColor  the colour of the words on the button when not pressed/touched, it also becomes the background color when button
     * is pressed
     * @param Color touchColour  the colour of the words on the button when pressed/touched, it also becomes the background color when the button
     * is not pressed
     */
    public ParagonButton(WaterTower owner, String theText, int textSize, Color buttonColor, Color touchColor)
    {
        text = theText;
        this.textSize=textSize;
        this.buttonColor=buttonColor;
        this.touchColor=touchColor;
        special=false;

        //Draws the button
        drawButton();
        setImage (image);
        this.target = (WaterTower)owner;
    }
    
    
    
    
    
    
    public void act()
    {
        //if it is a special button that holds a value 

        if (Greenfoot.mouseClicked(this)){

            
            GameWorld.stopUpgrading();
            target.upgradeParagon();
            GameWorld.takeCatFood30();
            getWorld().removeObjects(getNeighbours(3000, true, UpgradeButton.class));
            getWorld().removeObjects(getNeighbours(3000, true, CancelButton.class));
            
            getWorld().removeObject(this);
        }

        else{
            // if it is a normal button
            if (Greenfoot.mouseMoved(this))
            {
                setImage(touchingImage);
            }
            if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
            {
                setImage(image);
            }
        }

    }

    //Draws the button image and the button touching image. 
    private void drawButton()
    {

        GreenfootImage tempImage = new GreenfootImage (text, textSize, buttonColor, touchColor);

        //single boarder
        image = new GreenfootImage (tempImage.getWidth() + 8, tempImage.getHeight() + 8);
        image.setColor (buttonColor);
        image.fill();
        image.drawImage (tempImage, 4, 4);

        //double boarder
        image.setColor(touchColor);
        image.drawRect (0,0,tempImage.getWidth() + 7, tempImage.getHeight() + 7);

        //single boarder when mouse touching
        tempImage = new GreenfootImage (text, textSize, touchColor, buttonColor);
        touchingImage = new GreenfootImage(tempImage.getWidth() + 8, tempImage.getHeight() + 8);
        touchingImage.setColor (touchColor);
        touchingImage.fill();
        touchingImage.drawImage (tempImage, 4, 4);

        //double boarder when mouse touching
        touchingImage.setColor(buttonColor);
        touchingImage.drawRect (0,0,tempImage.getWidth() + 7, tempImage.getHeight() + 7);

    }

    /*
     *@return the integer value the button holds 
     */
    public int getValue(){
        return userValue;
    }

    /*
     *@return the double value the button holds 
     */
    public double getDoubleValue(){
        return userDoubleValue;
    }

    /*
     *@return a boolean value of whether or not the button is pressed 
     */
    public boolean isPressed(){
        return pressed;
    }

    /*
     *Change the button to unpressed
     */
    public void unPress(){
        pressed=false;
        this.setImage(image);
    }
}

