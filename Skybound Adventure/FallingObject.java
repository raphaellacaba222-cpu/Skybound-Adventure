import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FallingObject extends Actor
{
    public FallingObject()
    {
        
    }
    
    public void act()
    {
        setLocation(getX(), getY() + 2); // Falling speed
        
        if (isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
}
