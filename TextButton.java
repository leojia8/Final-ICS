import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * This class is the Button class. A rectangle button is made when this class is called.
 * @author Jessie Liu, Thomas Yang
 * @version April 2022
 * @Credits: Alex Li and Jordan Cohen
 */

public class TextButton extends Actor
{

    private GreenfootImage image;
    private GreenfootImage touchingImage;
    private String text;
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
    public TextButton(String theText, int textSize, Color buttonColor, Color touchColor)
    {
        text = theText;
        this.textSize=textSize;
        this.buttonColor=buttonColor;
        this.touchColor=touchColor;
        special=false;
        
        //Draws the button
        drawButton();
        setImage (image);

    }
    
    /*
     * @param String theText     the text wanted to display on this button
     * @param int textSize       the size of the text
     * @param Color buttonColor  the colour of the words on the button when not pressed/touched, it also becomes the background color when button
     * is pressed
     * @param Color touchColour  the colour of the words on the button when pressed/touched, it also becomes the background color when the button
     * is not pressed
     * @param int value          the integer value the button holds
     */
    public TextButton(String theText, int textSize, Color buttonColor, Color touchColor, int value)
    {
        text = theText;
        this.textSize=textSize;
        this.buttonColor=buttonColor;
        this.touchColor=touchColor;
        userValue=value;
        special=true;
        pressed=false;
        
        //Draws the button
        drawButton();
        setImage (image);

    }
    
    /*
     * @param String theText     the text wanted to display on this button
     * @param int textSize       the size of the text
     * @param Color buttonColor  the colour of the words on the button when not pressed/touched, it also becomes the background color when button
     * is pressed
     * @param Color touchColour  the colour of the words on the button when pressed/touched, it also becomes the background color when the button
     * is not pressed
     * @param double value          the double value the button holds
     */
    public TextButton(String theText, int textSize, Color buttonColor, Color touchColor, double value)
    {
        text = theText;
        this.textSize=textSize;
        this.buttonColor=buttonColor;
        this.touchColor=touchColor;
        userDoubleValue=value;
        special=true;
        pressed=false;
        
        //Draws the button
        drawButton();
        setImage(image);

    }

    public void act()
    {
        //if it is a special button that holds a value 
        if (special==true){
            if (Greenfoot.mouseClicked(this)){
                //turning on and off the button
                if (pressed==false){
                    setImage(touchingImage);
                    pressed=true;
                }else{
                    pressed=false;
                    setImage(image);
                }
            }
            
            //Only allows the special feature when the button is not pressed
            if(pressed==false){
                /*
                 * If the mouse hovers above the button
                 * then the button will change it's image.
                 * 
                 * This code was borrowed from Danpost
                 */
                if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
                {
                    setImage(image);
                }
                if (Greenfoot.mouseMoved(this))
                {
                    setImage(touchingImage);
                }
            }
            
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
