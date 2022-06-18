/**
 * Write a description of class Code here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
/**    
    public class Code  
    {
        // instance variables - replace the example below with your own
        private int x;
    
        /**
         * Constructor for objects of class Code
         */
        public Code()
        {
        }
    
        /**
         * An example of a method - replace this comment with your own
         * 
         * @param  y   a sample parameter for a method
         * @return     the sum of x and y 
         */
        /**
        public int sampleMethod(int y)
        {
            //To make sure the bullet does not kill the object shooting it. 
            immuneTimer--;
    
            //If the bullet has not found a target.
            if(target)
            {
                target = false;
    
                //targets class
                targetClosest();
                if(targetCat != null && targetCat.getWorld() != null)
                {
                    turnTowardsTarget();
    
                    //Important: Set image only after the target has been confirmed. 
                    setImage(image);
    
                }
                else
                {
                    target = true;
    
                }
    
            }
            //makes the bullet move
            move (3);
    
            //If any of these objects are touching the bullet the bullet will kill them. 
    
            if(target == true)
            {   
    
                getWorld().removeObject(this);
            }
    
            else if(getWorld() != null)
            {
                Cat c = (Cat)getOneIntersectingObject(Cat.class);
                if(c != null)
                {
                    c.damage(damage);
                    getWorld().removeObject(this);
                }
    
                if(getWorld() != null)
                {
                    if (getY() <= -10 || getY() >= 810 )
                    {
                        getWorld().removeObject(this);
    
                    } 
                    else if (getX() >= 1210 || getX() <= -10)
                    {
                        getWorld().removeObject(this);
    
                    }
                }
            }
    
            else
            {
    
                //remove if outside world. 
    
            }
        }
    }
**/