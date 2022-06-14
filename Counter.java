import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Counter extends Actor
{
    /**
     * The Counter Bar: The Blue Bar in the top middle of the screen
     *
     */
    GameWorld w;
    public Counter(){
        setImage(new GreenfootImage("Stone: "+ w.getStone() + "     Wood: " + w.getWood() + "     Metal: " + w.getMetal() ,40, Color.BLACK, new Color(0, 176, 225)));
    }
    public void act()
    {
        //Updates the Counter Bar
        setImage(new GreenfootImage("Stone: "+ w.getStone() + "     Wood: " + w.getWood() + "     Metal: " + w.getMetal() ,40, Color.BLACK, new Color(0, 176, 225)));
    }
}