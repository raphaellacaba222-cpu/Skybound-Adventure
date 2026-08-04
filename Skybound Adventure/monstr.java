import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class monstr extends Actor
{
    
public void act()
  {lookDoodler();
     kil1();
}
/**
 * Looking for a dealer, if found - we eat, or move to the right
 */
public void lookDoodler()
{ if ( isTouching(skyler.class) ) 
    { removeTouching(skyler.class);
      killed(); 
    } 
  else {
      move (1);
    }
  
}
public void killed()
    {
        ((doodleWorld) getWorld()).killed = true;
    }
public void kil1()
{ 
    int x = getX();
    
    if (x==getWorld().getWidth()-1)
    {   Actor monstr = getOneObjectAtOffset(0, 0, monstr.class);
    }
}
    }
