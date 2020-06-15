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
    public Player owner = null;
    public int baseRent = 25;
    public boolean mortgaged = false;
    
    public Railroad(String name, int spaceNumber){
        super(name, spaceNumber, "railroad");
    }
    
    /**
     * Act - do whatever the Railroad wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Player getOwner(){
        return owner;
    }
    
    public void unmortgage() {
        owner.subMoney(mortgagePrice);
        mortgaged = false;
        owner.mortgagedProperties.remove(spaceNumber);
    }
    
    public void mortgage() {
        // we have to remove the capability to collect rent
        // but it does not break monopolies
        
        // add to the player's mortgaged properties list
        
        owner.addMoney(mortgagePrice);
        mortgaged = true;
        owner.mortgagedProperties.add(spaceNumber);
    }
    
    public void collectRent(Player paying, int numRoads){
        owner.addMoney(baseRent * numRoads);
        paying.subMoney(baseRent * numRoads);
    } 
}
