import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Counter extends Actor
{
    /**
     * The Counter Bar: The Blue Bar in the top middle of the screen
     *
     */
    int score;
    int money;
    int time;
    public Counter(){
        setImage(new GreenfootImage("Score: "+ score + "     Cash: " + money + "     Phase: " + ((time/1200)+1) + "     Time: " + (time/60) ,40, Color.BLACK, new Color(0, 176, 225)));
    }
    public void act()
    {
        //Updates the Counter Bar
         time++;
         setImage(new GreenfootImage("Score: "+ score + "     Cash: " + money + "     Phase: " + (time/1200+1) + "     Time: " + (time/60) ,40, Color.BLACK, new Color(0, 176, 225)));
    }
}