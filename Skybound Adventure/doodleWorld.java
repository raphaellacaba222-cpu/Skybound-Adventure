import greenfoot.*;  

public class doodleWorld  extends World
{
   
    boolean bStarted, started = false;
    boolean once;
    int transparency = 0;
    int scrollSpeed;
    boolean scroll;
    boolean fall;
    boolean ended;
    boolean killed;
    int height = 0;
    int doodleX;
    
    public doodleWorld()
    {    
        super(300,400, 1,false); 
        addObject(new ground(), 56, 317);
        addObject(new skyler(false), 56,200);
        setPaintOrder(scoreKeeper.class, skyler.class, ground.class, ammo.class);
        setBackground("title.jpg");
        getBackground().setTransparency(255);
        once = true;
        started = false;
        height = 0;
        fall = false;
        ended = false;
        killed = false;
    }

    public void act()
    {
        /**
         *Create new monsters
         */
        { if (Greenfoot.getRandomNumber(1000) > 998 & started==true) 
            {
               int x = Greenfoot.getRandomNumber(300);
               int y = Greenfoot.getRandomNumber(150);
               addObject(new monstr(), x, y);
        }
    }
        { if (Greenfoot.getRandomNumber(1000) > 998 & started==true) 
            {
               int x = Greenfoot.getRandomNumber(300);
               int y = Greenfoot.getRandomNumber(150);
               addObject(new monstr1(), x, y);
        }
    }
        //falling objects
    if (Greenfoot.getRandomNumber(1000) > 995 & started == true)
    {
        int x = Greenfoot.getRandomNumber(300);
        addObject(new FallingObject(), x, 0);
    }
        /**
         *the user must press the mouse button to start the game
         */
        if(bStarted==false & Greenfoot.mouseMoved(this))
        {
            bStarted = true;
        }

        /**
         *button on the splash screen
         */
        if(started==false & bStarted==true)
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();

            if(Greenfoot.mouseClicked(this))
            {
                if(mouse.getX()>=50 & mouse.getX()<=145
                && mouse.getY()>=150 & mouse.getY()<=230)
                {
                    started = true;
                }
            }
        }
        /**
         *Move to the beginning of the game
         */
        if(started==true & once==true)
        {
            setBackground("maxresdefault.jpg");
            cleanup();
            once = false;
            setLevel(1);
        }
        if(fall)
        {
            end();
        }
        if(killed)
        {
            end();
        }
    }

    /**
     *Remove objects from the screen
     */
    public void cleanup()
    {
        removeObjects(getObjects(skyler.class));
        removeObjects(getObjects(ground.class));
    }

    /**
     *Generation level. we have implemented only one level
     */
    public void setLevel(int level)
    {
        switch(level)
        {
            case 1: gamePlay(); break;
        }
    }

    /**
     *Start of game
     */
    public void gamePlay()
    {
        addObject(new skyler(), getWidth()/2, 300);
        addObject(new ground(false), 28,391);
        addObject(new ground(false), 83,391);
        addObject(new ground(false), 83+55,391);
        addObject(new ground(false), 83+55+55,391);
        addObject(new ground(false), 83+55+55+55,391);
        addObject(new ground(false), 83+55+55+55+55,391);
        
        addObject(new ground(), Greenfoot.getRandomNumber(300), 250);
        addObject(new ground(), Greenfoot.getRandomNumber(300), 150);
        addObject(new ground(), Greenfoot.getRandomNumber(300), 50);
        addObject(new scoreKeeper(), 253,385);
    }
    /**
     *End of game
     */
    public void end()
    {
        cleanup();
        started=false;
        bStarted=false;
        addObject(new ground(), 56, 317);
        addObject(new skyler(false), 56,200);

        setBackground("title.jpg");
        getBackground().setTransparency(255);
        once = true;
        started = false;
        height = 0;
        fall = false;
        killed = false;
        ended = false;
    }
}
