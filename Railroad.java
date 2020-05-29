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
    public int rent;
    
    public Railroad(String name, int spaceNumber, int[] players, Player owner){
        super(name, spaceNumber, players);
        this.owner = owner;
        //rent = 25 * railOwned;
        //need to determine how many railroads its owner owns 
        //as a note, if fee = 0 you can buy it
    }
    /**
     * Act - do whatever the Railroad wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
