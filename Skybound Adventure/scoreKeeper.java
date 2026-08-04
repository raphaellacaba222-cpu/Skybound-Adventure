import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class scoreKeeper  extends Actor
{
    GreenfootImage image = new GreenfootImage(100,10);
    public scoreKeeper()
    {
        setImage(image);
    }
    
    
    public void act() 
    {
        image.clear();
        image.drawString(((doodleWorld) getWorld()).height + " points.", 10,10);
        setImage(image);
    }    
}
