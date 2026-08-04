import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ammo  extends Actor
{
    boolean removed;
    public ammo()
    {
        removed = false;
    }
    /**
     * kill monster1
     */
    public void act() 
    { if (foundMonstr())
    {
        kill();
    }
    if (foundMonstr1())
    {
        kill1();
    }
    if (foundFallingObject())
    {
        removeFallingObject();
    }
    if (removed)
    {
        return;
    }

    move();
}

public boolean foundFallingObject()
{
    Actor fallingObject = getOneObjectAtOffset(0, 0, FallingObject.class);
    return fallingObject != null;
}

public void removeFallingObject()
{
    Actor fallingObject = getOneObjectAtOffset(0, 0, FallingObject.class);
    if (fallingObject != null)
    {
        getWorld().removeObject(fallingObject);
    }
    }   
    /**
     * check whether the monster1 reached
     */
    public boolean foundMonstr()
    {
        Actor monstr = getOneObjectAtOffset(0, 0, monstr.class);
        return monstr != null;
    }
    /**
     * check whether the monster2 reached
     */
    public boolean foundMonstr1()
    {
        Actor monstr1 = getOneObjectAtOffset(0, 0, monstr1.class);
        return monstr1 != null;
    }
    /**
     * kill monster2
     */
    public void kill1(){
        Actor monstr1 = getOneObjectAtOffset(0, 0, monstr1.class);
        if (monstr1 != null) {
            getWorld().removeObject(monstr1);
        }
    }
    /**
     * kill monstr
     */
    public void kill()
    {
        Actor monstr = getOneObjectAtOffset(0, 0, monstr.class);
        if (monstr != null) {
            getWorld().removeObject(monstr);
        } 
    }
    /**
     * move up
     */
    public void move()
    {
        if(getY()<=0)
        {
            removed = true;
            getWorld().removeObject(this);
            return;
        }
        setLocation(getX(), getY()-10);
    }
}
