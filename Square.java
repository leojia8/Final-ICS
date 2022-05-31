import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Checks if there are any actor on a certain piece of land
 * 
 * @author Jessie Liu
 * @version April 2022
 * @Credit Jordan Cohen
 */
public class Square 
{
    public static final Color TRANSPARENT_RED = new Color (255, 0, 0, 128);
    
    
    private GreenfootImage image;
    
    private boolean visible;
    private int height, width;
    
    public Square (int width, int height)
    {
        this.height =height;
        this.width = width;
        // set this to true to see the Spawners - might help with understanding of how this works:
        visible = true;
        image = new GreenfootImage (width, height);
        if(visible){
            image.setColor(TRANSPARENT_RED);
            image.fillRect(0, 0, width-1, height - 1);
        }
        setImage(image);
    }
    
    public boolean isTouchingCharacter () {
        return this.isTouching(Plants.class)||this.isTouching(Zombies.class);
    }
}
