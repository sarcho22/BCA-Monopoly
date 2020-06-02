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
    public String type;
    
    public Space(String name, int spaceNumber, String type){
        this.name = name;
        this.spaceNumber = spaceNumber;
        this.type = type;
    }
    
    public String getType(){
        return type;
    }
}
