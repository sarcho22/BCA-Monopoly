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
    public String ownedBy = "NO ONE";
    
    public Railroad(String name, int spaceNumber){
        super(name, spaceNumber, "railroad", name + "\nPrice: $" + 200 + "\nRent:\n1 Hallway: $25\n2 Hallways: $50\n3 Hallways: $100\n4 Hallways: $200");
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
    
    public void collectRent(Player paying, int numRoads){
        switch(numRoads){
            case 1:
                owner.addMoney(baseRent * numRoads);
                paying.subMoney(baseRent * numRoads);
                break;
            case 2:
                owner.addMoney(baseRent * numRoads);
                paying.subMoney(baseRent * numRoads);
                break;
            case 3:
                owner.addMoney(baseRent * 4);
                paying.subMoney(baseRent * 4);
                break;
            case 4:
                owner.addMoney(baseRent * 8);
                paying.subMoney(baseRent * 8);
                break;
            default:
                break;
        }
    } 
}
