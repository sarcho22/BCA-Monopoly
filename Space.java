import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Space extends Actor
{
    public String name;
    public int spaceNumber;
    public int[] players;
    public boolean occupied;
    
    public Space(String name, int spaceNumber, int[] players){
        this.name = name;
        this.spaceNumber = spaceNumber;
        this.players = players;
    }
    
    public void isOccupied(){
        occupied = players.length > 0;
    }
}
