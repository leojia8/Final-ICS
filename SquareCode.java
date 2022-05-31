import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the world where the actual simulation plays (not finished!)
 * 
 * @author Jessie 
 * @version April 2022
 */
public class SquareCode
{
    private int[] row = new int[30];
    private int[] column= new int[20];
    private Square[][] spawners=new Square[30][20];
    
    private static final int RECTANGLE_WIDTH=40;
    private static final int RECTANGLE_HEIGHT=40;
    private static final int RECTANGLE_HALF_WIDTH=RECTANGLE_WIDTH/2;
    private static final int RECTANGLE_HALF_HEIGHT=RECTANGLE_HEIGHT/2;
    private static final int YOFFSET=0;
    private static final int XOFFSET=0;
   
    /**
     * Constructor for the GameWorld. It uses the user inputs to construct the world.
     * @param int startSunlight  the number of sunlight the user decides to begin with
     * @param int numSunflowers  the number of sun flowers the user wants to begin with
     * @param int numWaves       the number of waves of zombies the user wants
     * @param int speedBoost     the number of speed booster the user wants for zombies
     * @param int soil           the soil quality the user decides for the game
     */
    public SquareCode()
    {    
        // Create a new world with 1280x800 cells with a cell size of 1x1 pixels.
       
        
        
        
        // set the location (x and y coordinates) of locations where the plants will be spawned/grown
        for (int i=0;i<20; i++){
            column[i]=YOFFSET+RECTANGLE_HALF_HEIGHT+(i*RECTANGLE_HEIGHT);
        }
        for (int i=0;i<30; i++){
            row[i]=XOFFSET+RECTANGLE_HALF_WIDTH+(i*RECTANGLE_WIDTH);
        }
        //create the plant spawners at each location
        for(int i=0;i<30;i++){
            for (int j=0;j<20;j++){
                spawners[i][j] = new PlantSpawner(RECTANGLE_WIDTH,RECTANGLE_HEIGHT);
                addObject(spawners[i][j],row[i],column[j]);
            }
        }
    }

    

    
    /**
     * a method that checks if the locations for plants to spawn/grow are full
     * @return a boolean value of whether or not if the world is full
     */
    public boolean isFull(){
        for (int i=0; i<9;i++){
            for (int j=0; j<5;j++){
                if(!spawners[i][j].isTouchingCharacter()){
                    return false;
                }
            }
        }
        return true;
    }

    
}
