import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Go here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Go extends Corner
{
    public int bonus = 200;
    public Go(){
        super("Go", 0, "go", "School year starts!\nYou collected $200!");
        //needs to add bonus to those that just landed or crossed it
    }
    /**
     * Act - do whatever the Go wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int getBonus() 
    {
        return bonus;
    }    
}
