import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Utility here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Utility extends Space
{
    public final int price = 150;
    public final int mortgagePrice = 75;
    public Player owner = null;
    public int rent;
    
    public Utility(String name, int spaceNumber, int[] players, int dieRoll){
        super(name, spaceNumber, players, "utility");
        //rent will be determined based on the dieroll and utilities owned
        //one utility means rent = 4 * dieroll
        //two means rent = 10 * dieroll
    }
    /**
     * Act - do whatever the Utility wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Player getOwner(){
        return owner;
    }
    
    public void collectRent(Player paying, int lastRoll){
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
