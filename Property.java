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
    public int mortgagePrice;
    public Player owner = null;
    public int rent;
    //public int houseCost; idk if we need these
    //public int hotelCost;
    public int numHouses = 0;
    public int numHotels = 0;
    public int color;
    public String[] COLORS = {"corner", "brown", "blank", "brown", "blank", "blank", "light_blue", "blank", "light_blue", "light_blue", "corner", "purple", "blank", "purple", "purple", "blank", "orange", "blank", "orange", "orange", "corner", "red", "blank", "red", "red", "blank", "yellow", "yellow", "blank", "yellow", "blank", "green", "green", "blank", "green", "blank", "blank", "dark_blue", "blank", "dark_blue"};
    
    /**
     * Act - do whatever the Property wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Property(String name, int spaceNumber, int[] players, int price,
        int mortgagePrice, int rent, String belongsTo) {
        super(name, spaceNumber, players, "property");
        this.price = price;
        this.mortgagePrice = mortgagePrice;
        this.rent = rent;
        GreenfootImage image = new GreenfootImage(COLORS[spaceNumber] + "_property.png");
        image.scale(image.getWidth()/4, image.getHeight()/4);
        setImage(image);
        
    }
    
    public void act() 
    {
        // Add your action code here.
    } 
    
    public Player getOwner(){
        return owner;
    }
    
    public boolean hasPlayer() {
        // returns if player isTouching property
        //accesses the list of spaces in board and uses spaceNumber to 
        //find the correct Space and request if it has any players on it
        return true;
    }
    
    public void collectRent(Player paying) {
        //probably subtracts (rent + (hotel * hotelRent)) from someone's money
    }
    
    public void purchase() {
        //subtracts cost from player's money
        //probably changes String owner to whichever player's turn it is
    }
    
    public void mortgage() {
        owner = null;
        numHouses = 0;
        numHotels = 0;
    }
    
    public void buildHouse(){
        //check the conditions (probably when calling) and build the house
    }
    
    public void buildHotel(){
        //check the conditions (probably when calling) and build the hotel
    }
}
