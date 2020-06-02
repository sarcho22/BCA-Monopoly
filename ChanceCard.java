import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chance here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChanceCard extends Card
{
    /**
     * Act - do whatever the Chance wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public String message;
    public String action;
    
    public ChanceCard (String message, String action) {
        this.message = message;
        this.action = action;
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void doAction() {
        switch(action) {
            case "add 20": //THESE ARE PLACEHOLDERS
                //add money or whatever
                break;
            case "sub 20": //THESE CAN BE CHANGED
                break;
            default:
                break;
        }
    }
}
