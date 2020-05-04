import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Food here.
 * 
 * @author Tanner Bortel 
 * @version 2.0
 */
public class Food extends Actor
{
    private int crumbs = 100;
    private int size = 30;
    private GreenfootImage image;
    /**
     * Act - do whatever the Food wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    public Food()
    //constructor
    {
         image = new GreenfootImage(size, size);
         updateImage();
    }
    private void updateImage()
    {
        Random random = new Random( );
        for(int i=1; i<=crumbs; i++)
        {
            int stDev = size / 6;
            int x = (int) (stDev * random.nextGaussian( ) + 3 * stDev);
            int y = (int) (stDev * random.nextGaussian( ) + 3 * stDev);
            
            // keep crumbs in image
            if(x < 0) 
                x = 0;
            if(x >= size) 
                x = size - 1;
            if(y < 0) 
                y = 0;
            if(y >= size) 
                y = size - 1;
     
            Color color = new Color(252, 148, 3);  // pick the color you want by replacing r, g, b with values.
            image.setColorAt(x, y, color);
        }
        setImage(image);
    }
    public void removeCrumb()
    {
        crumbs--;
        if(crumbs ==0)
        {
            getWorld().removeObject(this);
        }
        else
        {
            image.clear();
            updateImage();
        }
    }
}
