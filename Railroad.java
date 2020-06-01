import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Railroad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Railroad extends Space
{
    public final int price = 200;
    public final int mortgagePrice = 100;
    public Player owner;
    public int baseRent = 25;
    
    public Railroad(String name, int spaceNumber, int[] players, Player owner){
        super(name, spaceNumber, players, "railroad");
        this.owner = owner;
    }
    /**
     * Act - do whatever the Railroad wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Player getOwner(){
        return owner;
    }
    
    public void collectRent(Player paying, int numRoads){
        owner.addMoney(baseRent * numRoads);
        paying.subMoney(baseRent * numRoads);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
