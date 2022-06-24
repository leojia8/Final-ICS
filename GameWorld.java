import greenfoot.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

/**
 * Battle Cats Tower Defense x Survival Game!!!
 * 
 * Features:
 *  - Story explaining background of game + instructions.
 *  - Cats try to traverse the path to get to the other side, which damages the player.
 *  - Cats spawn every round and there is a rest period in between rounds
 *  
 *  CHEAT FEATURE MR COHEN!!!
 *  There is a button in the WelcomeWorld to skip to the boss. There is a wait period for you to prepare your resources before it spawns
 *  
 *  - There are 4 subclasses of Cat: BossCat, TallCat, EggCat and NormalCat, each with their own stats.
 *  - BossCat is the boss spawned on round 10, the last round. It has many extra functionalities and abilities, including a stun
 *  effect, a spawning effect and several cool visual effects. There is a button to skip directly too it in the Welcome World.
 *  effect, a spawning effect, teleportation, etc. There is a button to skip directly too it in the welcome world.
 *  - The player moves around using WASD, and uses space bar to collect resources, which spawn randomly around the map.
 *  - The player can use those resources to make towers to defend themselves against the evil cat hordes. Some towers attack, while others generate catfood
 *  - The player can use those resources to make towers to defend themselves against the evil cat hordes. The penguin towers attack, while the factory generates
 *  income.
 *  - One tower, the factory tower, creates a special resource called cat food, which is used to upgrade the water tower into a Paragon, which is
 *  imperative to your success (Catfood can also be used to upgrade the damage of a tower)
 *  - IMPORTANT NOTE: The upgrade option will not show unless you have the required Catfood
 *  - The Paragon absorbs other towers when it is created. The more towers sacrificed, the more powerful it is.
 *  - Towers are placed with LMB, and an upgrade menu will pop up if you click on them and you have enough cat food for the upgrades - 1 cat food
 *  for 3x damage, and 30 cat food to become a Paragon. There are icons in the bottom right that you can click to toggle between which towers you 
 *  are currently able to place.
 *  - Towers can only be placed in the grey circle around the player, and be placed on any entities (including the path) at all.
 *  - The player wins by eliminating the cat boss.
 *  - If the cats touch the player, the player will be damaged. 
 *  - If a cat gets to the other side, the player will be damaged
 *  - You lose if you hit 0 HP
 *  - The boss cat will insta kill you if it reaches the other side
 *  - The player wins by eliminating the Boss Cat (Round 10).
 *  
 *  Strategy:
 *  IF YOU WANT TO BEAT THE BOSS. You need a lot of DPS. The best way to do this is to spam Penguin Towers and have one of them
 *  upgrade to a Paragon absorbing all the other Penguin Towers. Paragons increase in DPS exponentially with the number of Penguin Towers
 *  absorbed. Since you need CatFood to create a Paragon, you will have to place down FactoryTowers to have a stable income of CatFood.
 *  Make sure you don't get too focused on income, you might not have enough Penguins down to fend off the cats!
 *  
 * Credit:
 *  - All tower graphics drawn by Ivan Cai.
 *  - Player graphics all drawn by Ivan Cai.
 *  - Cat graphics courtesy of Battle Cats Fandom, https://battle-cats.fandom.com/wiki/Battle_Cats_Wiki
 *  - Most other graphics of resources, projectiles, etc. designed by our group (mostly Ivan).
 * 
 * Bugs:
 *  - If the world does not initialize on it's own, initialize the WelcomeWorld to start the game.
 *  - Save Feature: Save the highscore (We could not get this to work but you said we could skip this part without any deductions)
 * 
 * 
 * 
 * 
 * @author Thomas Yang, Ivan Cai, Angus Feng, Leo Jia 
 * @version June 2022
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
    private static int round;
    private GreenfootSound bossMusic;
    private GreenfootSound normalMusic;
    private boolean stoppedMusic;
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
    private static boolean upgrading;
    private static boolean waterTowerToggle = true;
    private static boolean factoryTowerToggle = false;
    /**
     * Constructor for objects of class GameWorld
     * this adds the player into the game
     * This sets up the game with starter materials setting the round and health 
     */
    public GameWorld()
    {
        super(1200, 800, 1, false); 
        addObject(new Player(), 500, 400);

        upgrading = false;
        
        levelConstructor();

        spawnTimer = 1500;
        numStone = 5;
        numWood = 5;
        numMetal = 5;
        numCatFood = 0;
        round = 1;
        health = 10;
        resourceChance = 100;
        normalMusic = new GreenfootSound("gamemusic.mp3");
        bossMusic = new GreenfootSound("bossmusic.mp3");
        //normalMusic.setVolume(50);
        bossMusic.setVolume(20);

        addObject(counter, 700, 40);
        stoppedMusic = false;
        setPaintOrder(ScoreBoard.class, ParagonButton.class, UpgradeButton.class, CancelButton.class, Missile.class, Counter.class, BossCat.class, Cat.class, StatBar.class, Red.class, Projectile.class,Player.class, TowerButton.class,BossRing.class, BossAttack.class, Explosion.class, Tower.class, WhiteOut.class, Square.class, Grey.class  );
        r1.add(new NormalCat());
        r1.add(new NormalCat());
        r1.add(new NormalCat());
        r1.add(new NormalCat());
        r1.add(new NormalCat());

        r2.add(new TallCat());
        r2.add(new NormalCat());
        r2.add(new NormalCat());
        r2.add(new TallCat());
        r2.add(new TallCat());
        r2.add(new NormalCat());
        r2.add(new NormalCat());
        r2.add(new TallCat());
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
        r3.add(new EggCat());
        r3.add(new EggCat());
        r3.add(new EggCat());
        r3.add(new EggCat());

        r4.add(new EggCat());
        r4.add(new EggCat());
        r4.add(new EggCat());
        r4.add(new EggCat());
        r4.add(new TallCat());
        r4.add(new TallCat());
        r4.add(new TallCat());
        r4.add(new TallCat());
        r4.add(new TallCat());
        r4.add(new TallCat());
        r4.add(new EggCat());
        r4.add(new EggCat());
        r4.add(new EggCat());
        r4.add(new EggCat());

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
        r10.add(new EggCat());
        r10.add(new EggCat());
        r10.add(new TallCat());
        r10.add(new TallCat());
        r10.add(new TallCat());
        r10.add(new TallCat());
        addTowerButtons();

        //addObject(new Grey(), 1000, 720);
        addObject(new HealthActor(), 180, 100);
        addObject(w, 1100, 720);
        addObject(new FactoryTowerButton(), 950, 720);
        upgrading = false;
        startedT();
    }
    
    /**
     * Spawns resources and cats, and checks if the player has lost.
     */
    public void act()
    {
        
        spawnResources();
        

        spawnCats();
        
        if(health <= 0)
        {
            bossMusic.stop();
            normalMusic.stop();
            Greenfoot.setWorld(new LoseWorld());
            
        }
    }

    /**
     * Plays boss music if there is a boss, otherwise plays the regular music.
     */
    public void startedT()
    {
        if(stoppedMusic)
        {
            bossMusic.playLoop();
        }
        else
        {
            normalMusic.playLoop();
        }

    }

    /**
     * Stops all music.
     */
    public void stopped()
    {
        normalMusic.pause();
        bossMusic.pause();
    }

    /**
     * Returns the amount of cat food that the player has.
     * 
     * @return The amount of cat food.
     */
    public static int getCatFood()
    {
        return numCatFood;
    }

    /**
     * Returns the HP of the player.
     * 
     * @return The amount of HP of the player.
     */
    public static int getHP()
    {
        return health;
    }

    /**
     * Setter method to decrement the amount of health the player has.
     */
    public static void removeHealth()
    {
        health--;

        
    }

    /**
     * Spawns cats based on the round number and the lists initialized in the constructor of the world.
     */
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
                    List objectslookingfor = getObjects(Cat.class);
                    if (objectslookingfor.size() <= 0)
                    {
                        round++;
                    }
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
                    List objectslookingfor = getObjects(Cat.class);
                    if (objectslookingfor.size() <= 0)
                    {
                        round++;
                    }
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
                    List objectslookingfor = getObjects(Cat.class);
                    if (objectslookingfor.size() <= 0)
                    {
                        round++;
                    }
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
                    //Code Borrowed from DanPost 
                    List objectslookingfor = getObjects(Cat.class);
                    if (objectslookingfor.size() <= 0)
                    {
                        round++;
                    }
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
                    List objectslookingfor = getObjects(Cat.class);
                    if (objectslookingfor.size() <= 0)
                    {
                        round++;
                    }
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
                    List objectslookingfor = getObjects(Cat.class);
                    if (objectslookingfor.size() <= 0)
                    {
                        round++;
                    }
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
                    List objectslookingfor = getObjects(Cat.class);
                    if (objectslookingfor.size() <= 0)
                    {
                        round++;
                    }
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
                    List objectslookingfor = getObjects(Cat.class);
                    if (objectslookingfor.size() <= 0)
                    {
                        round++;
                    }
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
                spawnTimer = 18;
                Cat c = r9.peek();
                if(c == null)
                {
                    List objectslookingfor = getObjects(Cat.class);
                    if (objectslookingfor.size() <= 0)
                    {
                        round++;
                    }
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
                if(stoppedMusic == false)
                {
                    stoppedMusic = true;
                    normalMusic.stop();
                    bossMusic.playLoop();
                }
                spawnTimer = 120;
                Cat c = r10.peek();
                resourceChance = 600;
                if(c == null)
                {
                    List objectslookingfor = getObjects(Cat.class);
                    if (objectslookingfor.size() <= 0)
                    {
                        bossMusic.stop();
                        Greenfoot.setWorld(new WinWorld());
                        
                    }

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

    
    /**
     * Method that spawns resources
     */
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

    /**
     * Creates the path using a 2d array which holds all of the path square locations.
     */
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
    /**
     * Borrowed from Mr. Cohen. Method makes the world get the distance between two objects.
     */
    public static float getDistance (Actor a, Actor b)
    {
        double distance;
        double xLength = a.getX() - b.getX();
        double yLength = a.getY() - b.getY();
        distance = Math.sqrt(Math.pow(xLength, 2) + Math.pow(yLength, 2));
        return (float)distance;

    }
    
    /**
     * Sets the amount of health the player has to 0.
     */
    public static void setLives0()
    {
        health = 0;
    }
    

    private void addTowerButtons()
    {

        

        //addObject(new FactoryTowerButton(), 1000, 720);
    }

    /**
     * Method to increase the amount of metal the player has.
     */
    public static void addMetal()
    {
        numMetal++;
    }

    /**
     * Method to increase the amount of cat food the player has.
     */
    public static void addCatFood()
    {
        numCatFood++;
    }
    
    /**
     * Method to reduce the amount of cat food the player has by 30. Used when upgrading water towers to paragons.
     */
    public static void takeCatFood30()
    {
        numCatFood = numCatFood - 30;
    }
    
    /**
     * Method to decrease the amount of cat food the player has.
     */
    public static void takeCatFood()
    {
        numCatFood--;
    }

    /**
     * Method to increase the amount of wood the player has.
     */
    public static void addWood()
    {
        numWood++;
    }

    /**
     * Method to increase the amount of stone the player has.
     */
    public static void addStone()
    {
        numStone++;
    }

    /**
     * Method to decrease the amount of metal the player has.
     */
    public static void takeMetal()
    {
        numMetal--;
    }

    /**
     * Getter method which returns the amount of metal that the player has.
     * 
     * @return The amount of metal the player has.
     */
    public static int getMetal()
    {
        return numMetal;
    }

    /**
     * Method to decrease the amount of wood the player has.
     */
    public static void takeWood()
    {
        numWood--;
    }

    /**
     * Getter method which returns the amount of wood that the player has.
     * 
     * @return The amount of wood the player has.
     */
    public static int getWood()
    {
        return numWood;
    }

    /**
     * Sets upgrading to true if a tower is being upgraded.
     */
    public static void upgrading()
    {
        upgrading = true;
    }

    /**
     * Method to decrease the amount of stone the player has.
     */
    public static void takeStone()
    {
        numStone--;
    }

    /**
     * Getter method to see whether or not a tower is upgrading.
     * 
     * @return Whether or not the tower is being upgraded.
     */
    public static boolean isUpgrading()
    {
        return upgrading;
    }

    /**
     * Sets upgrading to false after the tower is done upgrading.
     */
    public static void stopUpgrading()
    {
        upgrading = false;
    }

    /**
     * Getter method which returns the amount of stone the player has.
     * 
     * @return The amount of stone the user has.
     */
    public static int getStone()
    {
        return numStone;
    }

    /**
     * Getter method which returns the round number.
     * 
     * @return The round number.
     */
    public static int getRound()
    {
        return round;
    }
    
    /**
     * Method used to immediately send the user to the last round.
     */
    public static void cheatRound(){
        round = 10;
    }
    
    /**
     * Used when the factory button is clicked
     */
    public static void toggleFactory(){
        factoryTowerToggle = true;
        waterTowerToggle = false;
    }
    
    /**
     * Used when the water button is clicked
     */
    public static void toggleWater(){
        waterTowerToggle = true;
        factoryTowerToggle = false;
    }
    
    /**
     * Returns whether or not the water tower button has been toggled
     * 
     * @return Whether or not the water tower button was toggled.
     */
    public static boolean getWater(){
        return waterTowerToggle;
    }
    
    /**
     * Returns whther or not the factory tower button has been toggled
     * 
     * @return Whether or not the factory tower button has been toggled.
     */
    public static boolean getFactory(){
        return factoryTowerToggle;
    }
    
}
