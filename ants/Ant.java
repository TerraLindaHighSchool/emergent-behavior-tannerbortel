import greenfoot.*;

/**
 * An ant that collects food.
 * 
 * @author Tanner Bortel
 * @version 0.2
 */
public class Ant extends Creature
{
    private boolean carryingFood;
    private GreenfootImage image1;
    private GreenfootImage image2;
    /**
     * Create an ant with a given home hill. The initial speed is zero (not moving).
     */
    public Ant(AntHill home)
    {
        setHomeHill(home);
        image1 = getImage();
        image2 = new GreenfootImage("ant-with-food.gif");
        carryingFood = false;
    }

    /**
     * Do what an ant's gotta do.
     */
    public void act()
    {
        status();
    }
    private void checkForFood()
    {
        Food food = (Food) getOneIntersectingObject(Food.class);
        if (food != null)
        {
            food.removeCrumb();
            carryingFood = true;
            setImage(image2);
        }
    }
    private boolean atHome()
    {
        if (getHomeHill() != null) 
        {
            return (Math.abs(getX() - getHomeHill().getX()) < 4) && 
                   (Math.abs(getY() - getHomeHill().getY()) < 4);
        }
        else 
        {
             return false;
        }
    }
    private void searchForFood()
    {
        randomWalk();
        checkForFood();
    }
    private void status()
    {
        if(carryingFood)
        {
            walkTowardsHome();
            if(atHome())
            {
                setImage(image1);
                getHomeHill( ).countFood( );
                carryingFood = false;
            }
        }
        else
        {
            searchForFood();
        }
    }
}
