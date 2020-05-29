import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    public Player owner;
    public int rent;
    //public int houseCost; idk if we need these
    //public int hotelCost;
    public int numHouses = 0;
    public int numHotels = 0;
    /**
     * Act - do whatever the Property wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Property(String name, int spaceNumber, int[] players, int price,
        int mortgagePrice, int rent) {
        super(name, spaceNumber, players);
        this.price = price;
        this.mortgagePrice = mortgagePrice;
        this.rent = rent;
    }
    
    public void act() 
    {
        // Add your action code here.
    }  
    
    public boolean hasPlayer() {
        // returns if player isTouching property
        //accesses the list of spaces in board and uses spaceNumber to 
        //find the correct Space and request if it has any players on it
        return true;
    }
    
    public void collectRent() {
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
    
    
}
