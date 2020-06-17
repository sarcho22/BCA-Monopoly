import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ListPropertiesButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListPropertiesButton extends Actor
{
    public ListPropertiesButton() {
        GreenfootImage i = new GreenfootImage(getImage());
        i.scale((int)(i.getWidth() / 6), (int)(i.getHeight() / 6));
        setImage(i);
    }
    
    public void act() 
    {
        if (Greenfoot.mousePressed(this)) {
            ((Board)getWorld()).listProperties();
        }
    }    
}
