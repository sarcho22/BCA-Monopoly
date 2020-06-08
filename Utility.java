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
    public boolean bothUtilities = false;
    
    public Utility(String name, int spaceNumber){
        super(name, spaceNumber, "utility");
    }
    /**
     * Act - do whatever the Utility wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Player getOwner(){
        return owner;
    }
    
    public void collectRent(Player paying, int lastRoll){
        int keyNum = 4;
        if (bothUtilities){
            keyNum = 10;
        }
        owner.addMoney(lastRoll * keyNum);
        paying.subMoney(lastRoll * keyNum);
    }
    
    public void setBoth(boolean both) 
    {
        bothUtilities = both;
    }    
}
