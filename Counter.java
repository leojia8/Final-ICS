import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Counter Bar: The White Bar in the top middle of the screen which displays the amount of resources the player has.
 * 
 * @author Thomas Yang, Angus Feng
 * @version June 2022
 */
public class Counter extends Actor
{
    
    GameWorld w;
    /**
     * Sets the image to text displaying the number of resources.
     */
    public Counter(){
        setImage(new GreenfootImage("Stone: "+ w.getStone() + "     Wood: " + w.getWood() + "     Metal: " + w.getMetal() + "        Cat Food: " + w.getCatFood() ,40, Color.BLACK, new Color(255, 255, 255)));
        //setImage(new GreenfootImage("Stone: "+ w.getStone() + "     Wood: " + w.getWood() + "     Metal: " + w.getMetal() + "        Cat Food: " + w.getCatFood() ,40, Color.BLACK, new Color(0, 176, 225)));
    }
    /**
     * Updates the counter bar.
     */
    public void act()
    {
        setImage(new GreenfootImage("Stone: "+ w.getStone() + "     Wood: " + w.getWood() + "     Metal: " + w.getMetal() + "        Cat Food: " + w.getCatFood(),40, Color.BLACK, new Color(255, 255, 255)));
    }
}