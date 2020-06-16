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
    public boolean mortgaged = false;
    public String ownedBy = "NO ONE";
    
    public Utility(String name, int spaceNumber){
        super(name, spaceNumber, "utility");
        super.setInfo(name + "\nPrice: $" + price + "\nRent: 4 times the last roll if 1 Caf owned\n10 times the last roll if 2 Cafs owned");
    }
    
    public void act(){
        if (owner != null){
            ownedBy = owner.name;
        }
    }
    
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
