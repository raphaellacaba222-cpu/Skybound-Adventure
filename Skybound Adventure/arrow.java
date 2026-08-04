import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class arrow  extends Actor
{
    boolean removed = false;
    /**
     * 
     */
    
    public arrow()
    {
        removed = false;
    }
    /**
     * check where skyler
     */
    public void act() 
    {
        setLocation(((doodleWorld) getWorld()).doodleX, 20);
    }    
}
