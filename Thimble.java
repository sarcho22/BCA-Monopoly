import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Thimble extends TokenButton
{
    /**
     * Act - do whatever the Boat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public String name;
    
    public Thimble(String player) {
        this.name = player;
    }
    
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mousePressed(this)) {
            super.thimble = true;
            super.updateTaken(name, "thimble");
        }
    }    
}
