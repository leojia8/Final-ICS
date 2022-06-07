
import greenfoot.*;
/**
 * Here we will need to implement many things including resource spawning, cat spawning, and how the lane is going to orient. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld  extends World
{
    // instance variables - replace the example below with your own
    private int x;
    private int spawnNumber;
    int path2[][] = {{1,1,1,0,0,1,1,1,1,1,0,0},
                    {0,0,1,0,1,1,0,0,0,1,0,0},
                    {0,0,1,0,1,0,0,1,1,1,0,0},
                    {0,0,1,0,1,1,0,1,0,0,0,0},
                    {0,1,0,0,0,1,0,1,0,1,1,1},
                    {0,1,1,1,1,1,0,1,0,1,0,1},
                    {0,0,0,0,0,0,0,1,0,1,0,1},
                    {0,0,0,0,0,0,0,1,1,1,0,1}};
                    
                    
    int path[][] = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
                    {0,1,0,0,0,0,0,0,0,0,0,1,0,0,0},
                    {0,1,1,1,1,1,1,1,1,0,0,1,1,1,0},
                    {0,0,0,0,0,0,0,0,1,0,0,0,0,1,0},
                    {0,0,1,1,1,0,0,0,1,0,0,1,1,1,0},
                    {0,0,1,0,1,0,0,0,1,0,0,1,0,0,0},
                    {1,1,1,0,1,0,0,0,1,0,0,1,1,1,1},
                    {0,0,0,0,1,0,0,0,1,0,0,0,0,0,0},
                    {0,0,0,0,1,1,1,1,1,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
    private static int numStone;
    private static int numWood;
    private static int numMetal;
    /**
     * Constructor for objects of class GameWorld
     */
    public GameWorld()
    {
        super(1200, 800, 1);
        //addObject(new Player(), 400, 400);
        addObject(new NormalCat(), 400, 500);
        addObject(new EggCat(), 400, 600);
        addObject(new TallCat(), 400, 700);
        levelConstructor();
        numStone = 5;
        numWood = 5;
        numMetal = 5;
        
    }

    
    
    public void act()
    {
        showText("EHEHE" + numStone + "S" + numWood + "" + numMetal,600 ,50 );
        spawnResources();
    }
    
    
    
    //method that spawns resources 
    
    private void spawnResources()
    {
        spawnNumber = Greenfoot.getRandomNumber(1000);
        if(spawnNumber == 500)
        {
            int type = Greenfoot.getRandomNumber(3);
            
            if(type == 0)
            {
                this.addObject(new Rock(), Greenfoot.getRandomNumber(1100), Greenfoot.getRandomNumber(700));
            }
            else if(type == 1)
            {
                this.addObject(new Tree(), Greenfoot.getRandomNumber(1100), Greenfoot.getRandomNumber(700));
            }
            else if(type == 2)
            {
                this.addObject(new Ore(), Greenfoot.getRandomNumber(1100), Greenfoot.getRandomNumber(700));
            }
        }
    }
    
    public void levelConstructor(){
        int spacing = 80;
        for (int i = 0; i<10; i++){
            for (int j = 0; j<15; j++){
                if (path[i][j] == 1){
                    addObject(new Square(), 40 + spacing * j, 40 + spacing * i);
                }
                
            }
        }
    }
    //Borrowed from Mr. Cohen. Method makes the world get the distance between two objects 
    public static float getDistance (Actor a, Actor b)
    {
        double distance;
        double xLength = a.getX() - b.getX();
        double yLength = a.getY() - b.getY();
        distance = Math.sqrt(Math.pow(xLength, 2) + Math.pow(yLength, 2));
        return (float)distance;

    }
    
    public static void addMetal()
    {
        numMetal++;
    }
    public static void addWood()
    {
        numWood++;
    }
    public static void addStone()
    {
        numStone++;
    }
    public static void takeMetal()
    {
        numMetal--;
    }
    public static int getMetal()
    {
        return numMetal;
    }
    public static void takeWood()
    {
        numWood--;
    }
    public static int getWood()
    {
        return numWood;
    }
    public static void takeStone()
    {
        numStone--;
    }
    public static int getStone()
    {
        return numStone;
    }
}
