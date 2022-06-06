import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Checks if there are any actor on a certain piece of land
 * 
 * @author Jessie Liu
 * @version April 2022
 * @Credit Jordan Cohen
 */
public class Square extends Actor
{
    public static final Color TRANSPARENT_RED = new Color (255, 0, 0, 128);
    
    
    private GreenfootImage image;
    
    private boolean visible;
    private int height = 80;
    private int width = 80;
    
    public Square ()
    {
        
        // set this to true to see the Spawners - might help with understanding of how this works:
        visible = true;
        image = new GreenfootImage (width, height);
        if(visible){
            image.setColor(TRANSPARENT_RED);
            image.fillRect(0, 0, width-1, height - 1);
        }
        setImage(image);
    }
    
    
}
