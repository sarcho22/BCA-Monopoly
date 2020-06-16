import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RollButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndButton extends Actor
{
    /**
     * Act - do whatever the RollButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (Greenfoot.mousePressed(this)) {
            ((Board)getWorld()).turnOver = true;
            ((Board)getWorld()).player++;
            if (((Board)getWorld()).player >= ((Board)getWorld()).players.size()) {
                ((Board)getWorld()).player = 0;
            }
            ((Board)getWorld()).removeObject(((Board)getWorld()).propInfo);
            ((Board)getWorld()).removeObject(this);
        }
    }
}
