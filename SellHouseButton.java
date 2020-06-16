import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SellHousebutton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SellHouseButton extends Actor
{
    /**
     * Act - do whatever the SellHousebutton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public SellHouseButton() {
        GreenfootImage i = new GreenfootImage(getImage());
        i.scale((int)(i.getWidth() / 7), (int)(i.getHeight() / 7));
        setImage(i);
    }
    
    public void act() 
    {
        if (Greenfoot.mousePressed(this)) {
            ((Board)getWorld()).askToRemHouse();
        }
    }     
}
