
import greenfoot.*;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Here we will need to implement many things including resource spawning, cat spawning, and how the lane is going to orient. 
 * 
 * Current bugs !!
 * the boss for some reason starts moving in the opposite direction
 * the player needs to be smaller (idk how to rescale a gif)  
 * 
 * 
 * New features !!
 * add story 
 * add a tutorial reel
 * more towers (factory tower, slow tower)
 * tower select (when the tower is selected it changes hue? and thats how you know what you are placing)
 * more rounds
 * add better graphics
 * upgrade feature (UI pop up menu)
 * 
 * Balance changes !!
 * the resourses should have lower health (forces the players to move more)
 * resources should spawn more
 * boss is kinda too OP (but this is without upgrades and w/o other features)
 * 
 * 
 * Thomas Yang, Ivan Cai, Angus Feng, Leo Jia 
 * THURSDAY JUNE 16, 2022
 */
public class GameWorld  extends World
{
    // 
    private int x;
    private static int health;
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
    private static int numCatFood;
    private Counter counter = new Counter();
    private int spawnTimer;
    private int round;
    
    //Creating the enemy rounds in a linked list queue
    private Queue<Cat> r1 = new LinkedList<Cat>();
    private Queue<Cat> r2 = new LinkedList<Cat>();
    private Queue<Cat> r3 = new LinkedList<Cat>();
    private Queue<Cat> r4 = new LinkedList<Cat>();
    private Queue<Cat> r5 = new LinkedList<Cat>();
    private Queue<Cat> r6 = new LinkedList<Cat>();
    private Queue<Cat> r7 = new LinkedList<Cat>();
    private Queue<Cat> r8 = new LinkedList<Cat>();
    private Queue<Cat> r9 = new LinkedList<Cat>();
    private Queue<Cat> r10 = new LinkedList<Cat>();
    private int resourceChance;
    private WaterTowerButton w = new WaterTowerButton();
    private boolean upgrading;
    /**
     * Constructor for objects of class GameWorld
     * this adds the player into the game
     * This sets up the game with startug materials setting the round and health 
     */
    public GameWorld()
    {
        super(1200, 800, 1, false);
        addObject(new Player(), 500, 400);
        addObject(new EggCat(), 0, 600);
        upgrading = false;
        //addObject(new TallCat(), 400, 700);
        //addObject(new BossCat(), 400, 300);
        levelConstructor();
        numStone = 5;
        spawnTimer = 1500;
        numWood = 5;
        round = 1;
        health = 10;
        resourceChance = 100;
        numWood = 5;
        numMetal = 5;
        numCatFood = 0;
        addObject(counter, 600, 40);
        setPaintOrder(Counter.class, BossCat.class, Cat.class, StatBar.class, Red.class, Projectile.class,Player.class, TowerButton.class,BossRing.class, BossAttack.class, Explosion.class, Tower.class, WhiteOut.class, Square.class, Grey.class  );
        r1.add(new NormalCat());
        r1.add(new NormalCat());
        r1.add(new NormalCat());
        r1.add(new NormalCat());
        r1.add(new NormalCat());

        r2.add(new TallCat());
        r2.add(new NormalCat());
        r2.add(new NormalCat());
        r2.add(new TallCat());

        r3.add(new EggCat());
        r3.add(new NormalCat());
        r3.add(new NormalCat());
        r3.add(new NormalCat());
        r3.add(new NormalCat());
        r3.add(new NormalCat());
        r3.add(new NormalCat());
        r3.add(new NormalCat());
        r3.add(new NormalCat());
        r3.add(new NormalCat());
        r3.add(new NormalCat());
        r3.add(new TallCat());
        r3.add(new TallCat());

        r4.add(new EggCat());
        r4.add(new EggCat());
        r4.add(new EggCat());
        r4.add(new EggCat());
        r4.add(new TallCat());
        r4.add(new TallCat());
        r4.add(new TallCat());
        r4.add(new TallCat());

        r5.add(new NormalCat());
        r5.add(new NormalCat());
        r5.add(new NormalCat());
        r5.add(new NormalCat());
        r5.add(new NormalCat());
        r5.add(new NormalCat());
        r5.add(new NormalCat());
        r5.add(new NormalCat());
        r5.add(new NormalCat());
        r5.add(new NormalCat());
        r5.add(new NormalCat());
        r5.add(new NormalCat());
        r5.add(new NormalCat());

        r6.add(new TallCat());
        r6.add(new TallCat());
        r6.add(new TallCat());
        r6.add(new TallCat());
        r6.add(new TallCat());
        r6.add(new TallCat());
        r6.add(new TallCat());
        r6.add(new TallCat());

        r7.add(new NormalCat());
        r7.add(new EggCat());
        r7.add(new EggCat());
        r7.add(new EggCat());
        r7.add(new EggCat());
        r7.add(new NormalCat());
        r7.add(new NormalCat());
        r7.add(new NormalCat());
        r7.add(new NormalCat());
        r7.add(new NormalCat());
        r7.add(new NormalCat());
        r7.add(new NormalCat());
        r7.add(new NormalCat());
        r7.add(new NormalCat());
        r7.add(new NormalCat());

        r8.add(new NormalCat());
        r8.add(new NormalCat());
        r8.add(new NormalCat());
        r8.add(new NormalCat());
        r8.add(new NormalCat());
        r8.add(new NormalCat());
        r8.add(new EggCat());
        r8.add(new TallCat());
        r8.add(new TallCat());
        r8.add(new TallCat());
        r8.add(new TallCat());
        r8.add(new TallCat());
        r8.add(new TallCat());
        r8.add(new TallCat());
        r8.add(new TallCat());
        r8.add(new TallCat());
        r8.add(new TallCat());
        r8.add(new TallCat());
        r8.add(new TallCat());

        r9.add(new EggCat());
        r9.add(new TallCat());
        r9.add(new EggCat());
        r9.add(new TallCat());
        r9.add(new EggCat());
        r9.add(new TallCat());
        r9.add(new EggCat());
        r9.add(new TallCat());
        r9.add(new EggCat());
        r9.add(new TallCat());
        r9.add(new EggCat());
        r9.add(new TallCat());
        r9.add(new EggCat());
        r9.add(new TallCat());
        r9.add(new EggCat());
        r9.add(new TallCat());
        r9.add(new EggCat());
        r9.add(new TallCat());
        r9.add(new EggCat());
        r9.add(new TallCat());
        r9.add(new EggCat());
        r9.add(new TallCat());
        r9.add(new EggCat());
        r9.add(new TallCat());
        r9.add(new EggCat());
        r9.add(new TallCat());
        r9.add(new EggCat());
        r9.add(new TallCat());
        r9.add(new EggCat());

        r10.add(new BossCat());
        r10.add(new EggCat());
        r10.add(new EggCat());
        r10.add(new EggCat());
        r10.add(new EggCat());
        r10.add(new TallCat());
        r10.add(new TallCat());
        r10.add(new TallCat());
        r10.add(new TallCat());
        r10.add(new NormalCat());
        r10.add(new NormalCat());
        r10.add(new NormalCat());
        r10.add(new NormalCat());
        r10.add(new NormalCat());
        r10.add(new NormalCat());
        r10.add(new NormalCat());
        r10.add(new NormalCat());
        r10.add(new NormalCat());
        r10.add(new NormalCat());
        addTowerButtons();

        addObject(new Grey(), 1000, 720);
        addObject(new HealthActor(), 180, 100);
    }

