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
    
  
}
