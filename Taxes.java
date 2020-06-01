import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Taxes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Taxes extends Space
{
    public int amount;
    
    public Taxes(String name, int spaceNumber, int[] players, int amount){
        super(name, spaceNumber, players, "tax");
        this.amount = amount;
    }
    /**
     * Act - do whatever the Taxes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void collectTax(Player paying) 
    {
        paying.subMoney(amount);
    }    
}
