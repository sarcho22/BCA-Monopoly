import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OurMascot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OurMascot extends Actor
{
    /**
     * Act - do whatever the OurMascot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public OurMascot() {
        GreenfootImage img = new GreenfootImage("mascot.png");
        img.scale(img.getWidth()/10, img.getHeight()/10);
        setImage(img);
    }
    
    public void act() 
    {
        // Add your action code here.
       if(Greenfoot.mouseMoved(null))
        {
                MouseInfo mouse = Greenfoot.getMouseInfo();
                setLocation(mouse.getX(),mouse.getY());
        }
        
        ((StartingMenu)getWorld()).repaint();
    }    
}