    public void act()
    {
        //showText("EHEHE" + numStone + "S" + numWood + "" + numMetal,600 ,50 );
        spawnResources();
        addInTowers();

        spawnCats();
        w.getToggle();
        
    }

    public static int getHP()
    {
        return health;
    }

    public static void removeHealth()
    {
        health--;
        
        if(health <= 0)
        {
            //Greenfoot.setWorld(new LoseWorld());
        }
    }

    private void spawnCats()
    {
        showText("Round " + round, 1100, 25);
        spawnTimer--;
        if(spawnTimer <= 0)
        {
            if(round == 1)
            {
                resourceChance = 220;
                spawnTimer = 120;
                Cat c = r1.peek();
                if(c == null)
                {
                    round++;
                    spawnTimer = 400;
                }
                else
                {
                    addObject(c, 0, 600);
                    r1.remove();
                }
            }
            else if(round == 2)
            {
                spawnTimer = 110;
                Cat c = r2.peek();
                resourceChance = 300;
                if(c == null)
                {
                    round++;
                    spawnTimer = 400;
                }
                else
                {
                    addObject(c, 0, 600);
                    r2.remove();
                }
            }
            else if(round == 3)
            {
                spawnTimer = 90;
                Cat c = r3.peek();
                resourceChance = 250;
                if(c == null)
                {
                    round++;
                    spawnTimer = 400;
                }
                else
                {
                    addObject(c, 0, 600);
                    r3.remove();
                }
            }
            else if(round == 4)
            {
                spawnTimer = 90;
                Cat c = r4.peek();
                resourceChance = 300;
                if(c == null)
                {
                    round++;
                    spawnTimer = 600;
                }
                else
                {
                    addObject(c, 0, 600);
                    r4.remove();
                }
            }
            else if(round == 5)
            {
                spawnTimer = 60;
                Cat c = r5.peek();
                resourceChance = 200;
                if(c == null)
                {
                    round++;
                    spawnTimer = 400;
                }
                else
                {
                    addObject(c, 0, 600);
                    r5.remove();
                }
            }
            else if(round == 6)
            {
                spawnTimer = 50;
                Cat c = r6.peek();
                resourceChance = 400;
                if(c == null)
                {
                    round++;
                    spawnTimer = 400;
                }
                else
                {
                    addObject(c, 0, 600);
                    r6.remove();
                }
            }
            else if(round == 7)
            {
                spawnTimer = 50;
                Cat c = r7.peek();
                resourceChance = 450;
                if(c == null)
                {
                    round++;
                    spawnTimer = 400;
                }
                else
                {
                    addObject(c, 0, 600);
                    r7.remove();
                }
            }
            else if(round == 8)
            {
                spawnTimer = 10;
                Cat c = r8.peek();
                resourceChance = 600;
                if(c == null)
                {
                    round++;
                    spawnTimer = 600;
                }
                else
                {
                    addObject(c, 0, 600);
                    r8.remove();
                }
            }
            else if(round == 9)
            {
                spawnTimer = 30;
                Cat c = r9.peek();
                if(c == null)
                {
                    round++;
                    spawnTimer = 600;
                }
                else
                {
                    addObject(c, 0, 600);
                    r9.remove();
                }
            }
            else if(round == 10)
            {
                spawnTimer = 120;
                Cat c = r10.peek();
                resourceChance = 600;
                if(c == null)
                {

                }
                else
                {
                    if(c.getType() == 1)
                    {
                        addObject(c, 0, 600);
                    }
                    else if(c.getType() == 2)
                    {
                        addObject(c, 0, 600);
                    }
                    else
                    {
                        addObject(c, 0, 600);
                    }
                    r10.remove();
                }
            }

        }
    }

