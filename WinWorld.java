/**
 * Write a description of class WinWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import greenfoot.*;
public class WinWorld extends World
{
    private GreenfootImage image;
    
    /**
     * Constructor for objects of class WinWorld
     */
    public WinWorld()
    {
        super(1200, 800, 1);
        image = new GreenfootImage("victory.jpg");
        image.scale(1200,800);
        setBackground(image);
        addObject(new Victory(), 600, 100);
    }
    
    

    
    
  
}
