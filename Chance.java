import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chance here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chance extends Space
{
    
    public ChanceDeck deck = new ChanceDeck();
    
    public Chance(String name, int spaceNumber){
        super(name, spaceNumber, "chance");
    }
    /**
     * Act - do whatever the Chance wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        //if (isOccupied()) {     <-- walk through list of players and check if any of their current spaces are the current property or something
        //    drawChanceCard();
        //}
    }
  
}
