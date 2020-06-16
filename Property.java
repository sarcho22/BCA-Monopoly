import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Write a description of class Property here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * HIHIHIHI DOES GITHUB DECIDE TO WORK TODAY
 */
public class Property extends Space
{
    public int price;
    public int mortgagePrice = price / 2;
    public int spaceNumber;
    public Player owner = null;
    public int rent;
    public int numHouses = 0;
    public String color;
    public int x;
    public int y;
    public String[] COLORS = {"corner", "brown", "blank", "brown", "blank", "blank", "light_blue", "blank", "light_blue", "light_blue", "corner", "purple", "blank", "purple", "purple", "blank", "orange", "blank", "orange", "orange", "corner", "red", "blank", "red", "red", "blank", "yellow", "yellow", "blank", "yellow", "corner", "green", "green", "blank", "green", "blank", "blank", "dark_blue", "blank", "dark_blue"};
    public int[] houseRents = {rent * 5, rent * 15, rent * 45, 0, 0}; //the rent of the 4th house is strange, can't figure it out dw u can do it :3
    public boolean mortgaged = false;
    public String ownedBy = "NO ONE";
    
    public Property(String name, int spaceNumber, int price, int rent, int x, int y) {
        super(name, spaceNumber, "property");
        this.price = price;
        this.rent = rent;
        this.spaceNumber = spaceNumber;
        this.color = COLORS[spaceNumber];
        this.houseRents = houseRents;
        this.x = x;
        this.y = y;
        String[] priceColor = {"dark_blue", "green", "yellow", "red", "orange", "purple", "light_blue", "brown"};
        for (int i = 0; i < priceColor.length; i++){
            if (priceColor[i].equals(color)){
                houseRents[3] = houseRents[2] * (1 + (i + 1) / 10);
            }
        }
        houseRents[4] = houseRents[3] + 200;
        super.setInfo(name + "\nPrice: $" + price + "\nRent:\nRegular: $" + rent + "\n1 House: $" + houseRents[0] + "\n2 Houses: $" + houseRents[1] + "\n3 Houses: $" + houseRents[2] + "\n4 Houses: $" + houseRents[3] + "\nHotel: $" + houseRents[4] + "\nUpgrades cost: $" + 50 * ((spaceNumber / 10) + 1));
    }
    
    public void act(){
        if (owner != null){
            ownedBy = owner.name;
        }
    }
    
    public Player getOwner(){
        return owner;
    }
    
    public void setOwner(Player o) {
        owner = o;
    }
    
    public void collectRent(Player paying) {
        if(!mortgaged) {
            int payment = 0;
            
            if (numHouses == 5){
                
            }
            else if(numHouses == 0) {
                // checks if there is a monopoly
                //for the color of the property
                //for the appropriate Player owner
                //if yes pay: rent * 2 else rent
                payment = rent;
                if(owner.hasAMonopoly(COLORS[spaceNumber])) {
                    payment = 2*rent;
                }
            }
            else {
                payment = houseRents[numHouses-1];
            }
            owner.addMoney(payment);
            paying.subMoney(payment);
        }
    }
    
    public void purchase() {
        //changes String owner to whichever player's turn it is
        //they pay and get the rpoperty added to their property arraylist
        owner = ((Board)getWorld()).turn;
        owner.subMoney(price);
        owner.playerProperties.add(spaceNumber);
    }
    
    public void mortgage() {
        // we have to remove the capability to collect rent
        // but it does not break monopolies
        
        // add to the player's mortgaged properties list
        
        owner.addMoney(mortgagePrice);
        mortgaged = true;
        owner.mortgagedProperties.add(spaceNumber);
    }
    
    public void unmortgage() {
        owner.subMoney(mortgagePrice);
        mortgaged = false;
        owner.mortgagedProperties.remove(spaceNumber);
    }
    
    public void remHouse() {
        owner.addMoney(50 * ((spaceNumber / 10) + 1));
        numHouses--;
    }
    
    public Building buildHouse(){
        //THE SAME FOR THE HOTEL
        //there will be a build house button that is always 
        //gray, unless the conditions 
        
        //we should probs add an image for a house
        //in a new class with just the image probably
        //conditions are checked before calling 
        //(need to make sure the money condition is checked)
        numHouses++;
        owner.subMoney(50 * ((spaceNumber / 10) + 1));
        Building b;
        if(numHouses == 5) {
            b = new Hotel();
        }
        else {
            b = new House();
        }
        GreenfootImage i = new GreenfootImage(b.getImage());
        i.scale(i.getWidth() / 10, i.getHeight() / 10);
        b.setImage(i);
        return b;
    }
}
