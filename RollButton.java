import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RollButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RollButton extends Actor
{
    /**
     * Act - do whatever the RollButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        if(Greenfoot.mousePressed(this) && !((Board)getWorld()).rolled) {
            ((Board)getWorld()).roll1 = ((Board)getWorld()).dice.roll();
            ((Board)getWorld()).roll2 = ((Board)getWorld()).dice.roll();
            ((Board)getWorld()).lastRoll = ((Board)getWorld()).roll1 + ((Board)
            getWorld()).roll2;
            ((Board)getWorld()).rolled = true;
        }
    }    
}
