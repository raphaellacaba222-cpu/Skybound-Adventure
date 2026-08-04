import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ground  extends Actor
{
    boolean hasBeenBounced;
    int x_pos, y_pos;
    

    public ground()
    {
        GreenfootImage image = new GreenfootImage(60, 10);
        image.setColor(Color.GREEN);
        image.fillRect(0, 0, 60, 10);
        setImage(image);
        hasBeenBounced=false;
    }

    public ground(boolean bouncable)
    {
        hasBeenBounced=true;
    }

    /**
     * If doodlers moves \ falls, respectively, moving ground
     */
    public void act() 
    {
        if(((doodleWorld) getWorld()).scroll==true)
        {
            scroll(((doodleWorld) getWorld()).scrollSpeed);
        }

        if(((doodleWorld) getWorld()).fall==true)
        {
            fall(((doodleWorld) getWorld()).scrollSpeed);
        }

        if(y_pos < 0)
        {
            getWorld().removeObject(this);
            return;
        }
    }    

    protected void addedToWorld(World world)
    {
        x_pos = getX();
        y_pos = getY();
    }

    /**
     * We move the ground to simulate motion
     */
    public void scroll(int speed)
    {
        if(speed>0)
        {
            y_pos = y_pos + speed;
            setLocation(x_pos, y_pos);
        }
    }

    /**
     * until the game is stopped, we move the ground along the y axis,
     * simulating the movement of the screen
     */
    public void fall(int speed)
    {
        if(((doodleWorld) getWorld()).ended==false)
        {
            y_pos = y_pos + speed;
            setLocation(x_pos, y_pos);
        }
    }
}