    //method that spawns resources 

    private void spawnResources()
    {
        spawnNumber = Greenfoot.getRandomNumber(resourceChance);
        if(spawnNumber == 1)
        {
            int type = Greenfoot.getRandomNumber(3);

            if(type == 0)
            {
                this.addObject(new Rock(), Greenfoot.getRandomNumber(1100), Greenfoot.getRandomNumber(500) + 100);
            }
            else if(type == 1)
            {
                this.addObject(new Tree(), Greenfoot.getRandomNumber(1100), Greenfoot.getRandomNumber(500) + 100);
            }
            else if(type == 2)
            {
                this.addObject(new Ore(), Greenfoot.getRandomNumber(1100), Greenfoot.getRandomNumber(500) + 100);
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

    public void addInTowers(){
        if (Greenfoot.mouseClicked(null) && Greenfoot.getMouseInfo().getActor() == null && numWood>=5 && numMetal >=2 && numStone >=1){
            addObject(new Gun(), Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
            numWood -= 5;
            numMetal -=2;
            numStone -=1;
        }
    }

    private void addTowerButtons()
    {
        
        addObject(w, 1100, 720);
        
        
        //addObject(new FactoryTowerButton(), 1000, 720);
    }

    public static void addMetal()
    {
        numMetal++;
    }

    public static void addCatFood()
    {
        numCatFood++;
    }

    public static int getCatFood()
    {
        return numCatFood;
    }

    public static void takeCatFood()
    {
        numCatFood--;
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
    public boolean getUpgrade()
    {
        return upgrading;
    }
    public static int getStone()
    {
        return numStone;
    }
}
